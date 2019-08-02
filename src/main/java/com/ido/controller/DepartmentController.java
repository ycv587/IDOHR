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
import com.github.pagehelper.PageInfo;
import com.ido.bean.Department;
import com.ido.service.DepartmentServiceI;

@Controller
@RequestMapping("/dept")
public class DepartmentController {

	@Autowired
	private DepartmentServiceI departmentServiceI;

	/**
	 * 显示部门信息页面
	 * 
	 * @return
	 */
	@RequestMapping("/showall")
	public String showDept() {
		return "dept/dept";
	}

	/**
	 * 部门信息查询
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
	public @ResponseBody Object findDepartments(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName) {
		List<Department> departments = departmentServiceI.findDepartments(pageIndex, pageSize, search, order,
				orderName);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("total", new PageInfo<>(departments).getTotal());
		jsonObject.put("rows", departments);
		return jsonObject;
	}

	/**
	 * 添加部门
	 * 
	 * @param department
	 * @return
	 */
	@PutMapping("/add")
	public @ResponseBody String addDepartment(@RequestBody Department department) {
		return departmentServiceI.addDepartment(department) ? "1" : "0";
	}

	/**
	 * 修改部门信息
	 * 
	 * @return
	 */
	@PostMapping("/modify")
	public @ResponseBody String modifyDepartment(@RequestBody Department department) {
		return departmentServiceI.modifyDepartment(department) ? "1" : "0";
	}

	/**
	 * 合并部门
	 * 
	 * @param oldDeptno
	 * @param newDeptno
	 * @return
	 */
	@DeleteMapping("/merge")
	public @ResponseBody String mergeDepartment(@RequestBody String[] params) {
		return departmentServiceI.mergeDepartment(params[0], params[1]) ? "1" : "0";
	}

	/**
	 * 部门编号查重
	 * 
	 * @return
	 */
	@RequestMapping("/distinct")
	public @ResponseBody String deptDistinct(String deptno) {
		return departmentServiceI.findDepartmentByDeptno(deptno) == null ? "1" : "0";
	}

	/**
	 * 查询所有部门编号和名称
	 */
	@GetMapping("/findnameandno")
	public @ResponseBody Object findDeptsNameAndNo() {
		return departmentServiceI.findDepartmentsNameAndNo();
	}

}
