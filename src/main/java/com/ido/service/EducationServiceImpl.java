package com.ido.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ido.bean.Education;
import com.ido.mapper.EducationMapper;

@Service
public class EducationServiceImpl implements EducationServiceI {

	@Autowired
	private EducationMapper educationMapper;

	/**
	 * 根据员工编号查询教育经历
	 */
	@Override
	public List<Education> findEdusByEmpno(String empno, String order, String orderName) {
		// 排序
		if (order != null && orderName != null)
			PageHelper.orderBy(orderName + " " + order);
		else
			PageHelper.orderBy("gyear" + " " + "desc"); // 默认按照结束日期降序排列
		return educationMapper.selectEdusByEmpno(empno);
	}

}
