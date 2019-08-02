package com.ido.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @作者：YANGCHEN @日期：2018-04-06
 * @描述：请假记录
 */
public class Joblevel implements Serializable {

	private static final long serialVersionUID = 1L;
	// 请假记录号
	private String levno;
	// 请假日期
	private Date levstart;
	// 结束日期
	private Date levend;
	// 备注
	private String remark;
	// 员工信息
	@Autowired
	private Employee employee;

	public String getLevno() {
		return levno;
	}

	public void setLevno(String levno) {
		this.levno = levno == null ? null : levno.trim();
	}

	public Date getLevstart() {
		return levstart;
	}

	public void setLevstart(Date levstart) {
		this.levstart = levstart;
	}

	public Date getLevend() {
		return levend;
	}

	public void setLevend(Date levend) {
		this.levend = levend;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}