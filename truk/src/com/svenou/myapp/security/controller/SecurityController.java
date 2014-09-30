package com.svenou.myapp.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.svenou.myapp.main.service.iface.ContactService;

@Controller
@RequestMapping(value = "/main")
public class SecurityController {
	@Autowired
	private ContactService contactService;
	
}
