package com.ido.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ido.bean.Jobhistory;
import com.ido.mapper.JobhistoryMapper;

@Service
public class JobhistoryServiceImpl implements JobhistoryServiceI {

	@Autowired
	private JobhistoryMapper jobhistoryMapper;

	/**
	 * 根据员工编号查询员工工作经历信息
	 */
	@Override
	public List<Jobhistory> findJobhisByEmpno(String empno, String order, String orderName) {
		// 排序
		if (order != null && orderName != null)
			PageHelper.orderBy(orderName + " " + order);
		else
			PageHelper.orderBy("hquit" + " " + "desc"); // 默认按照离职日期降序排列
		return jobhistoryMapper.selectJobhisByEmpno(empno);
	}

}
