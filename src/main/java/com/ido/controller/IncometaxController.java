package com.ido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ido.bean.Incometax;
import com.ido.service.IncometaxServiceI;

@Controller
@RequestMapping("/incometax")
public class IncometaxController {

	@Autowired
	private IncometaxServiceI incometaxServiceI;

	@RequestMapping("/show")
	public @ResponseBody Object findIncometax() {
		List<Incometax> incometaxs = incometaxServiceI.findAllIncometax();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("total", incometaxs.size());
		jsonObject.put("rows", incometaxs);
		return jsonObject;
	}

	@RequestMapping("/add")
	public @ResponseBody String addIncometax(@RequestBody Incometax incometax) {
		return incometaxServiceI.addIncometax(incometax) ? "1" : "0";
	}

	@RequestMapping("/modify")
	public @ResponseBody String modifyIncometax(@RequestBody Incometax incometax) {
		return incometaxServiceI.modifyIncometax(incometax) ? "1" : "0";
	}

}
