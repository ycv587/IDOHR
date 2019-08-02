package com.ido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.ido.bean.Labor;
import com.ido.service.LaborServiceI;

@Controller
@RequestMapping("/labor")
public class LaborController {

	@Autowired
	private LaborServiceI laborServiceI;

	/**
	 * 查询所有劳务合同
	 * 
	 * @param pageIndex
	 * @param pageSize
	 * @param search
	 * @param order
	 * @param orderName
	 * @return
	 */
	@GetMapping("/show")
	public @ResponseBody Object findLabors(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName) {
		List<Labor> labors = laborServiceI.findLabors(pageIndex, pageSize, search, order, orderName);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("total", new PageInfo<>(labors).getTotal());
		jsonObject.put("rows", labors);
		return jsonObject;
	}

	/**
	 * 根据员工编号查询员工合同信息
	 * 
	 * @param empno
	 * @param order
	 * @param orderName
	 * @return
	 */
	@GetMapping("/showbyempno")
	public @ResponseBody Object findLaborsByEmpno(String empno, String order, String orderName) {
		return laborServiceI.findLaborsByEmpno(empno, order, orderName);
	}

}
