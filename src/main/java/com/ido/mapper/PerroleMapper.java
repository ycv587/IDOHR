package com.ido.mapper;

import com.ido.bean.Perrole;

public interface PerroleMapper {
	int deleteByPrimaryKey(String prno);

	int insert(Perrole record);

	int insertSelective(Perrole record);

	Perrole selectByPrimaryKey(String prno);

	int updateByPrimaryKeySelective(Perrole record);

	int updateByPrimaryKey(Perrole record);
}