package com.ido.bean;

import java.io.Serializable;

/**
 * @作者：YANGCHEN @日期：2018-04-06
 * @描述：合同文件信息
 */
public class Contract implements Serializable {

	private static final long serialVersionUID = 1L;
	// 合同号
	private String conno;
	// 合同名
	private String conname;
	// 合同路径
	private String conpath;
	// 合同有效标记
	private Integer conflag;

	public String getConno() {
		return conno;
	}

	public void setConno(String conno) {
		this.conno = conno == null ? null : conno.trim();
	}

	public String getConname() {
		return conname;
	}

	public void setConname(String conname) {
		this.conname = conname == null ? null : conname.trim();
	}

	public String getConpath() {
		return conpath;
	}

	public void setConpath(String conpath) {
		this.conpath = conpath == null ? null : conpath.trim();
	}

	public Integer getConflag() {
		return conflag;
	}

	public void setConflag(Integer conflag) {
		this.conflag = conflag;
	}
}