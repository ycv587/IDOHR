package com.ido.service;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;

import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;

//import com.ido.bean.Card;
//import com.ido.bean.Contract;
//import com.ido.bean.Department;
//import com.ido.bean.Education;
//import com.ido.bean.Employee;
//import com.ido.bean.Job;
//import com.ido.bean.Labor;
import com.ido.common.Base;

public class EmployeeServiceImplTest extends Base{
//	@Autowired
//	private EmployeeServiceI esi;
	
	@Test
	public void testAddEmployee() {
//		Employee employee = new Employee();
//		Job job = new Job();
//		Department department = new Department();
//		employee.setEmpno("10004");
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
//		
//		Card card = new Card();
//		card.setEmpno(employee.getEmpno());
//		card.setSocac("123456");
//		card.setSocaddr("山西省太原市");
//		card.setProvideac("123456");
//		card.setProaddr("山西省太原市");
//		card.setSalaryac("123456");
//		card.setSaladdr("山西省太原市");
//		employee.setCard(card);
//		
//		Education education = new Education();
//		education.setEmpno(employee.getEmpno());
//		education.setDiploma("本科");
//		education.setGschool("山西大学");
//		education.setGyear(new Date());
//		education.setMajors("软件工程");
//		ArrayList<Education> educations = new ArrayList<>();
//		educations.add(education);
//		employee.setEducations(educations);
//		
//		Labor labor = new Labor();
//		labor.setEmpno(employee.getEmpno());
//		labor.setStartdate(new Date());
//		labor.setEnddate(new Date());
//		Contract contract = new Contract();
//		contract.setConno("301");
//		labor.setContract(contract);
//		ArrayList<Labor> labors = new ArrayList<>();
//		employee.setLabors(labors);
//		
//		esi.addEmployee(employee);
	}
	
	@Test
	public void testFindEmployees() {
//		List<Employee> employees = esi.findEmployees(1, 10, null, "asc", "empno");
//		for (Employee employee : employees) {
//			System.out.println(employee.getEmpno()+":"+employee.getMgrname()+":"+employee.getDepartment().getDname());
//		}
	}
}
