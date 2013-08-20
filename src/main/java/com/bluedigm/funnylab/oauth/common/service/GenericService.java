package com.bluedigm.funnylab.oauth.common.service;

import java.io.Serializable;


/**
 * Generic Service that talks to GenericDao to CRUD POJOs.
 * <p>
 * Extend this interface if you want typesafe (no casting necessary) services
 * for your domain objects. The original code of this class comes from Appfuse
 * framework.
 * 
 * @param <T> a type variable
 * @param <PK> the primary key for that type
 * @author kkanzo(kkanzo@bluedigm.com)
 * @date 2013. 8. 13. 오후 7:53:55
 * @version $Id$
 */
public interface GenericService<T, PK extends Serializable> {
	/**
	 * 아이디에 의한 객체 조회<br/>
	 * 예외는 런타임예외를 기본으로 한다.
	 * 
	 * @param id 해당 객체를 조회하기 위한 주키(Primary Key)
	 * @return 해당 테이블에서 조회되는 객체(Value Object)
	 */
	T get(PK id);

	/**
	 * 아이디에 의해 해당 객체가 존재하는지 확인
	 * 
	 * @param id 해당 객체를 조회하기 위한 주키(Primary Key)
	 * @return 존재하면 true, 그렇지 않으면 false 반환
	 */
	boolean exists(PK id);

	/**
	 * 객체(Value Object)를 해당 Persistence 입력(insert)
	 * 
	 * @param object 데이터값 객체(Value Object), PK 값을 미리 가지고 있을 수도 있고 입력(insert)시 DB
	 *            테이블에서 생성될 수도 있음
	 * @return 테이블에 성공적으로 입력(insert) 후 해당 row의 주키(Primary Key)값을 반환
	 */
	int create(T object);

	/**
	 * DB 테이블에 객체(Value Object)로 해당 row 값을 수정
	 * 
	 * @param object 데이터값 객체(Value Object), 기존 row의 PK 값을 반드시 가지고 있어야 함
	 */
	void modify(T object);

	/**
	 * PK에 해당하는 테이블의 row를 삭제
	 * 
	 * @param id 삭제하고자하는 row의 PK 값
	 */
	void remove(PK id);
}
