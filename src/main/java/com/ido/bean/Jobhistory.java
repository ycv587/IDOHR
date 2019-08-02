package com.ido.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @作者：YANGCHEN @日期：2018-04-06
 * @描述：工作经历记录
 */
public class Jobhistory implements Serializable {

	private static final long serialVersionUID = 1L;
	// 工作经历记录号
	private String hisno;
	// 员工编号
	private String empno;
	// 公司名称
	private String company;
	// 入职日期
	private Date hhire;
	// 离职日期
	private Date hquit;
	// 任职
	private String job;

	public String getHisno() {
		return hisno;
	}

	public void setHisno(String hisno) {
		this.hisno = hisno == null ? null : hisno.trim();
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno == null ? null : empno.trim();
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company == null ? null : company.trim();
	}

	public Date getHhire() {
		return hhire;
	}

	public void setHhire(Date hhire) {
		this.hhire = hhire;
	}

	public Date getHquit() {
		return hquit;
	}

	public void setHquit(Date hquit) {
		this.hquit = hquit;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job == null ? null : job.trim();
	}
}