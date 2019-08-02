package com.ido.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @作者：YANGCHEN @日期：2018-03-24
 * @描述：签到结果
 */
public class Attend implements Serializable {

	private static final long serialVersionUID = 1L;
	// 出勤记录号
	private String attno;
	// 打卡日期
	private Date pdate;
	// 打卡时间
	private Date ptime;

	// 员工信息
	@Autowired
	private Employee employee;

	// 打卡批次信息
	@Autowired
	private Attset attset;

	public String getAttno() {
		return attno;
	}

	public void setAttno(String attno) {
		this.attno = attno == null ? null : attno.trim();
	}

	public Date getPdate() {
		return pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	public Date getPtime() {
		return ptime;
	}

	public void setPtime(Date ptime) {
		this.ptime = ptime;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Attset getAttset() {
		return attset;
	}

	public void setAttset(Attset attset) {
		this.attset = attset;
	}
}