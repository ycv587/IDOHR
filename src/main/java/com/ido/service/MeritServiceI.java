package com.ido.service;

import java.util.Date;
import java.util.List;

import com.ido.bean.Merit;

public interface MeritServiceI {

	/** 新增绩效考核 */
	public boolean addMerit(Merit merit);

	/** 修改绩效考核信息 */
	public boolean modifyMerit(Merit merit);
	
	/** 不分页式查看所有考核信息 */
	public List<Merit> findOffWithoutPage();

	/** 查询所有绩效考核信息 */
	public List<Merit> findAll(Integer pageIndex, Integer pageSize, String search, String order, String orderName);

	/** 查询正在进行的绩效考核 */
	public List<Merit> findOn(Integer pageIndex, Integer pageSize, String search, String order, String orderName);

	/** 查询已结束的绩效考核 */
	public List<Merit> findOff(Integer pageIndex, Integer pageSize, String search, String order, String orderName);

	/** 查询即将开始的绩效考核 */
	public List<Merit> findStart(Integer pageIndex, Integer pageSize, String search, String order, String orderName);

	/** 查询某时间点正在进行的绩效考核 */
	public List<Merit> findByTime(Integer pageIndex, Integer pageSize, String search, String order, String orderName,
			Date time);
}
