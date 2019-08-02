package com.ido.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @作者：YANGCHEN @日期：2018-03-24
 * @描述：签到配置类
 */
public class Attset implements Serializable {

	private static final long serialVersionUID = 1L;
	// 配置号/配置名
	private String setno;
	// 打卡开始时间
	private Date attstart;
	// 打卡结束时间
	private Date attend;
	// 配置项是否启用
	private Integer attflag;

	public String getSetno() {
		return setno;
	}

	public void setSetno(String setno) {
		this.setno = setno == null ? null : setno.trim();
	}

	public Date getAttstart() {
		return attstart;
	}

	public void setAttstart(Date attstart) {
		this.attstart = attstart;
	}

	public Date getAttend() {
		return attend;
	}

	public void setAttend(Date attend) {
		this.attend = attend;
	}

	public Integer getAttflag() {
		return attflag;
	}

	public void setAttflag(Integer attflag) {
		this.attflag = attflag;
	}
}