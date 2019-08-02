package com.ido.service;

import java.util.List;

import com.ido.bean.Joblevel;

public interface JoblevelServiceI {

	/** 新增请假记录 */
	public boolean addJoblevel(Joblevel joblevel);

	/** 查询所有请假记录 */
	public List<Joblevel> findAllJoblevel(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName);

	/** 根据员工号查询请假记录 */
	public List<Joblevel> findByEmpno(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName);
}
