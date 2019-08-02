package com.ido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ido.bean.Result;
import com.ido.service.ResultServiceI;

@Controller
@RequestMapping("/result")
public class ResultController {

	@Autowired
	private ResultServiceI resultServiceI;

	@RequestMapping("/showall")
	public String showResult() {
		return "merit/result";
	}

	@RequestMapping("/addshowall")
	public String showAddResult() {
		return "merit/addresult";
	}

	@RequestMapping("/show")
	public @ResponseBody Object findMerits(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName, String merno) {
		List<Result> results = null;
		if (merno.equals("all")) {
			results = resultServiceI.findAllResult(pageIndex, pageSize, search, order, orderName);
		} else {
			results = resultServiceI.findResultByMerno(pageIndex, pageSize, search, order, orderName, merno);
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("total", results.size());
		jsonObject.put("rows", results);
		return jsonObject;
	}

	@RequestMapping("/edit")
	public @ResponseBody String editScore(@RequestBody Result result) {
		result.setEmployee(null);
		result.setMerit(null);
		resultServiceI.modifyResult(result);
		return "1";
	}

}
