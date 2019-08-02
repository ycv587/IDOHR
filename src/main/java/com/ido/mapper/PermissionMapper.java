package com.ido.mapper;

import com.ido.bean.Permission;

public interface PermissionMapper {
	int deleteByPrimaryKey(String perid);

	int insert(Permission record);

	int insertSelective(Permission record);

	Permission selectByPrimaryKey(String perid);

	int updateByPrimaryKeySelective(Permission record);

	int updateByPrimaryKey(Permission record);
}