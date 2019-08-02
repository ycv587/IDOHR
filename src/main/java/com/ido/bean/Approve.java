package com.ido.bean;

import java.util.Date;

public class Approve {
	private String appno;

	private String subemp;

	private String atypeno;

	private Date apptime;

	private String dealemp;

	private Date dealtime;

	private Integer appresult;

	private String remark;

	public String getAppno() {
		return appno;
	}

	public void setAppno(String appno) {
		this.appno = appno == null ? null : appno.trim();
	}

	public String getSubemp() {
		return subemp;
	}

	public void setSubemp(String subemp) {
		this.subemp = subemp == null ? null : subemp.trim();
	}

	public String getAtypeno() {
		return atypeno;
	}

	public void setAtypeno(String atypeno) {
		this.atypeno = atypeno == null ? null : atypeno.trim();
	}

	public Date getApptime() {
		return apptime;
	}

	public void setApptime(Date apptime) {
		this.apptime = apptime;
	}

	public String getDealemp() {
		return dealemp;
	}

	public void setDealemp(String dealemp) {
		this.dealemp = dealemp == null ? null : dealemp.trim();
	}

	public Date getDealtime() {
		return dealtime;
	}

	public void setDealtime(Date dealtime) {
		this.dealtime = dealtime;
	}

	public Integer getAppresult() {
		return appresult;
	}

	public void setAppresult(Integer appresult) {
		this.appresult = appresult;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
}