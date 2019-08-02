package com.ido.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ido.bean.Jobover;
import com.ido.mapper.EmployeeMapper;
import com.ido.mapper.JoboverMapper;

@Service
public class JoboverServiceImpl implements JoboverServiceI {

	@Autowired
	private JoboverMapper joboverMapper;
	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public boolean addJobover(Jobover jobover) {
		return joboverMapper.insertSelective(jobover) == 1;
	}

	@Override
	public List<Jobover> findAllJobover(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName) {
		// 分页
		PageHelper.startPage(pageIndex == null ? 1 : pageIndex, pageSize == null ? 10 : pageSize);
		// 排序
		if (order != null && orderName != null)
			PageHelper.orderBy(orderName + " " + order);
		List<Jobover> jobovers = joboverMapper.selectAll();
		for (Jobover jobover : jobovers) {
			jobover.setEmployee(employeeMapper.selectByPrimaryKey(jobover.getEmployee().getEmpno()));
		}
		return jobovers;
	}

	@Override
	public List<Jobover> findByEmpno(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName) {
		// 分页
		PageHelper.startPage(pageIndex == null ? 1 : pageIndex, pageSize == null ? 10 : pageSize);
		// 排序
		if (order != null && orderName != null)
			PageHelper.orderBy(orderName + " " + order);
		List<Jobover> jobovers = joboverMapper.selectByEmpno(search);
		for (Jobover jobover : jobovers) {
			jobover.setEmployee(employeeMapper.selectByPrimaryKey(jobover.getEmployee().getEmpno()));
		}
		return jobovers;
	}

}
