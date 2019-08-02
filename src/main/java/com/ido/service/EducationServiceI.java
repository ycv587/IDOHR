package com.ido.service;

import java.util.List;

import com.ido.bean.Education;

public interface EducationServiceI {

	/** 根据员工编号查询教育经历 */
	public List<Education> findEdusByEmpno(String empno, String order, String orderName);
}
