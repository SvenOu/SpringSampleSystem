package com.svenou.myapp.security.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.svenou.myapp.commom.bean.CommonResponse;
import com.svenou.myapp.main.service.iface.ContactService;
import com.svenou.myapp.security.bean.CSUser;
import com.svenou.myapp.security.service.iface.CsService;

@Controller
@RequestMapping(value = "security")
public class SecurityController {
	@Autowired
	private ContactService contactService;
	@Autowired
	private CsService csService;
	
	@RequestMapping(value = "getCurrentUserDetails")
	public  @ResponseBody CommonResponse getCurrentUserDetails(HttpServletRequest request){
		CSUser csUser = csService.getCurrentUserDetails(request);
		if(null != csUser)
			return CommonResponse.success(csUser);
		return CommonResponse.SIMPLE_FAILURE;
	}
}
