package com.ido.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	// 员工编号
	private String empno;
	// 登录密码
	private String password;
	// 姓名
	private String ename;
	// 性别
	private String gender;
	// 生日
	private Date birthday;
	// 年龄
	private Integer age;
	// 手机号码
	private String phone;
	// 现住址
	private String address;
	// 入职日期
	private Date hiredate;
	// 直接上级
	private String mgr;
	// 婚姻状态
	private String marriage;
	// 籍贯
	private String nativeaddr;
	// 民族
	private String peoples;
	// 身份证号
	private String idcard;
	// 员工状态
	private String estatus;
	// 血型
	private String blood;
	// 政治面貌
	private String political;
	// 紧急联系人
	private String close;
	// 紧急联系方式
	private String cphone;
	// 当前基本工资
	private BigDecimal salary;
	// 部门信息
	@Autowired
	private Department department;
	// 职位信息
	@Autowired
	private Job job;
	// 卡号信息
	@Autowired
	private Card card;
	// 员工教育信息
	@Autowired
	private List<Education> educations;
	// 员工合同信息
	@Autowired
	private List<Labor> labors;
	// 员工工作历史
	@Autowired
	private List<Jobhistory> jobhistories;
	// 临时变量：经理姓名
	private String mgrname;

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno == null ? null : empno.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename == null ? null : ename.trim();
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender == null ? null : gender.trim();
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public String getMgr() {
		return mgr;
	}

	public void setMgr(String mgr) {
		this.mgr = mgr == null ? null : mgr.trim();
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage == null ? null : marriage.trim();
	}

	public String getNativeaddr() {
		return nativeaddr;
	}

	public void setNativeaddr(String nativeaddr) {
		this.nativeaddr = nativeaddr == null ? null : nativeaddr.trim();
	}

	public String getPeoples() {
		return peoples;
	}

	public void setPeoples(String peoples) {
		this.peoples = peoples == null ? null : peoples.trim();
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard == null ? null : idcard.trim();
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus == null ? null : estatus.trim();
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood == null ? null : blood.trim();
	}

	public String getPolitical() {
		return political;
	}

	public void setPolitical(String political) {
		this.political = political == null ? null : political.trim();
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close == null ? null : close.trim();
	}

	public String getCphone() {
		return cphone;
	}

	public void setCphone(String cphone) {
		this.cphone = cphone == null ? null : cphone.trim();
	}

	public List<Education> getEducations() {
		return educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public List<Labor> getLabors() {
		return labors;
	}

	public void setLabors(List<Labor> labors) {
		this.labors = labors;
	}

	public List<Jobhistory> getJobhistories() {
		return jobhistories;
	}

	public void setJobhistories(List<Jobhistory> jobhistories) {
		this.jobhistories = jobhistories;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", password=" + password + ", ename=" + ename + ", gender=" + gender
				+ ", birthday=" + birthday + ", age=" + age + ", phone=" + phone + ", address=" + address
				+ ", hiredate=" + hiredate + ", mgr=" + mgr + ", marriage=" + marriage + ", nativeaddr=" + nativeaddr
				+ ", peoples=" + peoples + ", idcard=" + idcard + ", estatus=" + estatus + ", blood=" + blood
				+ ", political=" + political + ", close=" + close + ", cphone=" + cphone + ", department=" + department
				+ ", job=" + job + ", card=" + card + ", educations=" + educations + ", labors=" + labors
				+ ", jobhistories=" + jobhistories + "]";
	}

	public String getMgrname() {
		return mgrname;
	}

	public void setMgrname(String mgrname) {
		this.mgrname = mgrname;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

}