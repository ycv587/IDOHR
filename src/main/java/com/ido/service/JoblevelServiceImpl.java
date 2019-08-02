package com.ido.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ido.bean.Joblevel;
import com.ido.mapper.EmployeeMapper;
import com.ido.mapper.JoblevelMapper;

@Service
public class JoblevelServiceImpl implements JoblevelServiceI {

	@Autowired
	private JoblevelMapper joblevelMapper;
	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public boolean addJoblevel(Joblevel joblevel) {
		return joblevelMapper.insertSelective(joblevel) == 1;
	}

	@Override
	public List<Joblevel> findAllJoblevel(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName) {
		// 分页
		PageHelper.startPage(pageIndex == null ? 1 : pageIndex, pageSize == null ? 10 : pageSize);
		// 排序
		if (order != null && orderName != null)
			PageHelper.orderBy(orderName + " " + order);
		List<Joblevel> joblevels = joblevelMapper.selectAll();
		for (Joblevel joblevel : joblevels) {
			joblevel.setEmployee(employeeMapper.selectByPrimaryKey(joblevel.getEmployee().getEmpno()));
		}
		return joblevels;
	}

	@Override
	public List<Joblevel> findByEmpno(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName) {
		// 分页
		PageHelper.startPage(pageIndex == null ? 1 : pageIndex, pageSize == null ? 10 : pageSize);
		// 排序
		if (order != null && orderName != null)
			PageHelper.orderBy(orderName + " " + order);
		List<Joblevel> joblevels = joblevelMapper.selectByEmpno(search);
		for (Joblevel joblevel : joblevels) {
			joblevel.setEmployee(employeeMapper.selectByPrimaryKey(joblevel.getEmployee().getEmpno()));
		}
		return joblevels;
	}

}
