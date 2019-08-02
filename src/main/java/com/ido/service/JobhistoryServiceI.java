package com.ido.service;

import java.util.List;

import com.ido.bean.Jobhistory;

public interface JobhistoryServiceI {

	/** 根据员工编号查询工作经历 */
	public List<Jobhistory> findJobhisByEmpno(String empno, String order, String orderName);
}
