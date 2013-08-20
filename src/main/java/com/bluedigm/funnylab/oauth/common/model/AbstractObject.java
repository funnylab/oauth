/*
 * Copyright (c) 2011 SK planet.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of SK planet.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with SK planet.
 */
package com.bluedigm.funnylab.oauth.common.model;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnore;


/**
 * Open Platform의 모든 도메인 객체가 상속 받아야 할 기본 클래스. <br/>
 * 
 * @author Giljae Joo(giljae@gmail.com)
 * @date 2012. 1. 13. 오후 7:37:02
 * @version $Id$
 */

@XmlTransient
@JsonAutoDetect
public abstract class AbstractObject {

	@XmlTransient
	@JsonIgnore
	private String createID;
	@XmlTransient
	@JsonIgnore
	private String createSqlID;
	@XmlTransient
	@JsonIgnore
	private Timestamp createDateTime;
	@XmlTransient
	@JsonIgnore
	private String modifyID;
	@XmlTransient
	@JsonIgnore
	private String modifySqlID;
	@XmlTransient
	@JsonIgnore
	private Timestamp modifyDateTime;
	
	/**
	 * @return the createID
	 */
	public String getCreateID() {
		return createID;
	}

	/**
	 * @param createID the createID to set
	 */
	public void setCreateID(String createID) {
		this.createID = createID;
	}

	/**
	 * @return the createSqlID
	 */
	public String getCreateSqlID() {
		return createSqlID;
	}

	/**
	 * @param createSqlID the createSqlID to set
	 */
	public void setCreateSqlID(String createSqlID) {
		this.createSqlID = createSqlID;
	}

	/**
	 * @return the createDateTime
	 */
	public Timestamp getCreateDateTime() {
		return createDateTime;
	}

	/**
	 * @param createDateTime the createDateTime to set
	 */
	public void setCreateDateTime(Timestamp createDateTime) {
		this.createDateTime = createDateTime;
	}

	/**
	 * @return the modifyID
	 */
	public String getModifyID() {
		return modifyID;
	}

	/**
	 * @param modifyID the modifyID to set
	 */
	public void setModifyID(String modifyID) {
		this.modifyID = modifyID;
	}

	/**
	 * @return the modifySqlID
	 */
	public String getModifySqlID() {
		return modifySqlID;
	}

	/**
	 * @param modifySqlID the modifySqlID to set
	 */
	public void setModifySqlID(String modifySqlID) {
		this.modifySqlID = modifySqlID;
	}

	/**
	 * @return the modifyDateTime
	 */
	public Timestamp getModifyDateTime() {
		return modifyDateTime;
	}

	/**
	 * @param modifyDateTime the modifyDateTime to set
	 */
	public void setModifyDateTime(Timestamp modifyDateTime) {
		this.modifyDateTime = modifyDateTime;
	}

	/**
	 * 해당 객체의 toString 오버라이드.
	 * 
	 * @return 객체의 각 프로퍼티와 해당 값을 text로 제공
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	/**
	 * 해당 객체의 equals 오버라이드.
	 * 
	 * @param obj 비교 대상 객체
	 * @return 비교 대상 객체와 각 프로퍼티값이 동일한 경우 <code>true</code>반환
	 */
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	/**
	 * 해당 객체의 hashCode 오버라이드.
	 * 
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}
