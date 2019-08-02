package com.ido.bean;

public class Emprole {
	private String epno;

	private String empno;

	private String roleno;

	public String getEpno() {
		return epno;
	}

	public void setEpno(String epno) {
		this.epno = epno == null ? null : epno.trim();
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno == null ? null : empno.trim();
	}

	public String getRoleno() {
		return roleno;
	}

	public void setRoleno(String roleno) {
		this.roleno = roleno == null ? null : roleno.trim();
	}
}