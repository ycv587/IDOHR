package com.ido.bean;

public class Permission {
	private String perid;

	private String percode;

	private String resurl;

	private String resource;

	private Integer available;

	public String getPerid() {
		return perid;
	}

	public void setPerid(String perid) {
		this.perid = perid == null ? null : perid.trim();
	}

	public String getPercode() {
		return percode;
	}

	public void setPercode(String percode) {
		this.percode = percode == null ? null : percode.trim();
	}

	public String getResurl() {
		return resurl;
	}

	public void setResurl(String resurl) {
		this.resurl = resurl == null ? null : resurl.trim();
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource == null ? null : resource.trim();
	}

	public Integer getAvailable() {
		return available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
	}
}