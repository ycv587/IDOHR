package com.ido.mapper;

import com.ido.bean.Apptype;

public interface ApptypeMapper {
	int deleteByPrimaryKey(String atypeno);

	int insert(Apptype record);

	int insertSelective(Apptype record);

	Apptype selectByPrimaryKey(String atypeno);

	int updateByPrimaryKeySelective(Apptype record);

	int updateByPrimaryKey(Apptype record);
}