package com.ido.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ido.bean.Education;

@Repository
public interface EducationMapper {

	int deleteByPrimaryKey(String eduno);

	int insert(Education record);

	int insertSelective(Education record);

	Education selectByPrimaryKey(String eduno);

	int updateByPrimaryKeySelective(Education record);

	int updateByPrimaryKey(Education record);

	/** 根据员工编号查询教育经历 */
	List<Education> selectEdusByEmpno(String empno);
}