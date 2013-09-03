package com.bluedigm.funnylab.oauth.provider.controller.web;

import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bluedigm.funnylab.oauth.common.controller.AbstractController;
import com.bluedigm.funnylab.oauth.common.util.ConstantResource;
import com.bluedigm.funnylab.oauth.provider.model.Service;
import com.bluedigm.funnylab.oauth.provider.model.ServiceList;
import com.bluedigm.funnylab.oauth.provider.service.ProviderService;

@Controller
@RequestMapping(value = "/provider")
public class ProviderController extends AbstractController{

	/** The Message accessor. */
	@Resource
	private MessageSourceAccessor accessor;
	
	@Autowired
	private ProviderService providerService;
	
	@Autowired
	private Environment env;
	
	
	@RequestMapping("getProviderList")
	public ModelAndView getProviderServiceList(HttpServletRequest request, HttpServletResponse response,ServiceList serviceList) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		log.debug("Controller : getProviderList ");
		log.debug("Controller : getCurrentPage " + serviceList.getCurrentPage());
		
		List<Service> list = providerService.getServiceList(serviceList);
		log.debug("Controller : list size()" + list.size());
		serviceList.setService(list);
		int totalCnt = providerService.getServiceTotalCnt(serviceList);
		log.debug("Controller : totalCnt " + totalCnt);
		serviceList.setAllCount(totalCnt);
		
		mav.addObject("providers", serviceList);

		return mav;
	}
	
	@RequestMapping(value = "/createProvider", method = RequestMethod.GET )
	public ModelAndView createProviderServiceView(HttpServletRequest request, HttpServletResponse response,ServiceList providerList) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		log.debug("Controller : createProvider Get Method ");
		mav.setViewName("provider/createProvider");
		return mav;
	}

	@RequestMapping(value = "/createProvider", method = RequestMethod.POST )
	public ModelAndView createProviderService(HttpServletRequest request, HttpServletResponse response,@ModelAttribute Service service) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		log.debug("aaaaaaaaaagetServiceName : " + service.getServiceName());
		log.debug("aaaaaaaaaagetServiceDesc : " + service.getServiceDesc());
		log.debug("aaaaaaaaaagetScope : " + service.getScope());
		for(String grant : service.getGrantTypes()){
			log.debug("aaaaaaaaaagetGrantType : " + grant);
		}
		log.debug("aaaaaaaaaagetRefreshTokenUseYn : " + service.getRefreshTokenUseYn());
		
		if(null == service.getRefreshTokenUseYn() || "".equals(service.getRefreshTokenUseYn())) service.setRefreshTokenUseYn(ConstantResource.USE_N);
		service.setUserId(10000);
		int providerId = providerService.createService(service);
		log.debug("provider ID : " + providerId);
		
		mav.addObject("type", "create");
		
		mav.setViewName("provider/createSuccessProvider");
		return mav;
	}
	
	@RequestMapping("getProvider")
	public ModelAndView getProviderService(HttpServletRequest request, HttpServletResponse response,Service service) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		log.debug("Controller : getService ");
		List<Service> scopes = providerService.getServiceScopeList(service);
		List<Service> grantTypes = providerService.getServiceGrantTypeList(service);
		service = providerService.getService(service);
		mav.addObject("service", service);
		mav.addObject("scopes", scopes);
		mav.addObject("grantTypes", grantTypes);
		return mav;
	}
	
	@RequestMapping("modifyProvider")
	public ModelAndView modifyProviderService(HttpServletRequest request, HttpServletResponse response,Service service) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		log.debug("Controller : modifyProviderService ");
		
		if(null == service.getRefreshTokenUseYn() || "".equals(service.getRefreshTokenUseYn())) service.setRefreshTokenUseYn(ConstantResource.USE_N);
		
		providerService.modifyService(service);
		
		mav.addObject("type", "modify");
		
		mav.setViewName("provider/createSuccessProvider");
		return mav;
	}
}
