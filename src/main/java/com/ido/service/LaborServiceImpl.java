package com.ido.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ido.bean.Labor;
import com.ido.mapper.LaborMapper;

@Service
public class LaborServiceImpl implements LaborServiceI {

	@Autowired
	private LaborMapper laborMapper;

	@Override
	public List<Labor> findLabors(Integer pageIndex, Integer pageSize, String search, String order, String orderName) {
		// 分页
		if (pageIndex != null && pageSize != null)
			PageHelper.startPage(pageIndex, pageSize);
		// 排序
		if (order != null && orderName != null)
			PageHelper.orderBy(orderName + " " + order);
		else
			PageHelper.orderBy("enddate" + " " + "desc"); // 默认按照结束日期降序排列
		return laborMapper.selectAll();
	}

	/**
	 * 根据员工编号查询所有合同信息
	 */
	@Override
	public List<Labor> findLaborsByEmpno(String empno, String order, String orderName) {
		// 排序
		if (order != null && orderName != null)
			PageHelper.orderBy(orderName + " " + order);
		else
			PageHelper.orderBy("enddate" + " " + "desc"); // 默认按照结束日期降序排列
		return laborMapper.selectLaborsByEmpno(empno);
	}

}
