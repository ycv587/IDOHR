package com.ido.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ido.bean.Salset;

@Repository
public interface SalsetMapper {

	int deleteByPrimaryKey(String ssetno);

	int insert(Salset record);

	int insertSelective(Salset record);

	Salset selectByPrimaryKey(String ssetno);

	int updateByPrimaryKeySelective(Salset record);

	int updateByPrimaryKey(Salset record);

	/** 查询所有薪资配置 */
	List<Salset> selectAll();
}