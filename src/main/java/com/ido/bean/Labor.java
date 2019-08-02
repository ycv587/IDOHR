package com.ido.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @作者：YANGCHEN @日期：2018-04-06
 * @描述：劳务合同记录
 */
public class Labor implements Serializable {

	private static final long serialVersionUID = 1L;
	// 劳务关系编号
	private String labno;
	// 员工号
	private String empno;
	// 合同开始日期
	private Date startdate;
	// 结束日期
	private Date enddate;
	// 合同信息
	@Autowired
	private Contract contract;

	public String getLabno() {
		return labno;
	}

	public void setLabno(String labno) {
		this.labno = labno == null ? null : labno.trim();
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno == null ? null : empno.trim();
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}
}