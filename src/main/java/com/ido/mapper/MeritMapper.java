package com.ido.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ido.bean.Merit;

@Repository
public interface MeritMapper {

	int deleteByPrimaryKey(String merno);

	int insert(Merit record);

	int insertSelective(Merit record);

	Merit selectByPrimaryKey(String merno);

	int updateByPrimaryKeySelective(Merit record);

	int updateByPrimaryKey(Merit record);

	/** 查询所有绩效考核 */
	List<Merit> selectAll();

	/** 查询所有正在进行的绩效考核 */
	List<Merit> selectOn();

	/** 查询所有已结束的绩效考核 */
	List<Merit> selectOff();

	/** 查询所有还未开始的绩效考核 */
	List<Merit> selectSatrt();

	/** 查询某时间点正在进行的绩效考核 */
	List<Merit> selectTime(@Param("time") Date time);
}