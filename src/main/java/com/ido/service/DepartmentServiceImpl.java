package com.ido.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.ido.bean.Department;
import com.ido.mapper.DepartmentMapper;
import com.ido.mapper.EmployeeMapper;

@Service
public class DepartmentServiceImpl implements DepartmentServiceI {

	@Autowired
	private DepartmentMapper departmentMapper;
	@Autowired
	private EmployeeMapper employeeMapper;

	/**
	 * 增加部门
	 */
	@Override
	public boolean addDepartment(Department department) {
		return departmentMapper.insertSelective(department) > 0;
	}

	/**
	 * 合并部门
	 */
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean mergeDepartment(String oldDeptno, String newDeptno) {
		// 修改原部门人员的部门信息
		// 删除旧部门信息
		return employeeMapper.updateByDeptno(oldDeptno, newDeptno) < 0 ? false
				: departmentMapper.deleteByPrimaryKey(oldDeptno) < 0 ? false : true;
	}

	/**
	 * 修改部门信息
	 */
	@Override
	public boolean modifyDepartment(Department department) {
		return departmentMapper.updateByPrimaryKeySelective(department) >= 0;
	}

	/**
	 * 查询所有部门信息
	 */
	@Override
	public List<Department> findDepartments(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName) {
		// 分页
		PageHelper.startPage(pageIndex == null ? 1 : pageIndex, pageSize == null ? 10 : pageSize);
		// 排序
		if (order != null && orderName != null)
			PageHelper.orderBy(orderName + " " + order);
		return departmentMapper.selectAll();
	}

	/**
	 * 根据部门编号查询部门信息
	 */
	@Override
	public Department findDepartmentByDeptno(String deptno) {
		return departmentMapper.selectByPrimaryKey(deptno);
	}

	/**
	 * 查询所有部门名称和编号
	 */
	@Override
	public List<Department> findDepartmentsNameAndNo() {
		return departmentMapper.selectAllNameAndNo();
	}

}
