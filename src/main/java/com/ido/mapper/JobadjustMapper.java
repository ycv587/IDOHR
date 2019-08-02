package com.ido.mapper;

import com.ido.bean.Jobadjust;

public interface JobadjustMapper {
	int deleteByPrimaryKey(String adjno);

	int insert(Jobadjust record);

	int insertSelective(Jobadjust record);

	Jobadjust selectByPrimaryKey(String adjno);

	int updateByPrimaryKeySelective(Jobadjust record);

	int updateByPrimaryKey(Jobadjust record);
}