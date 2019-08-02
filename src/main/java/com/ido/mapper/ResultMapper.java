package com.ido.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ido.bean.Result;

@Repository
public interface ResultMapper {

	int deleteByPrimaryKey(String resno);

	int insert(Result record);

	int insertSelective(Result record);

	Result selectByPrimaryKey(String resno);

	int updateByPrimaryKeySelective(Result record);

	int updateByPrimaryKey(Result record);

	/** 查询所有记录 */
	List<Result> selectAll();

	/** 根据考核号查询 */
	List<Result> selectByMerno(String merno);
}