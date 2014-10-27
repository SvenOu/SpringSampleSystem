package com.svenou.myapp.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class CustomSimpleUrlAuthenticationFailureHandler extends
		SimpleUrlAuthenticationFailureHandler {

	private String changePasswordUrl;
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler#onAuthenticationFailure(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.AuthenticationException)
	 */
	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		if("User credentials have expired".equals(exception.getMessage())){
			logger.debug("Redirecting to " + changePasswordUrl);
			request.getSession().setAttribute("credentialsNonExpired", false);
			redirectStrategy.sendRedirect(request, response, changePasswordUrl);
		}else{
			super.onAuthenticationFailure(request, response, exception);
		}
	}

	/**
	 * @param changePasswordUrl the changePasswordUrl to set
	 */
	public void setChangePasswordUrl(String changePasswordUrl) {
		this.changePasswordUrl = changePasswordUrl;
	}

}
