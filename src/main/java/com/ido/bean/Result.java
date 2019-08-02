package com.ido.bean;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @作者：YANGCHEN @日期：2018-04-06
 * @描述：绩效考核结果记录
 */
public class Result implements Serializable {

	private static final long serialVersionUID = 1L;
	// 绩效考核结果流水号
	private String resno;
	// 分数
	private Float score;

	// 员工信息
	@Autowired
	private Employee employee;

	// 考核信息
	@Autowired
	private Merit merit;

	public String getResno() {
		return resno;
	}

	public void setResno(String resno) {
		this.resno = resno == null ? null : resno.trim();
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Merit getMerit() {
		return merit;
	}

	public void setMerit(Merit merit) {
		this.merit = merit;
	}
}