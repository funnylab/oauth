package com.bluedigm.funnylab.oauth.login.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bluedigm.funnylab.oauth.common.security.account.IChangePassword;


@Controller
@RequestMapping(value = "/account")
public class AccountController {

	@Autowired
	private IChangePassword iChangePassword;
	
	@RequestMapping(value = "/changePassword",method = { RequestMethod.GET})
	public ModelAndView getChangePassword(){
		return new ModelAndView("/account/changePassword");
	}
	
	@RequestMapping(value = "/changePassword", method = { RequestMethod.POST})
	public ModelAndView setPassword(@RequestParam("oldpassword") String oldPassword, @RequestParam("password") String newPassword){
		
		iChangePassword.changePassword(oldPassword, newPassword);
		SecurityContextHolder.clearContext();

		
		return new ModelAndView("/login/login");
	}
}
