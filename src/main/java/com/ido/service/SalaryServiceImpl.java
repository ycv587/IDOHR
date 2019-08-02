package com.ido.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ido.bean.Employee;
import com.ido.bean.Joblevel;
import com.ido.bean.Jobover;
import com.ido.bean.Salary;
import com.ido.bean.Salset;
import com.ido.mapper.EmployeeMapper;
import com.ido.mapper.JoblevelMapper;
import com.ido.mapper.JoboverMapper;
import com.ido.mapper.SalaryMapper;
import com.ido.mapper.SalsetMapper;

@Service
public class SalaryServiceImpl implements SalaryServiceI {

	@Autowired
	private SalaryMapper salaryMapper;
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private SalsetMapper salsetMapper;
	@Autowired
	private JoboverMapper joboverMapper;
	@Autowired
	private JoblevelMapper joblevelMapper;

	@Override
	public boolean addSalary(Salary salary) {
		return salaryMapper.insertSelective(salary) == 1;
	}

	@Override
	public List<Salary> findAllSalary(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName) {
		List<Salary> salaries = salaryMapper.selectAll();
		for (Salary salary : salaries) {
			salary.setEmployee(employeeMapper.selectByPrimaryKey(salary.getEmployee().getEmpno()));
		}
		return salaries;
	}

	@Override
	public List<Salary> findByDate(Integer pageIndex, Integer pageSize, String search, String order, String orderName,
			Date month) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(month);
		int y = calendar.get(Calendar.YEAR);
		int m = calendar.get(Calendar.MONTH) + 1;
		System.out.println(y + "-" + (m < 10 ? "0" + m : m) + "-01");
		System.out.println(y + "-" + (m < 10 ? "0" + m : m) + (m == 2 ? "-28" : "-30"));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startday = null;
		Date endday = null;
		try {
			startday = simpleDateFormat.parse(y + "-" + (m < 10 ? "0" + m : m) + "-01 00:00:00");
			endday = simpleDateFormat.parse(y + "-" + (m < 10 ? "0" + m : m) + (m == 2 ? "-28" : "-30") + " 00:00:00");
		} catch (ParseException e) {
			return findAllSalary(pageIndex, pageSize, search, order, orderName);
		}
		List<Salary> salaries = salaryMapper.selectByDate(startday, endday);
		for (Salary salary : salaries) {
			salary.setEmployee(employeeMapper.selectByPrimaryKey(salary.getEmployee().getEmpno()));
		}
		return salaries;
	}

	@Override
	public int settleSalary() {
		// 薪资已结算，-1
		List<Salary> salaries = findByDate(0, 0, "", "", "", new Date());
		if (salaries != null && salaries.size() != 0) {
			return -1;
		}
		Salset salset = salsetMapper.selectAll().get(0);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		if (salset.getCleardate().equals(calendar.get(Calendar.DAY_OF_MONTH))) {
			for (Employee employee : employeeMapper.selectAll()) {
				Salary salary = new Salary();
				salary.setEmployee(employee);
				// 基本工资
				BigDecimal baseSal = employee.getSalary();
				salary.setBasesal(baseSal.setScale(2, BigDecimal.ROUND_HALF_UP));
				// 加班工时
				List<Jobover> jobovers = joboverMapper.selectByEmpno(employee.getEmpno());
				float commonOTime = 0;
				float weekdayOTime = 0;
				float legalOTime = 0;
				float oTime = 0;
				if (jobovers == null || jobovers.size() == 0) {
					oTime = 0;
				} else {
					for (Jobover jobover : jobovers) {
						if (jobover.getRemark().equals("普通")) {
							commonOTime += (jobover.getOverend().getTime() - jobover.getOverstart().getTime())
									/ (24 * 60 * 60 * 1000);
						} else if (jobover.getRemark().equals("周末")) {
							weekdayOTime += (jobover.getOverend().getTime() - jobover.getOverstart().getTime())
									/ (24 * 60 * 60 * 1000);
						} else if (jobover.getRemark().equals("法定")) {
							legalOTime += (jobover.getOverend().getTime() - jobover.getOverstart().getTime())
									/ (24 * 60 * 60 * 1000);
						}
						oTime = commonOTime + weekdayOTime + legalOTime;
					}
				}
				salary.setOvertime(oTime);
				// 加班薪酬
				BigDecimal overtimeSal = new BigDecimal(Float.toString(commonOTime * salset.getNopropo()
						+ weekdayOTime * salset.getWopropo() + legalOTime * salset.getQopropo()));
				salary.setOsal(overtimeSal);
				// 缺勤天数
				salary.setAbsence(Float.parseFloat("0"));
				// 缺勤扣薪
				salary.setAsal(new BigDecimal("0").setScale(2, BigDecimal.ROUND_HALF_UP));
				// 事假天数
				float absDays = 0;
				List<Joblevel> joblevels = joblevelMapper.selectByEmpno(employee.getEmpno());
				if (joblevels == null || joblevels.size() == 0) {
					absDays = 0;
				} else {
					for (Joblevel joblevel : joblevels) {
						int hour = (int) Math.ceil(
								(joblevel.getLevend().getTime() - joblevel.getLevstart().getTime()) / (60 * 60 * 1000));
						absDays += hour / 24 + hour % 24 <= 12 ? 0.5 : 1;
					}
				}
				salary.setLve(absDays);
				// 事假扣薪
				BigDecimal absSal = baseSal.divide(new BigDecimal("30.0"), 3, BigDecimal.ROUND_HALF_DOWN)
						.multiply(new BigDecimal(Float.toString(absDays)));
				salary.setLsal(absSal.setScale(2, BigDecimal.ROUND_HALF_UP));
				// 病假天数
				salary.setSick(Float.parseFloat("0"));
				// 病假扣薪
				salary.setSsal(new BigDecimal(Float.parseFloat("0")).setScale(2, BigDecimal.ROUND_HALF_UP));
				// 个人五险一金
				BigDecimal ownfund = new BigDecimal("0");
				float og = salset.getEoldage() / 100;
				ownfund = ownfund.add(baseSal.multiply(new BigDecimal(Float.toString(og))));
				og = salset.getEbirth() / 100;
				ownfund = ownfund.add(baseSal.multiply(new BigDecimal(Float.toString(og))));
				og = salset.getEinjury() / 100;
				ownfund = ownfund.add(baseSal.multiply(new BigDecimal(Float.toString(og))));
				og = salset.getEmedical() / 100;
				ownfund = ownfund.add(baseSal.multiply(new BigDecimal(Float.toString(og))));
				og = salset.getEunemp() / 100;
				ownfund = ownfund.add(baseSal.multiply(new BigDecimal(Float.toString(og))));
				og = salset.getEaccum() / 100;
				ownfund = ownfund.add(baseSal.multiply(new BigDecimal(Float.toString(og))));
				salary.setOwnfund(ownfund.setScale(2, BigDecimal.ROUND_HALF_UP));
				// 个人所得税
				BigDecimal tax = baseSal.subtract(ownfund).subtract(new BigDecimal("3500"));
				if (tax.compareTo(new BigDecimal("0")) != -1 && tax.compareTo(new BigDecimal("1500")) != 1) {
					tax = tax.multiply(new BigDecimal("0.03"));
				} else if (tax.compareTo(new BigDecimal("1500")) == 1 && tax.compareTo(new BigDecimal("4500")) != 1) {
					tax = tax.multiply(new BigDecimal("0.1")).subtract(new BigDecimal("105"));
				} else if (tax.compareTo(new BigDecimal("4500")) == 1 && tax.compareTo(new BigDecimal("9000")) != 1) {
					tax = tax.multiply(new BigDecimal("0.2")).subtract(new BigDecimal("555"));
				} else if (tax.compareTo(new BigDecimal("9000")) == 1 && tax.compareTo(new BigDecimal("35000")) != 1) {
					tax = tax.multiply(new BigDecimal("0.25")).subtract(new BigDecimal("1005"));
				} else if (tax.compareTo(new BigDecimal("35000")) == 1 && tax.compareTo(new BigDecimal("55000")) != 1) {
					tax = tax.multiply(new BigDecimal("0.3")).subtract(new BigDecimal("2755"));
				} else if (tax.compareTo(new BigDecimal("55000")) == 1 && tax.compareTo(new BigDecimal("9000")) != 1) {
					tax = tax.multiply(new BigDecimal("0.35")).subtract(new BigDecimal("5505"));
				} else if (tax.compareTo(new BigDecimal("80000")) == 1) {
					tax = tax.multiply(new BigDecimal("0.45")).subtract(new BigDecimal("13505"));
				} else {
					tax = new BigDecimal("0");
				}
				salary.setTax(tax.setScale(2, BigDecimal.ROUND_HALF_UP));
				// 实发工资
				BigDecimal realsal = baseSal.subtract(salary.getAsal()).subtract(salary.getLsal())
						.subtract(salary.getSsal()).subtract(salary.getOwnfund()).subtract(salary.getTax())
						.add(salary.getOsal());
				salary.setRealsal(realsal.setScale(2, BigDecimal.ROUND_HALF_UP));
				// 结算日期
				salary.setSetdate(new Date());
				salaryMapper.insertSelective(salary);
			}
			return 1;
		}
		// 不是结算日期，0
		return 0;
	}

}
