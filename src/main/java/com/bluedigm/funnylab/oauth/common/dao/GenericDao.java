package com.bluedigm.funnylab.oauth.common.dao;

import java.io.Serializable;
import java.util.List;


/**
 * Generic DAO (Data Access Object) with common methods to CRUD POJOs.
 * <p>
 * Extend this interface if you want typesafe (no casting necessary) DAO's for
 * your domain objects.
 * 
 * @param <T> a type variable
 * @param <PK> the primary key for that type
 * @author kkanzo(kkanzo@bluedigm.com)
 * @date 2013. 8. 13. 오후 7:53:55
 * @version $Id$
 */
public interface GenericDao<T, PK extends Serializable> {
	/**
	 * 주키(Primary Key)에 의한 객체 조회<br/>
	 * DB 테이블 조회시 발생하는 예외는 런타임예외를 기본으로 한다.
	 * 
	 * @param statement SQL Map XML 파일에 정의된 select 구문 ID
	 * @param keys 해당 객체를 조회하기 위한 Primary Key또는 Parameter Map
	 * @return 해당 테이블에서 조회되는 객체(Value Object)
	 */
	Object selectOne(String statement, Object keys);

	/**
	 * 주키(Primary Key)에 의한 객체 조회<br/>
	 * DB 테이블 조회시 발생하는 예외는 런타임예외를 기본으로 한다.
	 * 
	 * @param statement SQL Map XML 파일에 정의된 select 구문 ID
	 * @param keys 해당 객체를 조회하기 위한 Primary Key또는 Parameter Map
	 * @return 해당 테이블에서 조회되는 객체(Value Object)
	 */

	List<T> selectList(String statement, Object keys);

	List<T> selectList(String statement);

	/**
	 * 주키(Primary Key)에 의해 해당 객체(데이터)가 테이블에 레코드로 존재하는지 확인.
	 * 
	 * @param statement SQL Map XML 파일에 정의된 select 구문 ID
	 * @param id 해당 객체를 조회하기 위한 주키(Primary Key)
	 * @return 존재하면 true, 그렇지 않으면 false 반환
	 */
	boolean exists(String statement, PK primaryKey);

	/**
	 * 객체(Value Object)를 해당 DB 테이블에 입력(insert).
	 * 
	 * @param statement SQL Map XML 파일에 정의된 insert 구문 ID
	 * @param object 데이터값 객체(Value Object), PK 값을 미리 가지고 있을 수도 있고 입력(insert)시 DB
	 *            테이블에서 생성될 수도 있음
	 * @return 테이블에 성공적으로 입력(insert) 후 입력된 row 개수를 반환
	 */
	int insert(String statement, T object);

	/**
	 * DB 테이블에 객체(Value Object)로 해당 row 값을 수정.
	 * 
	 * @param statement SQL Map XML 파일에 정의된 update 구문 ID
	 * @param object 데이터값 객체(Value Object), 기존 row의 PK 값을 반드시 가지고 있어야 함
	 */
	int update(String statement, T object);

	/**
	 * PK에 해당하는 테이블의 row를 삭제.
	 * 
	 * @param statement SQL Map XML 파일에 정의된 delete 구문 ID
	 * @param id 삭제하고자하는 row의 PK 값
	 */
	int delete(String statement, PK primaryKey);
	
	
	/** DB 테이블에 객체(Value Object)로 해당 row 값을 삭제.
	 *  복합 PK 구성테이블 삭제시 필요하여 추가함
	 * 
	 * @param statement SQL Map XML 파일에 정의된 delete 구문 ID
	 * @param object 데이터값 객체(Value Object), 기존 row의 PK 값을 반드시 가지고 있어야 함
	 */
	int delete(String statement, T object);

}
