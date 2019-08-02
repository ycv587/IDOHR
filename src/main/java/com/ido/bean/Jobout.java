package com.ido.bean;

import java.util.Date;

public class Jobout {
	private String outno;

	private String empno;

	private Date outdate;

	private String remark;

	public String getOutno() {
		return outno;
	}

	public void setOutno(String outno) {
		this.outno = outno == null ? null : outno.trim();
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno == null ? null : empno.trim();
	}

	public Date getOutdate() {
		return outdate;
	}

	public void setOutdate(Date outdate) {
		this.outdate = outdate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
}