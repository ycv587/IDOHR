package com.ido.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ido.bean.Salary;

@Repository
public interface SalaryMapper {

	int deleteByPrimaryKey(String salno);

	int insert(Salary record);

	int insertSelective(Salary record);

	Salary selectByPrimaryKey(String salno);

	int updateByPrimaryKeySelective(Salary record);

	int updateByPrimaryKey(Salary record);

	/** 查询所有薪资记录 */
	List<Salary> selectAll();

	/** 查询某月薪资记录 */
	List<Salary> selectByDate(@Param("startday") Date startday, @Param("endday") Date endday);
}