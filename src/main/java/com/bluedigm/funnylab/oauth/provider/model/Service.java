package com.bluedigm.funnylab.oauth.provider.model;

import com.bluedigm.funnylab.oauth.common.model.AbstractObject;

public class Service extends AbstractObject implements Cloneable{

	private int userId;
	private int serviceId;
	private String serviceName;
	private String serviceDesc;
	private String scope;
	private String[] grantTypes;
	private String grantType;
	private String refreshTokenUseYn;
	

	/**
	 * clone
	 */
	public Object clone() throws CloneNotSupportedException{
		Service provider = (Service)super.clone();
		
		return provider;
	}
	
	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String[] getGrantTypes() {
		return grantTypes;
	}
	public void setGrantTypes(String[] grantTypes) {
		this.grantTypes = grantTypes;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceDesc() {
		return serviceDesc;
	}
	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}
	
	public String getRefreshTokenUseYn() {
		return refreshTokenUseYn;
	}
	public void setRefreshTokenUseYn(String refreshTokenUseYn) {
		this.refreshTokenUseYn = refreshTokenUseYn;
	}
	
}
