package com.ido.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @作者：YANGCHEN @日期：2018-04-06
 * @描述：加班记录
 */
public class Jobover implements Serializable {

	private static final long serialVersionUID = 1L;
	// 加班记录号
	private String overno;
	// 开始时间
	private Date overstart;
	// 结束时间
	private Date overend;
	// 加班类型
	private String overtype;
	// 备注
	private String remark;
	// 员工信息
	@Autowired
	private Employee employee;

	public String getOverno() {
		return overno;
	}

	public void setOverno(String overno) {
		this.overno = overno == null ? null : overno.trim();
	}

	public Date getOverstart() {
		return overstart;
	}

	public void setOverstart(Date overstart) {
		this.overstart = overstart;
	}

	public Date getOverend() {
		return overend;
	}

	public void setOverend(Date overend) {
		this.overend = overend;
	}

	public String getOvertype() {
		return overtype;
	}

	public void setOvertype(String overtype) {
		this.overtype = overtype == null ? null : overtype.trim();
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