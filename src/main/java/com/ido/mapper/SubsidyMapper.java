package com.ido.mapper;

import com.ido.bean.Subsidy;

public interface SubsidyMapper {
	int deleteByPrimaryKey(String subno);

	int insert(Subsidy record);

	int insertSelective(Subsidy record);

	Subsidy selectByPrimaryKey(String subno);

	int updateByPrimaryKeySelective(Subsidy record);

	int updateByPrimaryKey(Subsidy record);
}