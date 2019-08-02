package com.ido.mapper;

//import java.util.Date;

import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.ido.bean.Department;
//import com.ido.bean.Employee;
//import com.ido.bean.Job;
import com.ido.common.Base;

public class EmployeeMapperTest extends Base {
//	@Autowired
//	private EmployeeMapper employeeMapper;

	@Test
	public void testInsert() {
//		Employee employee = new Employee();
//		Job job = new Job();
//		Department department = new Department();
//		employee.setEmpno("10005");
//		employee.setPassword("123456");
//		employee.setEname("王五");
//		employee.setGender("男");
//		employee.setBirthday(new Date());
//		employee.setAge(0);
//		employee.setPhone("15712345678");
//		employee.setAddress("天津市");
//		employee.setHiredate(new Date());
//		job.setJobid("11");
//		employee.setJob(job);
//		department.setDeptno("10");
//		employee.setDepartment(department);
//		// employee.setJobid("11");
//		// employee.setDeptno("10");
//		employee.setMgr("10002");
//		employee.setMarriage("未婚");
//		employee.setNativeaddr("山西省太原市");
//		employee.setPeoples("汉族");
//		employee.setIdcard("140481199510101234");
//		employee.setEstatus("在职");
//		employee.setBlood("A");
//		employee.setPolitical("共产党员");
//		employee.setClose("小王");
//		employee.setCphone("17612345678");
//		int i = employeeMapper.insert(employee);
//		System.out.println(i);
	}

	@Test
	public void testInsertSelective() {
//		Employee employee = new Employee();
//		employee.setEmpno("10002");
//		employee.setPassword("123456");
//		employee.setEname("李四");
//		int i = employeeMapper.insert(employee);
//		System.out.println(i);
	}

	@Test
	public void testDeleteByPrimaryKey() {
//		int i = employeeMapper.deleteByPrimaryKey("10002");
//		System.out.println(i);
	}

	@Test
	public void testSelectByPrimaryKey() {
//		System.out.println(employeeMapper);
//		Employee employee = employeeMapper.selectByPrimaryKey("10001");
//		System.out.println(employee);
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
//		Employee employee = new Employee();
//		employee.setEmpno("10001");
//		;
//		employee.setGender("女");
//		int i = employeeMapper.updateByPrimaryKeySelective(employee);
//		System.out.println(i);
	}

	@Test
	public void testUpdateByPrimaryKey() {
//		Employee employee = new Employee();
//		Job job = new Job();
//		Department department = new Department();
//		employee.setEmpno("10001");
//		employee.setPassword("123456");
//		employee.setEname("张三");
//		employee.setGender("男");
//		employee.setBirthday(new Date());
//		employee.setAge(0);
//		employee.setPhone("15712345678");
//		employee.setAddress("天津市");
//		employee.setHiredate(new Date());
//		// employee.setJobid("11");
//		// employee.setDeptno("10");
//		job.setJobid("11");
//		employee.setJob(job);
//		department.setDeptno("10");
//		employee.setDepartment(department);
//		employee.setMgr("10002");
//		employee.setMarriage("未婚");
//		employee.setNativeaddr("山西省太原市");
//		employee.setPeoples("汉族");
//		employee.setIdcard("140481199510101234");
//		employee.setEstatus("在职");
//		employee.setBlood("A");
//		employee.setPolitical("共产党员");
//		employee.setClose("小王");
//		employee.setCphone("17612345678");
//		int i = employeeMapper.updateByPrimaryKey(employee);
//		System.out.println(i);
	}

	@Test
	public void testUpdateByDeptno() {
//		employeeMapper.updateByDeptno("40", "10");
	}

	@Test
	public void testEmpLogin() {
//		String username = "10009";
//		// String pwd = "7c4a8d09ca3762af61e59520943dc26494f8941b";
//		String pwd = "123456";
//		Employee employee = employeeMapper.empLogin(username, pwd);
//		if (employee == null) {
//			System.out.println("NULL");
//		} else {
//			System.out.println(employee.getEname());
//		}
	}

}
