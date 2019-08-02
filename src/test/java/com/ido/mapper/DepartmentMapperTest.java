package com.ido.mapper;

//import java.util.List;

import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.ido.bean.Department;
import com.ido.common.Base;

public class DepartmentMapperTest extends Base {
//	@Autowired
//	private DepartmentMapper departmentMapper;

	@Test
	public void testDeleteByPrimaryKey() {
//		int i = departmentMapper.deleteByPrimaryKey("10");
//		System.out.println(i);
	}

	@Test
	public void testInsert() {
//		Department department = new Department();
//		department.setDeptno("10");
//		department.setDname("人事部");
//		department.setLocation("天津市");
//		int i = departmentMapper.insert(department);
//		System.out.println(i);
	}

	@Test
	public void testInsertSelective() {
//		Department department = new Department();
//		department.setDeptno("20");
//		department.setDname("研发部");
//		int i = departmentMapper.insertSelective(department);
//		System.out.println(i);
	}

	@Test
	public void testSelectByPrimaryKey() {
//		Department department = departmentMapper.selectByPrimaryKey("20");
//		System.out.println(department.getDeptno());
//		System.out.println(department.getDname());
//		System.out.println(department.getLocation());
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
//		Department department = new Department();
//		department.setDeptno("20");
//		department.setLocation("太原市");
//		int i = departmentMapper.updateByPrimaryKeySelective(department);
//		System.out.println(i);
	}

	@Test
	public void testUpdateByPrimaryKey() {
//		Department department = new Department();
//		department.setDeptno("20");
//		department.setDname("财务部");
//		department.setLocation("太原市");
//		int i = departmentMapper.updateByPrimaryKey(department);
//		System.out.println(i);
	}

	//@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testSelectAll() {
//		PageHelper.startPage(2, 10);
//		List<Department> departments = departmentMapper.selectAll();
//		System.out.println(departments.size());
//		for (Department department : departments) {
//			System.out.println(department.getDname() + ":" + department.getCount());
//		}
//		PageInfo page = new PageInfo(departments);
//		System.out.println(page.getTotal());
	}

}
