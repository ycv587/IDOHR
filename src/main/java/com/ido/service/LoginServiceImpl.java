package com.ido.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ido.bean.Employee;
import com.ido.mapper.EmployeeMapper;

@Service
public class LoginServiceImpl implements LoginServiceI {

	// 注入Mapper
	@Autowired
	private EmployeeMapper employeeMapper;

	/** 用户登录 */
	@Override
	public Employee login(String username, String password) {
		return employeeMapper.empLogin(username, password);
	}

}
