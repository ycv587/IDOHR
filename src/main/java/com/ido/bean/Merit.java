package com.ido.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @作者：YANGCHEN @日期：2018-04-06
 * @描述：绩效考核记录
 */
public class Merit implements Serializable {

	private static final long serialVersionUID = 1L;
	// 考核记录号
	private String merno;
	// 考核名称
	private String assname;
	// 考核发起人
	private String initemp;
	// 开始时间
	private Date starttime;
	// 结束时间
	private Date endtime;

	public String getMerno() {
		return merno;
	}

	public void setMerno(String merno) {
		this.merno = merno == null ? null : merno.trim();
	}

	public String getAssname() {
		return assname;
	}

	public void setAssname(String assname) {
		this.assname = assname == null ? null : assname.trim();
	}

	public String getInitemp() {
		return initemp;
	}

	public void setInitemp(String initemp) {
		this.initemp = initemp == null ? null : initemp.trim();
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
}