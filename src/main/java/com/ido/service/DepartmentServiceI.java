package com.ido.service;

import java.util.List;

import com.ido.bean.Department;

public interface DepartmentServiceI {

	/** 增加部门 */
	public boolean addDepartment(Department department);

	/** 合并部门 */
	public boolean mergeDepartment(String oldDeptno, String newDeptno);

	/** 修改部门信息 */
	public boolean modifyDepartment(Department department);

	/** 查询所有部门信息 */
	public List<Department> findDepartments(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName);

	/** 根据员工编号查询部门信息 */
	public Department findDepartmentByDeptno(String deptno);

	/** 查询所有部门编号和名称 */
	public List<Department> findDepartmentsNameAndNo();

}
