package com.ido.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @作者：YANGCHEN @日期：2018-04-06
 * @描述：员工教育信息
 */
public class Education implements Serializable {

	private static final long serialVersionUID = 1L;
	// 教育信息编号
	private String eduno;
	// 员工号
	private String empno;
	// 学历
	private String diploma;
	// 毕业年份
	private Date gyear;
	// 毕业学校
	private String gschool;
	// 专业
	private String majors;

	public String getEduno() {
		return eduno;
	}

	public void setEduno(String eduno) {
		this.eduno = eduno == null ? null : eduno.trim();
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno == null ? null : empno.trim();
	}

	public String getDiploma() {
		return diploma;
	}

	public void setDiploma(String diploma) {
		this.diploma = diploma == null ? null : diploma.trim();
	}

	public Date getGyear() {
		return gyear;
	}

	public void setGyear(Date gyear) {
		this.gyear = gyear;
	}

	public String getGschool() {
		return gschool;
	}

	public void setGschool(String gschool) {
		this.gschool = gschool == null ? null : gschool.trim();
	}

	public String getMajors() {
		return majors;
	}

	public void setMajors(String majors) {
		this.majors = majors == null ? null : majors.trim();
	}
}