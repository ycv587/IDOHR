package com.ido.service;

import java.util.List;

import com.ido.bean.Labor;

public interface LaborServiceI {
	/** 查询所有合同信息 */
	public List<Labor> findLabors(Integer pageIndex, Integer pageSize, String search, String order, String orderName);

	/** 根据员工编号查询所有合同信息 */
	public List<Labor> findLaborsByEmpno(String empno, String order, String orderName);
}
