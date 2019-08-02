package com.ido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ido.bean.Employee;
import com.ido.service.EmployeeServiceI;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeServiceI employeeServiceI;

	/**
	 * 显示员工信息页面
	 * 
	 * @return
	 */
	@RequestMapping("/showall")
	public String showEmp() {
		return "emp/emp";
	}

	/**
	 * 员工信息查询
	 * 
	 * @param pageIndex
	 *            分页页数
	 * @param pageSize
	 *            每页显示数据条数
	 * @param search
	 *            查询
	 * @param order
	 *            排序方式
	 * @param orderName
	 *            排序列
	 * @return
	 */
	@RequestMapping("/show")
	public @ResponseBody Object findEmps(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName) {
		List<Employee> employees = employeeServiceI.findEmployees(pageIndex, pageSize, search, order, orderName);
		JSONObject jsonObject = new JSONObject();
		// jsonObject.put("total", new PageInfo<>(employees).getTotal());
		jsonObject.put("total", employees.size());
		jsonObject.put("rows", employees);
		return jsonObject;
	}

	/**
	 * 添加员工
	 * 
	 * @param employee
	 * @return
	 */
	@PutMapping("/add")
	public @ResponseBody String addEmp(@RequestBody Employee employee) {
		return employeeServiceI.addEmployee(employee) ? "1" : "0";
	}

	/**
	 * 查询所有员工的编号和姓名
	 */
	@GetMapping("/findnameandno")
	public @ResponseBody Object findEmpsNameAndNo() {
		return employeeServiceI.findEmployeesNameAndNo();
	}

	/**
	 * 员工查重
	 * 
	 * @param empno
	 * @return
	 */
	@GetMapping("/distinct")
	public @ResponseBody String empDistinct(String empno) {
		return employeeServiceI.findEmployeeByEmpno(empno) == null ? "1" : "0";
	}

	/**
	 * 删除员工
	 * 
	 * @param params
	 * @return
	 */
	@DeleteMapping("/del")
	public @ResponseBody String delEmployee(@RequestBody String[] params) {
		return employeeServiceI.delEmployee(params[0]) ? "1" : "0";
	}

	/**
	 * 修改员工信息
	 * 
	 * @param employee
	 * @return
	 */
	@PostMapping("modify")
	public @ResponseBody String modifyEmployee(@RequestBody Employee employee) {
		return employeeServiceI.modifyEmployee(employee) ? "1" : "0";
	}

	@RequestMapping("findname")
	public @ResponseBody Object findNameByEmpno(String empno) {
		return employeeServiceI.findEmployeeByEmpno(empno);
	}

}
