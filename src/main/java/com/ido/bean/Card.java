package com.ido.bean;

import java.io.Serializable;

/**
 * @作者：YANGCHEN @日期：2018-04-06
 * @描述：员工卡号记录
 */
public class Card implements Serializable {

	private static final long serialVersionUID = 1L;
	// 卡号登记记录号
	private String carno;
	// 员工编号
	private String empno;
	// 工资卡账户
	private String salaryac;
	// 工资卡开户行
	private String saladdr;
	// 公积金账户
	private String provideac;
	// 公积金开户行
	private String proaddr;
	// 社保账户
	private String socac;
	// 社保开户行
	private String socaddr;

	public String getCarno() {
		return carno;
	}

	public void setCarno(String carno) {
		this.carno = carno == null ? null : carno.trim();
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno == null ? null : empno.trim();
	}

	public String getSalaryac() {
		return salaryac;
	}

	public void setSalaryac(String salaryac) {
		this.salaryac = salaryac == null ? null : salaryac.trim();
	}

	public String getSaladdr() {
		return saladdr;
	}

	public void setSaladdr(String saladdr) {
		this.saladdr = saladdr == null ? null : saladdr.trim();
	}

	public String getProvideac() {
		return provideac;
	}

	public void setProvideac(String provideac) {
		this.provideac = provideac == null ? null : provideac.trim();
	}

	public String getProaddr() {
		return proaddr;
	}

	public void setProaddr(String proaddr) {
		this.proaddr = proaddr == null ? null : proaddr.trim();
	}

	public String getSocac() {
		return socac;
	}

	public void setSocac(String socac) {
		this.socac = socac == null ? null : socac.trim();
	}

	public String getSocaddr() {
		return socaddr;
	}

	public void setSocaddr(String socaddr) {
		this.socaddr = socaddr == null ? null : socaddr.trim();
	}
}