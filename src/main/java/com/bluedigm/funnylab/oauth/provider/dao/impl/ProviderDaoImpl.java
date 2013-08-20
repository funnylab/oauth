package com.bluedigm.funnylab.oauth.provider.dao.impl;

import org.springframework.stereotype.Repository;

import com.bluedigm.funnylab.oauth.common.dao.impl.GenericDaoImpl;
import com.bluedigm.funnylab.oauth.provider.dao.ProviderDao;
import com.bluedigm.funnylab.oauth.provider.model.Provider;
import com.bluedigm.funnylab.oauth.provider.model.ProviderList;
import com.bluedigm.funnylab.oauth.provider.service.ProviderService;

@Repository
public class ProviderDaoImpl extends GenericDaoImpl<Provider, Integer> implements ProviderDao{

	public ProviderList selectProviderList(ProviderList providerList){
		
		log.debug("Dao selectProviderList");
		
		return providerList;
	}
}
