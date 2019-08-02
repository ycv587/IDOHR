package com.ido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ido.service.JobhistoryServiceI;

@Controller
@RequestMapping("/jobhis")
public class JobhistoryController {

	@Autowired
	private JobhistoryServiceI jobhistoryServiceI;

	/**
	 * 根据员工编号查询工作经历
	 * 
	 * @param empno
	 * @param order
	 * @param orderName
	 * @return
	 */
	@GetMapping("/showbyempno")
	public @ResponseBody Object findJobhisByEmpno(String empno, String order, String orderName) {
		return jobhistoryServiceI.findJobhisByEmpno(empno, order, orderName);
	}

}
