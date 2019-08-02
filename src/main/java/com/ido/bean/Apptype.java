package com.ido.bean;

public class Apptype {
	private String atypeno;

	private String atype;

	public String getAtypeno() {
		return atypeno;
	}

	public void setAtypeno(String atypeno) {
		this.atypeno = atypeno == null ? null : atypeno.trim();
	}

	public String getAtype() {
		return atype;
	}

	public void setAtype(String atype) {
		this.atype = atype == null ? null : atype.trim();
	}
}