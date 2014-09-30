package com.svenou.myapp.security.dao.iface;

import java.util.List;

public interface CsDao {
	public String findPasswordByUserId(String userId);
	public List<String> findAuthoritiesByUserId(String userId);
	public int findEnabledByUserId(String userId);
}
