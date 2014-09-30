package com.svenou.myapp.security.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.svenou.myapp.security.dao.iface.CsDao;
import com.svenou.myapp.security.service.iface.CsService;

public class CsServiceImpl implements CsService{
	@Autowired
	private CsDao csDao;
	
}
