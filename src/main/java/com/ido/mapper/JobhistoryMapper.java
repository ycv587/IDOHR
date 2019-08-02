package com.ido.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ido.bean.Jobhistory;

@Repository
public interface JobhistoryMapper {

	int deleteByPrimaryKey(String hisno);

	int insert(Jobhistory record);

	int insertSelective(Jobhistory record);

	Jobhistory selectByPrimaryKey(String hisno);

	int updateByPrimaryKeySelective(Jobhistory record);

	int updateByPrimaryKey(Jobhistory record);

	/** 根据员工编号查询工作经历 */
	List<Jobhistory> selectJobhisByEmpno(String empno);
}