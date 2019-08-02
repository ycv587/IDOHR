package com.ido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.ido.bean.Joblevel;
import com.ido.service.JoblevelServiceI;

@Controller
@RequestMapping("joblevel")
public class JoblevelController {

	@Autowired
	private JoblevelServiceI joblevelServiceI;

	@RequestMapping("/showall")
	public String showMessage() {
		return "emp/joblevel";
	}

	@RequestMapping("/show")
	public @ResponseBody Object findJoblevel(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName) {
		List<Joblevel> joblevels = null;
		if (search != null && !search.trim().equals("")) {
			joblevels = joblevelServiceI.findByEmpno(pageIndex, pageSize, search, order, orderName);
		} else {
			joblevels = joblevelServiceI.findAllJoblevel(pageIndex, pageSize, search, order, orderName);
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("total", new PageInfo<>(joblevels).getTotal());
		jsonObject.put("rows", joblevels);
		return jsonObject;
	}

	@RequestMapping("/add")
	public @ResponseBody String addJoblevel(@RequestBody Joblevel joblevel) {
		return joblevelServiceI.addJoblevel(joblevel) ? "1" : "0";
	}
}
