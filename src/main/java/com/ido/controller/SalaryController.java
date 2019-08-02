package com.ido.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ido.bean.Salary;
import com.ido.service.SalaryServiceI;

@Controller
@RequestMapping("/salary")
public class SalaryController {

	@Autowired
	private SalaryServiceI salaryServiceI;

	@RequestMapping("/showall")
	public String showSalary() {
		return "salary/salary";
	}

	@RequestMapping("/show")
	public @ResponseBody Object findSalary(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName, String month) {
		List<Salary> salaries = null;
		if (month.equals("0")) {
			salaries = salaryServiceI.findAllSalary(pageIndex, pageSize, search, order, orderName);
		} else {
			try {
				salaries = salaryServiceI.findByDate(pageIndex, pageSize, search, order, orderName,
						new Date(Long.parseLong(month)));
			} catch (ParseException e) {
				salaries = new ArrayList<>();
			}
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("total", salaries.size());
		jsonObject.put("rows", salaries);
		return jsonObject;
	}

}
