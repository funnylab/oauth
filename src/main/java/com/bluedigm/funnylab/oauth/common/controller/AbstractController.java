package com.bluedigm.funnylab.oauth.common.controller;

import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;


/**
 * Web Controller의 부모 클래스 <br/>
 * 모든 Web Controller는 본 클래스를 상속 받는다.
 * 
 * @author kkanzo(kkanzo@bluedigm.com)
 * @date 2018. 8. 13. 오후 7:14:05
 * @version $Id$
 */
public class AbstractController {
	/**
	 * 모든 상속 클래스를 위한 로그
	 */
	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected MessageSource messageSource = null;

	/** The Message accessor. */
	@Resource
	private MessageSourceAccessor accessor;
	
	/**
	 * 리소스 번들에서 메시지 값 조회
	 * 
	 * @param messageCode 리소스 번들의 코드값
	 * @param messageParameters array of arguments that will be filled in for
	 *            params within the message (params look like "{0}", "{1,date}",
	 *            "{2,time}" within a message)
	 * @param defaultMessage 리소스 번들 조회 실패시 기본 제공 메시지
	 * @return 코드값에 해당하는 리소스 값
	 */
	public String getMessage(String messageCode, Object[] messageParameters, String defaultMessage) {
		Locale locale = Locale.getDefault();
		return getMessage(messageCode, messageParameters, defaultMessage, locale);
	}

	/**
	 * 리소스 번들에서 메시지 값 조회
	 * 
	 * @param messageCode 리소스 번들의 코드값
	 * @param messageParameters array of arguments that will be filled in for
	 *            params within the message (params look like "{0}", "{1,date}",
	 *            "{2,time}" within a message)
	 * @param defaultMessage 리소스 번들 조회 실패시 기본 제공 메시지
	 * @param locale 로케일
	 * @return 코드값에 해당하는 리소스 값
	 */
	public String getMessage(String messageCode, Object[] messageParameters, String defaultMessage, Locale locale) {
		return this.messageSource.getMessage(messageCode, messageParameters, defaultMessage, locale);
	}

	/**
	 * 세션에 저장된 Attribute를 반환<br/>
	 * Attribute를 가져오는 예시<br/>
	 * 
	 * <pre>
	 * <code>
	 * // Session에 저장된 Object를 가져오기. 만일 HttpSession에 User객체를 'skpop.user' 라는 name으로 넣었을 경우
	 * User user = (User)getRequestAttribute("skpop.user");
	 * </code>
	 * </pre>
	 * 
	 * @param name - attribute name
	 * @return Session에 저장된 Object
	 */
	public Object getRequestAttribute(String name) {
		return RequestContextHolder.currentRequestAttributes().getAttribute(name, RequestAttributes.SCOPE_SESSION);
	}

	/**
	 * 세션에 Attribute를 저장</br> Attribute를 저장하는 예시<br/>
	 * 
	 * <pre>
	 * <code>
	 * // Session에 User Object를 'skpop.user'라는 name으로 저장할 경우
	 * setRequestAttribute("skpop.user",user);
	 * </code>
	 * </pre>
	 * 
	 * @param name - attribute name
	 * @param value - attribute value
	 */
	public void setRequestAttribute(String name, Object value) {
		RequestContextHolder.currentRequestAttributes().setAttribute(name, value, RequestAttributes.SCOPE_SESSION);
	}

	/**
	 * WebApplicationContext를 반환<br/>
	 * 
	 * @return WebApplicationContext
	 */
	public WebApplicationContext getWebApplicationContext() {
		return ContextLoader.getCurrentWebApplicationContext();
	}
}
