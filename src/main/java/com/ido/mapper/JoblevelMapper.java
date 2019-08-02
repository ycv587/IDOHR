package com.ido.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ido.bean.Joblevel;

@Repository
public interface JoblevelMapper {

	int deleteByPrimaryKey(String levno);

	int insert(Joblevel record);

	int insertSelective(Joblevel record);

	Joblevel selectByPrimaryKey(String levno);

	int updateByPrimaryKeySelective(Joblevel record);

	int updateByPrimaryKey(Joblevel record);

	/** 查询所有请假记录 */
	List<Joblevel> selectAll();

	/** 根据员工编号查询请假记录 */
	List<Joblevel> selectByEmpno(@Param("empno") String empno);
}