package com.ido.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ido.bean.Attend;
import com.ido.service.AttendServiceI;

@Controller
@RequestMapping("/attend")
public class AttendController {

	@Autowired
	private AttendServiceI attendServiceI;

	/**
	 * 显示当天考勤结果页面
	 * 
	 * @return
	 */
	@RequestMapping("/cdshowall")
	public String showCurrDayAttend() {
		return "attend/cdattend";
	}

	/**
	 * 显示考勤结果页面
	 * 
	 * @return
	 */
	@RequestMapping("/showall")
	public String showAttend() {
		return "attend/attend";
	}

	/**
	 * 当天考勤信息查询
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
	@RequestMapping("/cdshow")
	public @ResponseBody Object findCurrDayAttend(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName, String batch) {
		List<Attend> attends = attendServiceI.findCurrDayAttend(pageIndex, pageSize, search, order, orderName, batch);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("total", attends.size());
		jsonObject.put("rows", attends);
		return jsonObject;
	}

	/**
	 * 考勤信息查询
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
	public @ResponseBody Object findAttend(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName, String start, String end, String batch) {
		List<Attend> attends = attendServiceI.findAllAttend(pageIndex, pageSize, search, order, orderName,
				new Date(Long.parseLong(start)), new Date(Long.parseLong(end)), batch);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("total", attends.size());
		jsonObject.put("rows", attends);
		return jsonObject;
	}
}
