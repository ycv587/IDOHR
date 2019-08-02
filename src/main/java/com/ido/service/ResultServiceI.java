package com.ido.service;

import java.util.List;

import com.ido.bean.Result;

public interface ResultServiceI {

	/** 新增考核结果记录 */
	public boolean addResult(Result result);

	/** 修改考核分数 */
	public boolean modifyResult(Result result);

	/** 查询所有考核结果 */
	public List<Result> findAllResult(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName);

	/** 根据考核编号查询考核结果 */
	public List<Result> findResultByMerno(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName, String merno);
}
