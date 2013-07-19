package com.bluedigm.funnylab.oauth.common.security.account;

import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

public class CustomJdbcDaoImpl extends JdbcDaoImpl implements IChangePassword{

	public void changePassword(String username, String password){
		getJdbcTemplate().update("UPDATE USERS SET PASSWORD = ? WHERE USERNAME = ?",password,username);
	}
}
