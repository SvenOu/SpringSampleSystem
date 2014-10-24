package com.svenou.myapp.security.service;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.util.WebUtils;

import com.svenou.myapp.security.bean.CSUser;
import com.svenou.myapp.security.dao.iface.CsDao;
import com.svenou.myapp.security.service.iface.CsService;

public class CsServiceImpl implements CsService{
	@Autowired
	private CsDao csDao;

	@Override
	public CSUser getCurrentUserDetails(HttpServletRequest request) {
		SecurityContext securityContext = SecurityContextHolder.getContext();
	    Authentication authentication = securityContext.getAuthentication();
	    if (authentication != null) {
	        Object principal = authentication.getPrincipal();
	        UserDetails userDetails = (UserDetails) (principal instanceof UserDetails ? principal : null);
	        Locale languageCode =  (Locale) WebUtils.getSessionAttribute(request,SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
	        CSUser user =new CSUser(userDetails.getUsername(), userDetails.getPassword(), 
	        		userDetails.isEnabled(), userDetails.isAccountNonExpired(), 
	        		userDetails.isCredentialsNonExpired(), userDetails.isAccountNonLocked(),
	        		userDetails.getAuthorities());
	        user.setLanguageCode(languageCode.toString());
	        return user;
	    }
	    return null;
	}
	
}
