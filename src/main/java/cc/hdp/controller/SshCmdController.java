package cc.hdp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cc.hdp.entity.SparkCmd;
import cc.hdp.util.ConvertUtils;
import cc.hdp.util.SshCmdUtil;

@Controller  
@RequestMapping("/ssh")  
public class SshCmdController {
	
	@RequestMapping("/view.do")
	public String sshView(){
		return "sshcmd";
	}
	
	@RequestMapping("/run.do")
	public String register(SparkCmd cmd){

 //		System.out.println(cmd.toString());
		ConvertUtils.nullConverNullString(cmd);
//		System.out.println(cmd.toString());
//		System.out.println(SshCmdUtil.exec(cmd.toString()));
		System.out.println(SshCmdUtil.exec("ls -lr /"));
		System.out.println(SshCmdUtil.getResponse());
		return "ok";
	}
}