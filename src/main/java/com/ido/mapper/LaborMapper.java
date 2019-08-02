package com.ido.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ido.bean.Labor;

@Repository
public interface LaborMapper {

	int deleteByPrimaryKey(String labno);

	int insert(Labor record);

	int insertSelective(Labor record);

	Labor selectByPrimaryKey(String labno);

	int updateByPrimaryKeySelective(Labor record);

	int updateByPrimaryKey(Labor record);

	/** 查询所有合同信息 */
	List<Labor> selectAll();

	/** 根据员工编号查询所有的合同信息 */
	List<Labor> selectLaborsByEmpno(String empno);
}