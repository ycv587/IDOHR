package com.ido.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Salchange {
	private String chano;

	private String empno;

	private BigDecimal beforesal;

	private BigDecimal aftersal;

	private Date chadate;

	private String remark;

	public String getChano() {
		return chano;
	}

	public void setChano(String chano) {
		this.chano = chano == null ? null : chano.trim();
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno == null ? null : empno.trim();
	}

	public BigDecimal getBeforesal() {
		return beforesal;
	}

	public void setBeforesal(BigDecimal beforesal) {
		this.beforesal = beforesal;
	}

	public BigDecimal getAftersal() {
		return aftersal;
	}

	public void setAftersal(BigDecimal aftersal) {
		this.aftersal = aftersal;
	}

	public Date getChadate() {
		return chadate;
	}

	public void setChadate(Date chadate) {
		this.chadate = chadate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
}