package com.ido.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ido.bean.Job;

@Repository
public interface JobMapper {

	int deleteByPrimaryKey(String jobid);

	int insert(Job record);

	int insertSelective(Job record);

	Job selectByPrimaryKey(String jobid);

	int updateByPrimaryKeySelective(Job record);

	int updateByPrimaryKey(Job record);

	/** 查询所有职位 */
	List<Job> selectAll();

	/** 查询所有职位编号和名称 */
	List<Job> selectAllNameAndNo();
}