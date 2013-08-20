package com.bluedigm.funnylab.oauth.common.service.impl;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.bluedigm.funnylab.oauth.common.dao.GenericDao;
import com.bluedigm.funnylab.oauth.common.service.GenericService;


/**
 * This class serves as the Generic class for all other Services - namely to
 * hold common CRUD methods that they might all use. You should only need to
 * extend this class when your require custom CRUD logic. The original code of
 * this class comes from Appfuse framework.
 * <p>
 * 
 * @param <T> a type variable
 * @param <PK> the primary key for that type
 * @author kkanzo(kkanzo@bluedigm.com)
 * @date 2013. 8. 13. 오후 7:53:55
 * @version $Id$
 */
@Transactional
public class GenericServiceImpl<T, PK extends Serializable> implements GenericService<T, PK> {
	/**
	 * 모든 상속 클래스를 위한 로그
	 */
	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * GenericDao instance, set by constructor of child classes
	 */
	protected GenericDao<T, PK> dao;

	public GenericServiceImpl() {}

	public GenericServiceImpl(GenericDao<T, PK> genericDao) {
		this.dao = genericDao;
	}

	/* (non-Javadoc)
	 * @see com.skp.openplatform.core.framework.service.GenericService#get(java.io.Serializable)
	 */
	public T get(PK id) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.skp.openplatform.core.framework.service.GenericService#exists(java.io.Serializable)
	 */
	public boolean exists(PK id) {
		return false;
	}

	/* (non-Javadoc)
	 * @see com.skp.openplatform.core.framework.service.GenericService#create(java.lang.Object)
	 */
	public int create(T object) {
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.skp.openplatform.core.framework.service.GenericService#modify(java.lang.Object)
	 */
	public void modify(T object) {

		
	}

	/* (non-Javadoc)
	 * @see com.skp.openplatform.core.framework.service.GenericService#remove(java.io.Serializable)
	 */
	public void remove(PK id) {

		
	}
}
