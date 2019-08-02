package com.ido.mapper;

import com.ido.bean.Jobout;

public interface JoboutMapper {
	int deleteByPrimaryKey(String outno);

	int insert(Jobout record);

	int insertSelective(Jobout record);

	Jobout selectByPrimaryKey(String outno);

	int updateByPrimaryKeySelective(Jobout record);

	int updateByPrimaryKey(Jobout record);
}