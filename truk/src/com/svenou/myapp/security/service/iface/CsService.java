package com.svenou.myapp.security.service.iface;

import javax.servlet.http.HttpServletRequest;

import com.svenou.myapp.security.bean.CSUser;

public interface CsService {

	public CSUser getCurrentUserDetails(HttpServletRequest request);
}
