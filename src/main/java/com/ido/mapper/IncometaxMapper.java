package com.ido.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ido.bean.Incometax;

@Repository
public interface IncometaxMapper {

	int deleteByPrimaryKey(String taxno);

	int insert(Incometax record);

	int insertSelective(Incometax record);

	Incometax selectByPrimaryKey(String taxno);

	int updateByPrimaryKeySelective(Incometax record);

	int updateByPrimaryKey(Incometax record);

	/** 查询所有个人所得税配置 */
	List<Incometax> selectAll();
}