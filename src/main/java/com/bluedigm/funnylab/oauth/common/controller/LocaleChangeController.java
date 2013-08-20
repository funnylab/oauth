package com.bluedigm.funnylab.oauth.common.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


/**
 * The Class BaseController.
 *
 * @author kkanzo(kkanzo@bluedigm.com)
 * @date 2018. 8. 13. 오후 7:14:05
 * @version 1.0
 */
public class LocaleChangeController extends AbstractController {
	
	/** The locale resolver. */
	private LocaleResolver localeResolver;

	/**
	 * Sets the locale resolver.
	 *
	 * @param localeResovler the new locale resolver
	 */
	public void setLocaleResolver(LocaleResolver localeResolver) {
		this.localeResolver = localeResolver;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String language = request.getParameter("locale");

		if (language != null) {
			Locale locale = new Locale(language);
			//LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
			localeResolver.setLocale(request, response, locale);
		}
		return new ModelAndView("redirect:/index.jsp");
	}
}
