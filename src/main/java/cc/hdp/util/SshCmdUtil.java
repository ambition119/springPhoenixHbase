package cc.hdp.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SshCmdUtil {
	private static String sparkHome;
	private static String username;
	private static String password;
	private static int port;
	private static String server;
	private static final int DEFAULT_TIMEOUT = 30 * 1000;
	private static StringBuffer sb = new StringBuffer();
	private static Session session;
	private static ChannelExec channel;
	
	static{
		Properties props = new Properties();
		try {
			props.load(SshCmdUtil.class.getClassLoader().getResourceAsStream("ssh.properties"));
			sparkHome= props.getProperty("SPARK_HOME");
			username = props.getProperty("username");
			password = props.getProperty("password"); 
			port = Integer.parseInt(props.getProperty("port")); 
			server = props.getProperty("server"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int exec(String cmd){
		JSch jSch = new JSch();
		try {
			session = jSch.getSession(username, server, port);
            Properties config = new Properties();
			//设置 SSH 连接时不进行公钥确认
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.setPassword(password);
			session.setTimeout(DEFAULT_TIMEOUT);
			session.connect();
			
			//打开命令执行管道
			channel = (ChannelExec) session.openChannel("exec");
//			Channel channel = session.openChannel("shell");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(channel.getInputStream()));
		
			
			channel.setCommand(cmd);
//			System.out.println(sparkHome+"/bin/spark-submit"+cmd);
			channel.connect();
			
			//读取命令输出信息
			String msg;
			while ((msg = in.readLine()) != null) {
					sb.append(msg).append("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//断开连接
			if(channel != null){
				channel.disconnect();
			}
			if (session != null){
				session.disconnect();
			}
		}
		//正常返回0
		return channel.getExitStatus();
	}
	
	//获取服务器返回信息
	public static  int getStats(){
		return channel.getExitStatus();
	}
	
	//获取服务器返回信息
	public static  String getResponse(){
		return sb.toString();
	}
}
