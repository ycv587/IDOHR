package com.ido.bean;

import java.util.Date;

public class Jobadjust {
	private String adjno;

	private String empno;

	private String prejobid;

	private String latjobid;

	private Date adjdate;

	private String remark;

	public String getAdjno() {
		return adjno;
	}

	public void setAdjno(String adjno) {
		this.adjno = adjno == null ? null : adjno.trim();
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno == null ? null : empno.trim();
	}

	public String getPrejobid() {
		return prejobid;
	}

	public void setPrejobid(String prejobid) {
		this.prejobid = prejobid == null ? null : prejobid.trim();
	}

	public String getLatjobid() {
		return latjobid;
	}

	public void setLatjobid(String latjobid) {
		this.latjobid = latjobid == null ? null : latjobid.trim();
	}

	public Date getAdjdate() {
		return adjdate;
	}

	public void setAdjdate(Date adjdate) {
		this.adjdate = adjdate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
}