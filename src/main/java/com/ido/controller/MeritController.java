package com.ido.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ido.bean.Merit;
import com.ido.service.MeritServiceI;

@Controller
@RequestMapping("/merit")
public class MeritController {

	@Autowired
	private MeritServiceI meritServiceI;

	@RequestMapping("/showall")
	public String showMerit() {
		return "merit/merit";
	}

	@RequestMapping("/showadd")
	public String showAddMerit() {
		return "merit/addmerit";
	}

	@RequestMapping("show")
	public @ResponseBody Object findMerits(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName, String way, String time) {
		Long t = Long.parseLong(time);
		List<Merit> merits = null;
		if (t == 0) {
			if (way.equals("on")) {
				merits = meritServiceI.findOn(pageIndex, pageSize, search, order, orderName);
			} else if (way.equals("off")) {
				merits = meritServiceI.findOff(pageIndex, pageSize, search, order, orderName);
			} else if (way.equals("start")) {
				merits = meritServiceI.findStart(pageIndex, pageSize, search, order, orderName);
			} else {
				merits = meritServiceI.findAll(pageIndex, pageSize, search, order, orderName);
			}
		} else {
			merits = meritServiceI.findByTime(pageIndex, pageSize, search, order, orderName, new Date(t));
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("total", merits.size());
		jsonObject.put("rows", merits);
		return jsonObject;
	}

	@RequestMapping("/add")
	public @ResponseBody String addMerit(@RequestBody Merit merit) {
		return meritServiceI.addMerit(merit) ? "1" : "0";
	}

	@RequestMapping("modify")
	public @ResponseBody String modifyMerit(@RequestBody Merit merit) {
		return meritServiceI.modifyMerit(merit) ? "1" : "0";
	}

	@RequestMapping("findnn")
	public @ResponseBody Object findMernoAndAssname() {
		return meritServiceI.findOffWithoutPage();
	}
}
