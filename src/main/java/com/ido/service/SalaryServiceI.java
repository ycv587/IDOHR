package com.ido.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.ido.bean.Salary;

public interface SalaryServiceI {

	/** 新增薪酬记录 */
	public boolean addSalary(Salary salary);

	/** 查询所有薪酬记录 */
	public List<Salary> findAllSalary(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName);

	/**
	 * 查询单月薪酬记录
	 * 
	 * @throws ParseException
	 */
	public List<Salary> findByDate(Integer pageIndex, Integer pageSize, String search, String order, String orderName,
			Date month) throws ParseException;

	/** 薪资结算 */
	public int settleSalary();
}
