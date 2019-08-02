package com.ido.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ido.bean.Result;
import com.ido.mapper.EmployeeMapper;
import com.ido.mapper.MeritMapper;
import com.ido.mapper.ResultMapper;

@Service
public class ResultServiceImpl implements ResultServiceI {

	@Autowired
	private ResultMapper resultMapper;
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private MeritMapper meritMapper;

	@Override
	public boolean addResult(Result result) {
		return resultMapper.insertSelective(result) == 1 ? true : false;
	}

	@Override
	public boolean modifyResult(Result result) {
		return resultMapper.updateByPrimaryKeySelective(result) == 1 ? true : false;
	}

	@Override
	public List<Result> findAllResult(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName) {
		// 分页
		PageHelper.startPage(pageIndex == null ? 1 : pageIndex, pageSize == null ? 10 : pageSize);
		// 排序
		if (order != null && orderName != null)
			PageHelper.orderBy(orderName + " " + order);
		List<Result> results = resultMapper.selectAll();
		for (Result result : results) {
			result.setEmployee(employeeMapper.selectByPrimaryKey(result.getEmployee().getEmpno()));
			result.setMerit(meritMapper.selectByPrimaryKey(result.getMerit().getMerno()));
		}
		return results;
	}

	@Override
	public List<Result> findResultByMerno(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName, String merno) {
		// 分页
		PageHelper.startPage(pageIndex == null ? 1 : pageIndex, pageSize == null ? 10 : pageSize);
		// 排序
		if (order != null && orderName != null)
			PageHelper.orderBy(orderName + " " + order);
		List<Result> results = resultMapper.selectByMerno(merno);
		for (Result result : results) {
			result.setEmployee(employeeMapper.selectByPrimaryKey(result.getEmployee().getEmpno()));
			result.setMerit(meritMapper.selectByPrimaryKey(result.getMerit().getMerno()));
		}
		return results;
	}

}
