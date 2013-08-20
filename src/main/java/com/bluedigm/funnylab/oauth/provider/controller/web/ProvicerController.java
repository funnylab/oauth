package com.bluedigm.funnylab.oauth.provider.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bluedigm.funnylab.oauth.common.controller.AbstractController;
import com.bluedigm.funnylab.oauth.provider.model.ProviderList;
import com.bluedigm.funnylab.oauth.provider.service.ProviderService;

@Controller
@RequestMapping(value = "/provider")
public class ProvicerController extends AbstractController{

	@Autowired
	private ProviderService providerService;
	
	@RequestMapping(value = "/createProvider", method = RequestMethod.GET )
	public ModelAndView createProviderView(HttpServletRequest request, HttpServletResponse response,ProviderList providerList) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		log.debug("Controller : createProvider Get Method ");
		providerService.getProviderList(providerList);
		
		return mav;
	}
	
	@RequestMapping(value = "/createProvider", method = RequestMethod.POST )
	public ModelAndView createProvider(HttpServletRequest request, HttpServletResponse response,ProviderList providerList) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		log.debug("Controller : createProvider Post Method ");
		providerService.getProviderList(providerList);
		
		return mav;
	}

	@RequestMapping("getProviderList")
	public ModelAndView getProviderList(HttpServletRequest request, HttpServletResponse response,ProviderList providerList) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		log.debug("Controller : getProviderList ");
		providerService.getProviderList(providerList);
		
		return mav;
	}
	
	@RequestMapping("getProvider")
	public ModelAndView getProvider(HttpServletRequest request, HttpServletResponse response,ProviderList providerList) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		log.debug("Controller : getProvider ");
		providerService.getProviderList(providerList);
		
		return mav;
	}
	
}
