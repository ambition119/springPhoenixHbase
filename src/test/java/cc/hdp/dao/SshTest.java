package cc.hdp.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

import cc.hdp.util.SshCmdUtil;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SshTest {
	private String ip;
	private int port = 22;
	private String user;
	private String password;

	private Session session;
	private ChannelShell channel;
	private static final long DEFAULT_TIMEOUT = 1000;
	private StringBuffer sb = new StringBuffer();

	public SshTest(String ip, int port, String user, String password) {
		this.ip = ip;
		this.port = port;
		this.user = user;
		this.password = password;
	}


	//执行命令
	public void exec(String cmd){
		JSch jSch = new JSch();
		try {
		session = jSch.getSession(user,ip,port);
		            Properties config = new Properties();
		//设置 SSH 连接时不进行公钥确认
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
		session.setPassword(password);
		session.connect();
	
		//打开命令执行管道
		ChannelExec channel = (ChannelExec) session.openChannel("exec");
	
		BufferedReader in = new BufferedReader(new InputStreamReader(channel.getInputStream()));
		//使用多个命令用分号隔开
		channel.setCommand(cmd);
		channel.connect();
		//读取命令输出信息
		String msg;
		while ((msg = in.readLine()) != null) {
						sb.append(msg).append("\n");
		}

			
		System.out.println(channel.getExitStatus());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	//获取服务器返回信息
	public  String getResponse(){
		return sb.toString();
	}

	//关闭ssh远程连接
	public void  disconnect(){
		if(channel != null){
			channel.disconnect();
		}
		if (session != null){
			session.disconnect();
		}
	}

	public static void main(String[] args) {
//		SshTest shell = new SshTest("192.168.11.146",22,"root","hadoop");
	    String cmd = "/root/ssh.sh";
//	    shell.exec(cmd);
//	    System.out.print(SshTest.class.getClassLoader().getResource("/").getPath());
//	    shell.disconnect();
	    
	    System.out.println(SshCmdUtil.exec(cmd));
	    System.out.println(SshCmdUtil.getStats());
	    System.out.print(SshCmdUtil.getResponse());
	}
}
