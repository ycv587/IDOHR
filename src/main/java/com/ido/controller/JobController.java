package com.ido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.ido.bean.Job;
import com.ido.service.JobServiceI;

@Controller
@RequestMapping("/job")
public class JobController {

	@Autowired
	private JobServiceI jobServiceI;

	/**
	 * 显示职位信息页面
	 * 
	 * @return
	 */
	@RequestMapping("/showall")
	public String showDept() {
		return "job/job";
	}

	/**
	 * 职位信息查询
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
	public @ResponseBody Object findJobs(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName) {
		List<Job> jobs = jobServiceI.findJobs(pageIndex, pageSize, search, order, orderName);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("total", new PageInfo<>(jobs).getTotal());
		jsonObject.put("rows", jobs);
		return jsonObject;
	}

	/**
	 * 新增职位
	 * 
	 * @param job
	 * @return
	 */
	@PutMapping("/add")
	public @ResponseBody String addJob(@RequestBody Job job) {
		return jobServiceI.addJob(job) ? "1" : "0";
	}

	/**
	 * 职位信息修改
	 * 
	 * @param job
	 * @return
	 */
	@PostMapping("/modify")
	public @ResponseBody String modifyJob(@RequestBody Job job) {
		return jobServiceI.modifyJob(job) ? "1" : "0";
	}

	/**
	 * 合并职位
	 * 
	 * @param oldDeptno
	 * @param newDeptno
	 * @return
	 */
	@DeleteMapping("/merge")
	public @ResponseBody String mergeJob(@RequestBody String[] params) {
		return jobServiceI.mergeJob(params[0], params[1]) ? "1" : "0";
	}

	/**
	 * 职位查重
	 * 
	 * @param deptno
	 * @return
	 */
	@RequestMapping("/distinct")
	public @ResponseBody String jobDistinct(String jobid) {
		return jobServiceI.findJobByJobid(jobid) == null ? "1" : "0";
	}

	/**
	 * 查询所有职位编号和名称
	 * 
	 * @return
	 */
	@GetMapping("/findnameandno")
	public @ResponseBody Object findAllJobNameAndNo() {
		return jobServiceI.findAllJobNameAndNo();
	}
}
