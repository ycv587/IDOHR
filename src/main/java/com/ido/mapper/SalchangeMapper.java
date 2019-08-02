package com.ido.mapper;

import com.ido.bean.Salchange;

public interface SalchangeMapper {
	int deleteByPrimaryKey(String chano);

	int insert(Salchange record);

	int insertSelective(Salchange record);

	Salchange selectByPrimaryKey(String chano);

	int updateByPrimaryKeySelective(Salchange record);

	int updateByPrimaryKey(Salchange record);
}