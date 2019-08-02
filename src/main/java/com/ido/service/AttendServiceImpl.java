package com.ido.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ido.bean.Attend;
import com.ido.mapper.AttendMapper;
import com.ido.mapper.AttsetMapper;
import com.ido.mapper.EmployeeMapper;

@Service
public class AttendServiceImpl implements AttendServiceI {

	// mapper注入
	@Autowired
	private AttendMapper attendMapper;
	@Autowired
	private AttsetMapper attsetMapper;
	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public boolean addAttend(Attend attend) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Attend> findAllAttend(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName, Date start, Date end, String batch) {
		List<Attend> attends = null;
		// 分页
		PageHelper.startPage(pageIndex == null ? 1 : pageIndex, pageSize == null ? 10 : pageSize);
		// 排序
		if (order != null && orderName != null)
			PageHelper.orderBy(orderName + " " + order);
		// start与end为0时表示显示全部打卡记录
		if (start.getTime() == 0) {
			attends = attendMapper.selectAll();
		} else {
			// 显示某时间段记录
			if (batch.equals("all")) {
				attends = attendMapper.selectAttendByDate(start, end);
			} else {
				// 显示某批次记录
				attends = attendMapper.selectAttendByDateAndBatch(start, end, batch);
			}
		}
		if (attends == null) {
			return null;
		}
		// 填充员工信息与打卡批次信息
		for (Attend attend : attends) {
			attend.setEmployee(employeeMapper.selectByPrimaryKey(attend.getEmployee().getEmpno()));
			attend.setAttset(attsetMapper.selectByPrimaryKey(attend.getAttset().getSetno()));
		}
		return attends;
	}

	@Override
	public List<Attend> findCurrDayAttend(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName, String batch) {
		// 分页
		PageHelper.startPage(pageIndex == null ? 1 : pageIndex, pageSize == null ? 10 : pageSize);
		// 排序
		if (order != null && orderName != null)
			PageHelper.orderBy(orderName + " " + order);
		List<Attend> attends = null;
		if (batch.equals("all")) {
			attends = attendMapper.selectCurrDay();
		} else {
			attends = attendMapper.selectCurrDayByBatch(batch);
		}
		if (attends == null) {
			return null;
		}
		// 填充员工信息与打卡批次信息
		for (Attend attend : attends) {
			System.out.println(attend.getEmployee().getEmpno());
			attend.setEmployee(employeeMapper.selectByPrimaryKey(attend.getEmployee().getEmpno()));
			attend.setAttset(attsetMapper.selectByPrimaryKey(attend.getAttset().getSetno()));
		}
		return attends;
	}
}
