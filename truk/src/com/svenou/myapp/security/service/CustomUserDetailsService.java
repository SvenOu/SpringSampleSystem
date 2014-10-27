package com.svenou.myapp.security.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.svenou.myapp.security.dao.iface.CsDao;

public class CustomUserDetailsService implements UserDetailsService{


	@Autowired
	private CsDao csDao;

	@Override
	public UserDetails loadUserByUsername(String userId)
			throws UsernameNotFoundException {
		return this.findUserInfo(userId);
	}

	public User findUserInfo(String userId) {
		String password = csDao.findPasswordByUserId(userId);
		boolean enabled = csDao.findEnabledByUserId(userId)>0;;
		Collection<GrantedAuthority> authorities = csDao.findAuthoritiesCollectionByUserId(userId);
//		Md5PasswordEncoder m =new Md5PasswordEncoder();
//		System.out.println(m.encodePassword(password, userId));
		return new User(userId, password, enabled, true, true, true, authorities);
	}
	
}
