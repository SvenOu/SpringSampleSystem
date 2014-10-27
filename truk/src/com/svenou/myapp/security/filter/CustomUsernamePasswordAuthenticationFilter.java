package com.svenou.myapp.security.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class CustomUsernamePasswordAuthenticationFilter extends
		UsernamePasswordAuthenticationFilter {
	private Log log = LogFactory.getLog(CustomUsernamePasswordAuthenticationFilter.class);
	private String languageCodeParameter = "languageCode";
	private String userIdParameter = "j_username";
	private String passwordParameter = "j_password";
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
/*//		String languageCode = obtainLanguageCode(request);
		String userId = obtainUserId(request);
		String password = obtainPassword(request);
		HttpSession session = request.getSession();
//		session.setAttribute("languageCode", languageCode);
		session.setAttribute("userId", userId);
		session.setAttribute("password", password);
//		log.info("Saved languageCode "+languageCode+" and userId " +userId+ " to session.");
		log.info("Saved userId " +userId+ " to session.");*/
		return super.attemptAuthentication(request, response);
	}

	protected String obtainLanguageCode(HttpServletRequest request) {
        return request.getParameter(languageCodeParameter);
	}
	
	protected String obtainUserId(HttpServletRequest request) {
		return request.getParameter(userIdParameter);
	}
	
	protected String obtainPassword(HttpServletRequest request) {
		return request.getParameter(passwordParameter);
	}
}
