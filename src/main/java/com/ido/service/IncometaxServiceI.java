package com.ido.service;

import java.util.List;

import com.ido.bean.Incometax;

public interface IncometaxServiceI {

	/** 新增个人所得税配置 */
	public boolean addIncometax(Incometax incometax);

	/** 修改个人所得税配置 */
	public boolean modifyIncometax(Incometax incometax);

	/** 查询所有个人所得税配置 */
	public List<Incometax> findAllIncometax();
}
