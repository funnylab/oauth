package com.bluedigm.funnylab.oauth.common.dao.impl;

import java.io.Serializable;
import java.util.List;


import com.bluedigm.funnylab.oauth.common.dao.GenericDao;
import com.bluedigm.funnylab.oauth.common.model.AbstractObject;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * The Class GenericDaoImpl.
 *
 * @param <T> the generic type
 * @param <PK> the generic type
 * @author Han-jong Kim, Bluedigm
 * @date 2013. 8. 13. 오후 7:53:55
 * @version 1.0
 */
public class GenericDaoImpl<T,PK extends Serializable> extends SqlSessionDaoSupport implements GenericDao<T, PK> {
	/**
	 * 모든 상속 클래스를 위한 로그
	 */
	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	/* (non-Javadoc)
	 * @seecom.bluedigm.funnylab.oauth.common.dao.GenericDao#selectOne(java.lang.String, java.io.Serializable)
	 */
	public Object selectOne(String statement, Object keys) {
		
		return getSqlSession().selectOne(statement, keys);
	}

	
	public List<T> selectList(String statement) {
		
		return getSqlSession().selectList(statement);
	}	

	/* (non-Javadoc)
	 * @seecom.bluedigm.funnylab.oauth.common.dao.GenericDao#selectList(java.lang.String, java.io.Serializable)
	 */
	public List<T> selectList(String statement, Object keys) {
		
		return getSqlSession().selectList(statement, keys);
	}
	
	/* (non-Javadoc)
	 * @seecom.bluedigm.funnylab.oauth.common.dao.GenericDao#exists(java.lang.String, java.io.Serializable)
	 */
	public boolean exists(String statement, PK id) {
		
		Integer count = (Integer)getSqlSession().selectOne(statement, id);
		
		return count > 0;
	}

	/* (non-Javadoc)
	 * @seecom.bluedigm.funnylab.oauth.common.dao.GenericDao#insert(java.lang.String, java.lang.Object)
	 */
	public int insert(String statement, T object) {
		
		if(object instanceof AbstractObject){
			((AbstractObject)object).setCreateSqlId(statement);
			((AbstractObject)object).setModifySqlId(statement);
		}else{
		}
		return getSqlSession().insert(statement, object);
	}

	/* (non-Javadoc)
	 * @seecom.bluedigm.funnylab.oauth.common.dao.GenericDao#update(java.lang.String, java.lang.Object)
	 */
	public int update(String statement, T object) {
		
		if(object instanceof AbstractObject){
			((AbstractObject)object).setModifySqlId(statement);
		}else{
		}
		return getSqlSession().update(statement, object);
	}

	/* (non-Javadoc)
	 * @seecom.bluedigm.funnylab.oauth.common.dao.GenericDao#delete(java.lang.String, java.io.Serializable)
	 */
	public int delete(String statement, PK id) {
		
		return getSqlSession().delete(statement, id);
	}


	/* (non-Javadoc)
	 * @seecom.bluedigm.funnylab.oauth.common.dao.GenericDao#delete(java.lang.String, java.lang.Object)
	 */
	@Override
	public int delete(String statement, T object) {
		
		return getSqlSession().delete(statement, object);
	}
	

	
	
}
