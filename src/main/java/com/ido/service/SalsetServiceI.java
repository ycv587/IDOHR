package com.ido.service;

import java.util.List;

import com.ido.bean.Salset;

public interface SalsetServiceI {

	/** 新增配置信息 */
	public boolean addSalset(Salset salset);

	/** 修改配置信息 */
	public boolean modifySalset(Salset salset);

	/** 删除配置信息 */
	public boolean deleteSalset(String ssetno);

	/** 查询所有配置信息 */
	public List<Salset> findAllSalset();
}
