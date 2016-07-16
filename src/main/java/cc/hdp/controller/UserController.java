package cc.hdp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cc.hdp.entity.User;
import cc.hdp.service.UserService;

@Controller  
@RequestMapping("/user")  
public class UserController {
	@Autowired(required=true)
	private UserService userService;
	
	@RequestMapping("/test.do")
	public String loginView(ModelMap model){
		model.addAttribute("message", "Spring 3 MVC Hello World");  
		return "test";
	}
	
	@RequestMapping("/view.do")
	public String registerView(){
		return "register";
	}
	
	@RequestMapping("/register.do")
	public ModelAndView register(User user){
		ModelAndView mav = new ModelAndView();
		System.out.println(user);
		try {
			userService.addUser(user);
			mav.setViewName("ok");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("register");
			mav.addObject("errorMsg","用户名已被占用，请更换！！");
			return mav;
		}
	}
	
	@RequestMapping("/list.do")
	public ModelAndView list(String id,String name){
		ModelAndView mav = new ModelAndView();
		List<User> findAll = userService.findAll();	
		mav.addObject("findAll", findAll);
		mav.setViewName("list");
		return mav;
	}
	
}
