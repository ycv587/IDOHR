package com.ido.bean;

import java.io.Serializable;

/**
 * @作者：YANGCHEN @日期：2018-04-06
 * @描述：职位信息
 */
public class Job implements Serializable {

	private static final long serialVersionUID = 1L;
	// 职位号
	private String jobid;
	// 职位名称
	private String jname;
	// 职位人数
	private Integer count;

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid == null ? null : jobid.trim();
	}

	public String getJname() {
		return jname;
	}

	public void setJname(String jname) {
		this.jname = jname == null ? null : jname.trim();
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}