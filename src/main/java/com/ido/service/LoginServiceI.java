package com.ido.service;

import com.ido.bean.Employee;

public interface LoginServiceI {

	/** 用户登录 */
	Employee login(String username, String password);
}
