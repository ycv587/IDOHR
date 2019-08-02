package com.ido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.ido.bean.Jobover;
import com.ido.service.JoboverServiceI;

@Controller
@RequestMapping("/jobover")
public class JoboverController {

	@Autowired
	private JoboverServiceI joboverServiceI;

	@RequestMapping("/showall")
	public String showMessage() {
		return "emp/jobover";
	}

	@RequestMapping("/show")
	public @ResponseBody Object findJoblevel(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName) {
		List<Jobover> jobovers = null;
		if (search != null && !search.trim().equals("")) {
			jobovers = joboverServiceI.findByEmpno(pageIndex, pageSize, search, order, orderName);
		} else {
			jobovers = joboverServiceI.findAllJobover(pageIndex, pageSize, search, order, orderName);
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("total", new PageInfo<>(jobovers).getTotal());
		jsonObject.put("rows", jobovers);
		return jsonObject;
	}

	@RequestMapping("/add")
	public @ResponseBody String addJoblevel(@RequestBody Jobover jobover) {
		return joboverServiceI.addJobover(jobover) ? "1" : "0";
	}
}
