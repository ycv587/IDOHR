package com.ido.service;

import java.util.List;

import com.ido.bean.Attset;

/**
 * @作者：YANGCHEN @日期：2018-03-23
 * @描述：签到配置服务层
 */
public interface AttsetServiceI {

	/** 新增配置项 */
	public boolean addAttset(Attset attset);

	/** 删除配置项 */
	public boolean delAttset(String setno);

	/** 启用配置项 */
	public boolean onAttset(String setno);

	/** 停用配置项 */
	public boolean offAttset(String setno);

	/** 修改配置时间 */
	public boolean modifyAttset(Attset attset);

	/** 查询所有配置项 */
	public List<Attset> findAllAttset(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName);

	/** 查询已启用的配置项 */
	public List<Attset> findOnAttset();

	/** 查询未启用的配置项 */
	public List<Attset> findOffAttset();

	/** 配置项重复查询 */
	public Attset findAttsetBySetno(String setno);
}
