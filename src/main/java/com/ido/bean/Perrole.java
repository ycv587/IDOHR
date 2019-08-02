package com.ido.bean;

public class Perrole {
	private String prno;

	private String perid;

	private String roleno;

	public String getPrno() {
		return prno;
	}

	public void setPrno(String prno) {
		this.prno = prno == null ? null : prno.trim();
	}

	public String getPerid() {
		return perid;
	}

	public void setPerid(String perid) {
		this.perid = perid == null ? null : perid.trim();
	}

	public String getRoleno() {
		return roleno;
	}

	public void setRoleno(String roleno) {
		this.roleno = roleno == null ? null : roleno.trim();
	}
}