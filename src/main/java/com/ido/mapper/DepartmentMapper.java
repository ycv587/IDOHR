package com.ido.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.ido.bean.Department;

@Repository
public interface DepartmentMapper {

	int deleteByPrimaryKey(String deptno);

	int insert(Department record);

	int insertSelective(Department record);

	Department selectByPrimaryKey(String deptno);

	int updateByPrimaryKeySelective(Department record);

	int updateByPrimaryKey(Department record);

	/** 查询所有部门信息 */
	List<Department> selectAll();

	/** 查询所有部门编号和名称 */
	List<Department> selectAllNameAndNo();

}