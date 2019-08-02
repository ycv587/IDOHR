package com.ido.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.ido.bean.Employee;
import com.ido.bean.Merit;
import com.ido.bean.Result;
import com.ido.mapper.EmployeeMapper;
import com.ido.mapper.MeritMapper;
import com.ido.mapper.ResultMapper;

@Service
public class MeritServiceImpl implements MeritServiceI {

	// mapper注入
	@Autowired
	private MeritMapper meritMapper;
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private ResultMapper resultMapper;

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean addMerit(Merit merit) {
		meritMapper.insertSelective(merit);
		for (Employee employee : employeeMapper.selectAll()) {
			Result result = new Result();
			result.setEmployee(employee);
			result.setMerit(merit);
			resultMapper.insertSelective(result);
		}
		return true;
	}

	@Override
	public boolean modifyMerit(Merit merit) {
		meritMapper.updateByPrimaryKeySelective(merit);
		return true;
	}

	@Override
	public List<Merit> findAll(Integer pageIndex, Integer pageSize, String search, String order, String orderName) {
		// 分页
		PageHelper.startPage(pageIndex == null ? 1 : pageIndex, pageSize == null ? 10 : pageSize);
		// 排序
		if (order != null && orderName != null)
			PageHelper.orderBy(orderName + " " + order);
		return meritMapper.selectAll();
	}

	@Override
	public List<Merit> findOn(Integer pageIndex, Integer pageSize, String search, String order, String orderName) {
		// 分页
		PageHelper.startPage(pageIndex == null ? 1 : pageIndex, pageSize == null ? 10 : pageSize);
		// 排序
		if (order != null && orderName != null)
			PageHelper.orderBy(orderName + " " + order);
		return meritMapper.selectOn();
	}

	@Override
	public List<Merit> findOff(Integer pageIndex, Integer pageSize, String search, String order, String orderName) {
		// 分页
		PageHelper.startPage(pageIndex == null ? 1 : pageIndex, pageSize == null ? 10 : pageSize);
		// 排序
		if (order != null && orderName != null)
			PageHelper.orderBy(orderName + " " + order);
		return meritMapper.selectOff();
	}

	@Override
	public List<Merit> findStart(Integer pageIndex, Integer pageSize, String search, String order, String orderName) {
		// 分页
		PageHelper.startPage(pageIndex == null ? 1 : pageIndex, pageSize == null ? 10 : pageSize);
		// 排序
		if (order != null && orderName != null)
			PageHelper.orderBy(orderName + " " + order);
		return meritMapper.selectSatrt();
	}

	@Override
	public List<Merit> findByTime(Integer pageIndex, Integer pageSize, String search, String order, String orderName,
			Date time) {
		// 分页
		PageHelper.startPage(pageIndex == null ? 1 : pageIndex, pageSize == null ? 10 : pageSize);
		// 排序
		if (order != null && orderName != null)
			PageHelper.orderBy(orderName + " " + order);
		return meritMapper.selectTime(time);
	}

	@Override
	public List<Merit> findOffWithoutPage() {
		return meritMapper.selectOff();
	}

}