package com.ido.service;

import java.util.Date;
import java.util.List;

import com.ido.bean.Attend;

/**
 * @作者：YANGCHEN @日期：2018-03-24
 * @描述：考勤结果服务层
 */
public interface AttendServiceI {

	/** 插入打卡记录 */
	public boolean addAttend(Attend attend);

	/** 查询所有打卡记录 */
	public List<Attend> findAllAttend(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName, Date start, Date end, String batch);

	/** 查询当天打卡记录 */
	public List<Attend> findCurrDayAttend(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName, String batch);
}
