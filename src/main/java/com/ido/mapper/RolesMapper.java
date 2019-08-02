package com.ido.mapper;

import com.ido.bean.Roles;

public interface RolesMapper {
	int deleteByPrimaryKey(String roleno);

	int insert(Roles record);

	int insertSelective(Roles record);

	Roles selectByPrimaryKey(String roleno);

	int updateByPrimaryKeySelective(Roles record);

	int updateByPrimaryKey(Roles record);
}