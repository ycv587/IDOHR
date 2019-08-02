package com.ido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ido.service.EducationServiceI;

@Controller
@RequestMapping("/edu")
public class EducationController {

	@Autowired
	private EducationServiceI educationServiceI;

	/**
	 * 根据员工编号查询员工信息
	 * 
	 * @param empno
	 * @param order
	 * @param orderName
	 * @return
	 */
	@GetMapping("/showbyempno")
	public @ResponseBody Object findEdusByEmpno(String empno, String order, String orderName) {
		return educationServiceI.findEdusByEmpno(empno, order, orderName);
	}
}
