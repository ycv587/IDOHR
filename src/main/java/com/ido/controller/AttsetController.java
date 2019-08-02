package com.ido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ido.bean.Attset;
import com.ido.service.AttsetServiceI;

@Controller
@RequestMapping("/attset")
public class AttsetController {

	@Autowired
	private AttsetServiceI attsetServiceI;

	/**
	 * 显示配置信息页面
	 * 
	 * @return
	 */
	@RequestMapping("/showall")
	public String showAttset() {
		return "attend/attset";
	}

	/**
	 * 配置信息查询
	 * 
	 * @param pageIndex
	 *            分页页数
	 * @param pageSize
	 *            每页显示数据条数
	 * @param search
	 *            查询
	 * @param order
	 *            排序方式
	 * @param orderName
	 *            排序列
	 * @return
	 */
	@RequestMapping("/show")
	public @ResponseBody Object findAttsets(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName) {
		List<Attset> attsets = attsetServiceI.findAllAttset(pageIndex, pageSize, search, order, orderName);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("total", attsets.size());
		jsonObject.put("rows", attsets);
		return jsonObject;
	}

	/**
	 * 添加配置
	 * 
	 * @param attset
	 * @return
	 */
	@PutMapping("/add")
	public @ResponseBody String addAttset(@RequestBody Attset attset) {
		return attsetServiceI.addAttset(attset) ? "1" : "0";
	}

	/**
	 * 修改配置信息
	 * 
	 * @return
	 */
	@PostMapping("/modify")
	public @ResponseBody String modifyAttset(@RequestBody Attset attset) {
		return attsetServiceI.modifyAttset(attset) ? "1" : "0";
	}

	/**
	 * 删除配置项
	 * 
	 * @param setno
	 * @return
	 */
	@DeleteMapping("/del")
	public @ResponseBody String mergeAttset(String setno) {
		return attsetServiceI.delAttset(setno) ? "1" : "0";
	}

	/**
	 * 配置编号/配置名查重
	 * 
	 * @return
	 */
	@RequestMapping("/distinct")
	public @ResponseBody String attsetDistinct(String setno) {
		return attsetServiceI.findAttsetBySetno(setno) == null ? "1" : "0";
	}

	@RequestMapping("/findon")
	public @ResponseBody Object findOnAttsets() {
		List<Attset> attsets = attsetServiceI.findOnAttset();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("total", attsets.size());
		jsonObject.put("rows", attsets);
		return jsonObject;
	}

}
