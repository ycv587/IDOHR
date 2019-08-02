package com.ido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ido.bean.Salset;
import com.ido.service.SalsetServiceI;

@Controller
@RequestMapping("salset")
public class SalsetController {

	@Autowired
	private SalsetServiceI salsetService;

	@RequestMapping("/showall")
	public String showSalset() {
		return "salary/salset";
	}

	@RequestMapping("/add")
	public @ResponseBody String addSalset(@RequestBody Salset salset) {
		return salsetService.addSalset(salset) ? "1" : "0";
	}

	@RequestMapping("/modify")
	public @ResponseBody String modifySalset(@RequestBody Salset salset) {
		return salsetService.modifySalset(salset) ? "1" : "0";
	}
	
	@RequestMapping("/show")
	public @ResponseBody Object findSalset() {
		List<Salset> salsets = salsetService.findAllSalset();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("total", salsets.size());
		jsonObject.put("rows", salsets);
		return jsonObject;
	}

}
