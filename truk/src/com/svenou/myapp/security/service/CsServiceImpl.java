package com.svenou.myapp.security.service;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.util.WebUtils;

import com.svenou.myapp.security.bean.CSUser;
import com.svenou.myapp.security.dao.iface.CsDao;
import com.svenou.myapp.security.service.iface.CsService;

public class CsServiceImpl implements CsService{
	private Log log = LogFactory.getLog(CsServiceImpl.class);
	
	private Map<String, String> loginSuccessUrlMap;
	public void setLoginSuccessUrlMap(Map<String, String> loginSuccessUrlMap) {
		this.loginSuccessUrlMap = loginSuccessUrlMap;
	}

	@Autowired
	private CsDao csDao;

	@Override
	public CSUser getCurrentUserDetails(HttpServletRequest request) {
		UserDetails userDetails = this.getUserDeatils();
        Locale languageCode =  (Locale) WebUtils.getSessionAttribute(request,SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        CSUser user =new CSUser(userDetails.getUsername(), userDetails.getPassword(), 
        		userDetails.isEnabled(), userDetails.isAccountNonExpired(), 
        		userDetails.isCredentialsNonExpired(), userDetails.isAccountNonLocked(),
        		userDetails.getAuthorities());
        user.setLanguageCode(languageCode.toString());
	    return user;
	}

	@Override
	public String getLoginSuccessUrl() {
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities();
		if (authorities == null) {
			return "/login.html";
		}
		log.info("User " + getUserDeatils().getUsername()
				+ " has authorities:" + authorities.toString());
		if (authorities.size() > 0) {
			GrantedAuthority authority = authorities.get(0);
			String userRole = authority.getAuthority();
			return loginSuccessUrlMap.get(userRole);
		}
		return "/login.html";
	}
	
	private UserDetails getUserDeatils(){
		SecurityContext securityContext = SecurityContextHolder.getContext();
	    Authentication authentication = securityContext.getAuthentication();
	    if (authentication != null) {
	        Object principal = authentication.getPrincipal();
	        UserDetails userDetails = (UserDetails) (principal instanceof UserDetails ? principal : null);
	        return userDetails;
	    }
		return null;
	}
	
}
