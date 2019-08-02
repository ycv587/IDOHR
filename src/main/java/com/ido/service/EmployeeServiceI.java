package com.ido.service;

import java.util.List;

import com.ido.bean.Employee;

public interface EmployeeServiceI {

	/** 增加员工 */
	public boolean addEmployee(Employee employee);

	/** 删除员工 */
	public boolean delEmployee(String empno);

	/** 修改员工信息 */
	public boolean modifyEmployee(Employee employee);

	/** 查询员工信息 */
	public List<Employee> findEmployees(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName);

	/** 查询所有员工的编号和姓名 */
	public List<Employee> findEmployeesNameAndNo();

	/** 根据员工编号查询员工 */
	public Employee findEmployeeByEmpno(String empno);

}
