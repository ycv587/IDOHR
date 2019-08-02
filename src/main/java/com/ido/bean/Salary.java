package com.ido.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @作者：YANGCHEN @日期：2018-04-06
 * @描述：薪资记录
 */
public class Salary implements Serializable {

	private static final long serialVersionUID = 1L;
	// 工资记录号
	private String salno;
	// 基本工资
	private BigDecimal basesal;
	// 加班工时
	private Float overtime;
	// 加班工资
	private BigDecimal osal;
	// 缺勤天数
	private Float absence;
	// 缺勤扣款
	private BigDecimal asal;
	// 事假天数
	private Float lve;
	// 事假扣款
	private BigDecimal lsal;
	// 病假天数
	private Float sick;
	// 病假扣款
	private BigDecimal ssal;
	// 个人所得税
	private BigDecimal tax;
	// 个人五险一金
	private BigDecimal ownfund;
	// 实发工资
	private BigDecimal realsal;
	// 结算日期
	private Date setdate;
	// 员工信息
	@Autowired
	private Employee employee;

	public String getSalno() {
		return salno;
	}

	public void setSalno(String salno) {
		this.salno = salno == null ? null : salno.trim();
	}

	public BigDecimal getBasesal() {
		return basesal;
	}

	public void setBasesal(BigDecimal basesal) {
		this.basesal = basesal;
	}

	public Float getOvertime() {
		return overtime;
	}

	public void setOvertime(Float overtime) {
		this.overtime = overtime;
	}

	public BigDecimal getOsal() {
		return osal;
	}

	public void setOsal(BigDecimal osal) {
		this.osal = osal;
	}

	public Float getAbsence() {
		return absence;
	}

	public void setAbsence(Float absence) {
		this.absence = absence;
	}

	public BigDecimal getAsal() {
		return asal;
	}

	public void setAsal(BigDecimal asal) {
		this.asal = asal;
	}

	public Float getLve() {
		return lve;
	}

	public void setLve(Float lve) {
		this.lve = lve;
	}

	public BigDecimal getLsal() {
		return lsal;
	}

	public void setLsal(BigDecimal lsal) {
		this.lsal = lsal;
	}

	public Float getSick() {
		return sick;
	}

	public void setSick(Float sick) {
		this.sick = sick;
	}

	public BigDecimal getSsal() {
		return ssal;
	}

	public void setSsal(BigDecimal ssal) {
		this.ssal = ssal;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getOwnfund() {
		return ownfund;
	}

	public void setOwnfund(BigDecimal ownfund) {
		this.ownfund = ownfund;
	}

	public BigDecimal getRealsal() {
		return realsal;
	}

	public void setRealsal(BigDecimal realsal) {
		this.realsal = realsal;
	}

	public Date getSetdate() {
		return setdate;
	}

	public void setSetdate(Date setdate) {
		this.setdate = setdate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Salary [salno=" + salno + ", basesal=" + basesal + ", overtime=" + overtime + ", osal=" + osal
				+ ", absence=" + absence + ", asal=" + asal + ", leave=" + lve + ", lsal=" + lsal + ", sick=" + sick
				+ ", ssal=" + ssal + ", tax=" + tax + ", ownfund=" + ownfund + ", realsal=" + realsal + ", setdate="
				+ setdate + ", employee=" + employee + "]";
	}

}