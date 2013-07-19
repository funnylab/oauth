package com.bluedigm.funnylab.oauth.login.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bluedigm.funnylab.oauth.common.security.account.IChangePassword;

@Controller
@RequestMapping(value = " /login")
public class LoginController{

	@RequestMapping("/loginPage")
	public ModelAndView home(){
		ModelAndView mav = new ModelAndView("/login/login");
		return mav;
	}
}
