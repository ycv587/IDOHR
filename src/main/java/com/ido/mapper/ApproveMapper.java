package com.ido.mapper;

import com.ido.bean.Approve;

public interface ApproveMapper {
	int deleteByPrimaryKey(String appno);

	int insert(Approve record);

	int insertSelective(Approve record);

	Approve selectByPrimaryKey(String appno);

	int updateByPrimaryKeySelective(Approve record);

	int updateByPrimaryKey(Approve record);
}