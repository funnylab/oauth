package com.bluedigm.funnylab.oauth.provider.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bluedigm.funnylab.oauth.provider.dao.ProviderDao;
import com.bluedigm.funnylab.oauth.provider.model.Service;
import com.bluedigm.funnylab.oauth.provider.model.ServiceList;
import com.bluedigm.funnylab.oauth.provider.service.ProviderService;


@org.springframework.stereotype.Service
public class ProviderServiceImpl implements ProviderService{

	/**
	 * 모든 상속 클래스를 위한 로그
	 */
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private ProviderDao providerDao;
	
	
	public List<Service> getServiceList(ServiceList serviceList){
		
		log.debug("Service getProviderList");
		
		return providerDao.selectServiceList(serviceList);
	}
	
	public int getServiceTotalCnt(ServiceList serviceList){
		return providerDao.selectServiceTotalCnt(serviceList);
	}
	
	public Service  getService(Service service){
			
			log.debug("Service getService");
			
			return providerDao.selectService(service);
	}

	public List<Service> getServiceScopeList(Service service){
		return providerDao.selectScopeList(service);
	}
	
	public List<Service> getServiceGrantTypeList(Service service){
		return providerDao.selectGrantTypeList(service);
	}

	public int createService(Service service){
		// 프로바이더 서비스 등록
		providerDao.insertService(service);
		int serviceId = service.getServiceId();
		log.debug("getServiceId : " + service.getServiceId());
		// 프로바이더 서비스 스코프 등록
		String[] scopes= service.getScope().replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t", "").replaceAll("\b", "").split(",");
		
		Service sc;
		for(String scope : scopes){
			log.debug("scopes : " + scope.trim());
			if(scope !=null && !scope.equals("") && scope.length() > 0){
				
				sc = new Service();
			
				sc.setServiceId(serviceId);
				sc.setScope(scope);
			
			providerDao.insertScope(sc);
			}
		}
		
		// 프로바이더 서비스 Grant Type 등록
		for(String grantType : service.getGrantTypes()){
			log.debug("scopes : " + grantType.trim());
			if(!grantType.equals("")){
				
				sc = new Service();
			
				sc.setServiceId(serviceId);
				sc.setGrantType(grantType);
			
			providerDao.insertGrantType(sc);
			}
		}
		
		return serviceId;
	}
	
	public int modifyService(Service service){
		// 프로바이더 서비스 등록
		providerDao.updateService(service);
		int serviceId = service.getServiceId();
		log.debug("getServiceId : " + service.getServiceId());
		
		// 프로바이더 서비스 스코프 삭제 후 등록
		providerDao.deleteScope(service);
		String[] scopes= service.getScope().replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t", "").replaceAll("\b", "").split(",");
		
		Service sc;
		for(String scope : scopes){
			log.debug("scopes : " + scope.trim());
			if(scope !=null && !scope.equals("") && scope.length() > 0){
				
				sc = new Service();
			
				sc.setServiceId(serviceId);
				sc.setScope(scope);
			
			providerDao.insertScope(sc);
			}
		}
		
		// 프로바이더 서비스 Grant Type 삭제 후 등록
		providerDao.deleteGrantType(service);
		for(String grantType : service.getGrantTypes()){
			log.debug("scopes : " + grantType.trim());
			if(!grantType.equals("")){
				
				sc = new Service();
			
				sc.setServiceId(serviceId);
				sc.setGrantType(grantType);
			
			providerDao.insertGrantType(sc);
			}
		}
		
		return serviceId;
	}
}
