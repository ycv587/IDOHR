package com.ido.bean;

import java.io.Serializable;

/**
 * @作者：YANGCHEN @日期：2018-04-06
 * @描述：部门信息
 */
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;
	// 部门编号
	private String deptno;
	// 部门名称
	private String dname;
	// 部门地址
	private String location;
	// 查询时临时赋值使用：
	// 部门人数
	private Integer count;

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno == null ? null : deptno.trim();
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname == null ? null : dname.trim();
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location == null ? null : location.trim();
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer empCount) {
		this.count = empCount;
	}
}