package com.bluedigm.funnylab.oauth.provider.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bluedigm.funnylab.oauth.provider.dao.ProviderDao;
import com.bluedigm.funnylab.oauth.provider.model.ProviderList;
import com.bluedigm.funnylab.oauth.provider.service.ProviderService;


@Service
public class ProviderServiceImpl implements ProviderService{

	/**
	 * 모든 상속 클래스를 위한 로그
	 */
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private ProviderDao providerDao;
	
	public ProviderList getProviderList(ProviderList providerList){
		
		log.debug("Service getProviderList");
		providerDao.selectProviderList(providerList);
		
		return providerList; 
	}
}
