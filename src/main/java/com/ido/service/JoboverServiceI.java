package com.ido.service;

import java.util.List;

import com.ido.bean.Jobover;

public interface JoboverServiceI {

	/** 新增加班记录 */
	public boolean addJobover(Jobover jobover);

	/** 查询所有加班记录 */
	public List<Jobover> findAllJobover(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName);

	/** 根据员工号查询加班记录 */
	public List<Jobover> findByEmpno(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName);
}
