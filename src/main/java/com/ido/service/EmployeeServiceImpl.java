package com.ido.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.ido.bean.Card;
import com.ido.bean.Education;
import com.ido.bean.Employee;
import com.ido.bean.Jobhistory;
import com.ido.bean.Labor;
import com.ido.mapper.CardMapper;
import com.ido.mapper.EducationMapper;
import com.ido.mapper.EmployeeMapper;
import com.ido.mapper.JobhistoryMapper;
import com.ido.mapper.LaborMapper;

/**
 * @作者：YANGCHEN @日期：2017-12-06
 * @描述：员工业务
 */
@Service
public class EmployeeServiceImpl implements EmployeeServiceI {
	// 注入Mapper
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private CardMapper cardMapper;
	@Autowired
	private EducationMapper educationMapper;
	@Autowired
	private LaborMapper laborMapper;
	@Autowired
	private JobhistoryMapper jobhistoryMapper;

	/**
	 * 增加员工
	 */
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean addEmployee(Employee employee) {
		// 处理员工基本信息
		// 基本信息优先处理，其他信息外键依赖员工号
		employeeMapper.insertSelective(employee);
		// 处理卡号信息
		Card card = employee.getCard();
		if (card != null) {
			cardMapper.insertSelective(card);
		}
		// 处理员工教育信息
		List<Education> educations = employee.getEducations();
		if (educations != null && educations.size() > 0) {
			for (Education education : educations) {
				educationMapper.insertSelective(education);
			}
		}
		// 处理合同信息
		List<Labor> labors = employee.getLabors();
		if (labors != null && labors.size() > 0) {
			for (Labor labor : labors) {
				laborMapper.insertSelective(labor);
			}
		}
		// 处理工作历史信息
		List<Jobhistory> jobhistories = employee.getJobhistories();
		if (jobhistories != null && jobhistories.size() > 0) {
			for (Jobhistory jobhistory : jobhistories) {
				jobhistoryMapper.insertSelective(jobhistory);
			}
		}
		return true;
	}

	/**
	 * 删除员工信息
	 */
	@Override
	public boolean delEmployee(String empno) {
		return employeeMapper.deleteByPrimaryKey(empno) > 0;
	}

	/**
	 * 修改员工信息
	 */
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean modifyEmployee(Employee employee) {
		// 处理员工基本信息
		employeeMapper.updateByPrimaryKeySelective(employee);
		// 处理卡号信息
		Card card = employee.getCard();
		if (card != null) {
			cardMapper.updateByPrimaryKeySelective(card);
		}
		// 处理员工教育信息
		List<Education> educations = employee.getEducations();
		if (educations != null && educations.size() > 0) {
			for (Education education : educations) {
				educationMapper.updateByPrimaryKeySelective(education);
			}
		}
		// 处理合同信息
		List<Labor> labors = employee.getLabors();
		if (labors != null && labors.size() > 0) {
			for (Labor labor : labors) {
				laborMapper.updateByPrimaryKeySelective(labor);
			}
		}
		// 处理工作历史信息
		List<Jobhistory> jobhistories = employee.getJobhistories();
		if (jobhistories != null && jobhistories.size() > 0) {
			for (Jobhistory jobhistory : jobhistories) {
				jobhistoryMapper.updateByPrimaryKeySelective(jobhistory);
			}
		}
		return true;
	}

	/**
	 * 查找员工信息
	 */
	@Override
	public List<Employee> findEmployees(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName) {
		// 分页
		PageHelper.startPage(pageIndex == null ? 1 : pageIndex, pageSize == null ? 10 : pageSize);
		// 排序
		if (order != null && orderName != null)
			PageHelper.orderBy(orderName + " " + order);
		// 查询出员工基本信息
		List<Employee> employees;
		if (search != null && !search.trim().equals("")) {
			employees = employeeMapper.selectEmps(search);
		} else {
			employees = employeeMapper.selectAll();
		}
		for (Employee employee : employees) {
			// 打包工作经历、教育背景、劳务合同
			employee.setJobhistories(jobhistoryMapper.selectJobhisByEmpno(employee.getEmpno()));
			employee.setEducations(educationMapper.selectEdusByEmpno(employee.getEmpno()));
			employee.setLabors(laborMapper.selectLaborsByEmpno(employee.getEmpno()));
			// 添加员工卡号信息
			employee.setCard(cardMapper.selectCardByEmpno(employee.getEmpno()));
			// 添加直接上级姓名
			if (employeeMapper.selectByPrimaryKey(employee.getMgr()) != null) {
				employee.setMgrname(employeeMapper.selectByPrimaryKey(employee.getMgr()).getEname());
			} else {
				employee.setMgrname("无");
			}
		}
		return employees;
	}

	/**
	 * 查询所有员工的编号和姓名
	 */
	@Override
	public List<Employee> findEmployeesNameAndNo() {
		return employeeMapper.selectAllNameAndNo();
	}

	/**
	 * 根据员工编号查询员工信息
	 */
	@Override
	public Employee findEmployeeByEmpno(String empno) {
		return employeeMapper.selectByPrimaryKey(empno);
	}

}
