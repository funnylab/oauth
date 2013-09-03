package com.bluedigm.funnylab.oauth.provider.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bluedigm.funnylab.oauth.common.dao.impl.GenericDaoImpl;
import com.bluedigm.funnylab.oauth.provider.dao.ProviderDao;
import com.bluedigm.funnylab.oauth.provider.model.Service;
import com.bluedigm.funnylab.oauth.provider.model.ServiceList;
import com.bluedigm.funnylab.oauth.provider.service.ProviderService;

@Repository
public class ProviderDaoImpl extends GenericDaoImpl<Service, Integer> implements ProviderDao{

	public List<Service> selectServiceList(ServiceList serviceList){
		
		log.debug("Dao selectProviderList");
		
		return selectList("com.bliedigm.funnylab.oauth.provider.selectServiceList", serviceList);
	}
	
	public int selectServiceTotalCnt(ServiceList serviceList){
		return (int)selectOne("com.bliedigm.funnylab.oauth.provider.selectServiceTotalCnt", serviceList);
	}
	
	public Service selectService(Service service){
		
		log.debug("Dao selectProvider");
		
		return (Service)selectOne("com.bliedigm.funnylab.oauth.provider.selectService", service);
	}

	public int insertService(Service service){
		return insert("com.bliedigm.funnylab.oauth.provider.insertService", service);
	}
	
	public int updateService(Service service){
		return update("com.bliedigm.funnylab.oauth.provider.updateService", service);
	}
	public List<Service> selectScopeList(Service service){
		return selectList("com.bliedigm.funnylab.oauth.provider.selectServiceScopeist", service);
	}
	
	public int insertScope(Service service){
		return insert("com.bliedigm.funnylab.oauth.provider.insertScope", service);
	}
	
	public int deleteScope(Service service){
		return delete("com.bliedigm.funnylab.oauth.provider.deleteScope", service);
	}
	
	public List<Service> selectGrantTypeList(Service service){
		return selectList("com.bliedigm.funnylab.oauth.provider.selectServiceGrantTypeist", service);
	}
	
	public int insertGrantType(Service service){
		return insert("com.bliedigm.funnylab.oauth.provider.insertGrantType", service);
	}
	
	public int deleteGrantType(Service service){
		return delete("com.bliedigm.funnylab.oauth.provider.deleteGrantType", service);
	}
}
