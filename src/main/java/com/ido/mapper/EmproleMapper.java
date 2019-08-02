package com.ido.mapper;

import com.ido.bean.Emprole;

public interface EmproleMapper {
	int deleteByPrimaryKey(String epno);

	int insert(Emprole record);

	int insertSelective(Emprole record);

	Emprole selectByPrimaryKey(String epno);

	int updateByPrimaryKeySelective(Emprole record);

	int updateByPrimaryKey(Emprole record);
}