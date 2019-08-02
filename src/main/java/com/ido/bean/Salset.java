package com.ido.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @作者：YANGCHEN @日期：2018-04-06
 * @描述：薪资配置
 */
public class Salset implements Serializable {

	private static final long serialVersionUID = 1L;
	// 配置记录号
	private String ssetno;
	// 配置名
	private String setname;
	// 薪资结算日
	private Integer cleardate;
	// 缺勤扣款基数
	private Float abspropo;
	// 事假扣款基数
	private Float levpropo;
	// 病假扣款基数
	private Float sickpropo;
	// 普通加班基数
	private Float nopropo;
	// 周末加班基数
	private Float wopropo;
	// 法定加班基数
	private Float qopropo;
	// 绩效结果基数
	private Float merpropo;
	// 公司养老保险基数
	private Float coldage;
	// 公司医疗保险基数
	private Float cmedical;
	// 公司失业保险基数
	private Float cunemp;
	// 公司工伤保险基数
	private Float cinjury;
	// 公司生育保险基数
	private Float cbirth;
	// 公司公积金基数
	private Float caccum;
	// 个人养老保险基数
	private Float eoldage;
	// 个人医疗保险基数
	private Float emedical;
	// 个人失业保险基数
	private Float eunemp;
	// 个人工伤保险基数
	private Float einjury;
	// 个人生育保险基数
	private Float ebirth;
	// 个人公积金基数
	private Float eaccum;
	// 是否有效
	private Integer setflag;
	// 开始执行时间
	private Date startdate;

	public String getSsetno() {
		return ssetno;
	}

	public void setSsetno(String ssetno) {
		this.ssetno = ssetno == null ? null : ssetno.trim();
	}

	public String getSetname() {
		return setname;
	}

	public void setSetname(String setname) {
		this.setname = setname == null ? null : setname.trim();
	}

	public Integer getCleardate() {
		return cleardate;
	}

	public void setCleardate(Integer cleardate) {
		this.cleardate = cleardate;
	}

	public Float getAbspropo() {
		return abspropo;
	}

	public void setAbspropo(Float abspropo) {
		this.abspropo = abspropo;
	}

	public Float getLevpropo() {
		return levpropo;
	}

	public void setLevpropo(Float levpropo) {
		this.levpropo = levpropo;
	}

	public Float getSickpropo() {
		return sickpropo;
	}

	public void setSickpropo(Float sickpropo) {
		this.sickpropo = sickpropo;
	}

	public Float getNopropo() {
		return nopropo;
	}

	public void setNopropo(Float nopropo) {
		this.nopropo = nopropo;
	}

	public Float getWopropo() {
		return wopropo;
	}

	public void setWopropo(Float wopropo) {
		this.wopropo = wopropo;
	}

	public Float getQopropo() {
		return qopropo;
	}

	public void setQopropo(Float qopropo) {
		this.qopropo = qopropo;
	}

	public Float getMerpropo() {
		return merpropo;
	}

	public void setMerpropo(Float merpropo) {
		this.merpropo = merpropo;
	}

	public Float getColdage() {
		return coldage;
	}

	public void setColdage(Float coldage) {
		this.coldage = coldage;
	}

	public Float getCmedical() {
		return cmedical;
	}

	public void setCmedical(Float cmedical) {
		this.cmedical = cmedical;
	}

	public Float getCunemp() {
		return cunemp;
	}

	public void setCunemp(Float cunemp) {
		this.cunemp = cunemp;
	}

	public Float getCinjury() {
		return cinjury;
	}

	public void setCinjury(Float cinjury) {
		this.cinjury = cinjury;
	}

	public Float getCbirth() {
		return cbirth;
	}

	public void setCbirth(Float cbirth) {
		this.cbirth = cbirth;
	}

	public Float getCaccum() {
		return caccum;
	}

	public void setCaccum(Float caccum) {
		this.caccum = caccum;
	}

	public Float getEoldage() {
		return eoldage;
	}

	public void setEoldage(Float eoldage) {
		this.eoldage = eoldage;
	}

	public Float getEmedical() {
		return emedical;
	}

	public void setEmedical(Float emedical) {
		this.emedical = emedical;
	}

	public Float getEunemp() {
		return eunemp;
	}

	public void setEunemp(Float eunemp) {
		this.eunemp = eunemp;
	}

	public Float getEinjury() {
		return einjury;
	}

	public void setEinjury(Float einjury) {
		this.einjury = einjury;
	}

	public Float getEbirth() {
		return ebirth;
	}

	public void setEbirth(Float ebirth) {
		this.ebirth = ebirth;
	}

	public Float getEaccum() {
		return eaccum;
	}

	public void setEaccum(Float eaccum) {
		this.eaccum = eaccum;
	}

	public Integer getSetflag() {
		return setflag;
	}

	public void setSetflag(Integer setflag) {
		this.setflag = setflag;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
}