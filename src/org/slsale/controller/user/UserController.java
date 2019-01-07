package org.slsale.controller.user;

import org.apache.log4j.Logger;
import org.slsale.pojo.user.User;
import org.slsale.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	private static final Logger LOGGER=Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/index.html")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/login.html")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/dologin.html")
	public ModelAndView dologin(User user) {
		LOGGER.debug("doLogin==============>loginCode:"+user.getLoginCode()+",password:"+user.getPassword());
		try {
			user = userService.getLoginUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView model = new ModelAndView("loginsuccess");
		model.addObject("user", user);
		return model;
	}
	
	@RequestMapping("/exit.html")
	public String exit() {
		return "exit";
	}
	
	@RequestMapping("/register.html")
	public String register() {
		return "register";
	}
	
	@RequestMapping("doregister.html")
	public ModelAndView doregister(User user) {
		LOGGER.debug("doregister==============>loginCode:"+user.getLoginCode()+",password:"+user.getPassword()+
				",userName"+user.getUserName());
		int count = 0;
		try {
			count = userService.addUser(user);
			if (count>0) {
				user = userService.getLoginUser(user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView model = new ModelAndView("regsuccess");
		return model;
	}

}
