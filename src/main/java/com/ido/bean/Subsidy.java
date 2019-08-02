package com.ido.bean;

import java.math.BigDecimal;

public class Subsidy {
	
	private String subno;

	private String empno;

	private BigDecimal traffic;

	private BigDecimal meal;

	private BigDecimal housing;

	private BigDecimal seniority;

	private BigDecimal fivefund;

	private BigDecimal business;

	public String getSubno() {
		return subno;
	}

	public void setSubno(String subno) {
		this.subno = subno == null ? null : subno.trim();
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno == null ? null : empno.trim();
	}

	public BigDecimal getTraffic() {
		return traffic;
	}

	public void setTraffic(BigDecimal traffic) {
		this.traffic = traffic;
	}

	public BigDecimal getMeal() {
		return meal;
	}

	public void setMeal(BigDecimal meal) {
		this.meal = meal;
	}

	public BigDecimal getHousing() {
		return housing;
	}

	public void setHousing(BigDecimal housing) {
		this.housing = housing;
	}

	public BigDecimal getSeniority() {
		return seniority;
	}

	public void setSeniority(BigDecimal seniority) {
		this.seniority = seniority;
	}

	public BigDecimal getFivefund() {
		return fivefund;
	}

	public void setFivefund(BigDecimal fivefund) {
		this.fivefund = fivefund;
	}

	public BigDecimal getBusiness() {
		return business;
	}

	public void setBusiness(BigDecimal business) {
		this.business = business;
	}
}