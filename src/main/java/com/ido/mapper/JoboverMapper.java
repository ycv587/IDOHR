package com.ido.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ido.bean.Jobover;

@Repository
public interface JoboverMapper {

	int deleteByPrimaryKey(String overno);

	int insert(Jobover record);

	int insertSelective(Jobover record);

	Jobover selectByPrimaryKey(String overno);

	int updateByPrimaryKeySelective(Jobover record);

	int updateByPrimaryKey(Jobover record);

	/** 查询所有加班记录 */
	List<Jobover> selectAll();

	/** 根据员工号查询加班记录 */
	List<Jobover> selectByEmpno(@Param("empno") String empno);
}