package cc.hdp.dao;
import com.jcraft.jsch.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

/**
 * Created by hbase on 2016/7/4.
 */
public class ExecShell {
private String ip;
private int port = 22;
private String user;
private String password;

private Session session;
private ChannelShell channel;
private static final long DEFAULT_TIMEOUT = 1000;
private StringBuffer sb = new StringBuffer();

public ExecShell(String ip, int port, String user, String password) {
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
//                System.out.println(sb.toString());
sb.append(msg).append("\n");
            }
//sb.deleteCharAt(sb.length()-1);

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
public static void main(String[] args){
    ExecShell shell = new ExecShell("192.168.11.146",22,"root","hadoop");
    String cmd = "ls -lr /root";
    shell.exec(cmd);

	//结果
	System.out.println(shell.getResponse());

    shell.disconnect();
}
}