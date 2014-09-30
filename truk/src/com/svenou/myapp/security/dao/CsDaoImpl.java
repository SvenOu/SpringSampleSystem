package com.svenou.myapp.security.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import com.svenou.myapp.security.dao.iface.CsDao;

public class CsDaoImpl extends NamedParameterJdbcDaoSupport implements CsDao{

	public static final String FIND_PASSWORD_BYUSRID = "SELECT password FROM users WHERE username=?";

	public String findPasswordByUserId(String userId) {
		return this.getJdbcTemplate().queryForObject(FIND_PASSWORD_BYUSRID,
				String.class, userId);
	}

	public static final String FIND_AUTHORITIES_BYUSRID = "SELECT user_roles.role FROM  user_roles INNER JOIN  users ON user_roles.username =users.username WHERE users.username=?";

	public List<String> findAuthoritiesByUserId(String userId) {
		return this.getJdbcTemplate().queryForList(FIND_AUTHORITIES_BYUSRID,
				String.class, userId);
	}

	public static final String FIND_ENABLED_BYUSRID = "SELECT enabled FROM users WHERE username=?";

	public int findEnabledByUserId(String userId) {
		return this.getJdbcTemplate().queryForObject(FIND_ENABLED_BYUSRID,
				Integer.class, userId);
	}
}
