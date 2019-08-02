package com.ido.bean;

import java.io.Serializable;

/**
 * @作者：YANGCHEN @日期：2018-04-06
 * @描述：个人所得税配置
 */
public class Incometax implements Serializable {

	private static final long serialVersionUID = 1L;
	// 个人所得税配置号
	private String taxno;
	// 起始薪资
	private Float taxstart;
	// 税率
	private Float rate;
	// 速算扣除数
	private Float taxsub;
	// 配置启用标记
	private Integer taxflag;

	public String getTaxno() {
		return taxno;
	}

	public void setTaxno(String taxno) {
		this.taxno = taxno == null ? null : taxno.trim();
	}

	public Float getTaxstart() {
		return taxstart;
	}

	public void setTaxstart(Float taxstart) {
		this.taxstart = taxstart;
	}

	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

	public Float getTaxsub() {
		return taxsub;
	}

	public void setTaxsub(Float taxsub) {
		this.taxsub = taxsub;
	}

	public Integer getTaxflag() {
		return taxflag;
	}

	public void setTaxflag(Integer taxflag) {
		this.taxflag = taxflag;
	}
}