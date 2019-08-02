package com.ido.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.ido.bean.Job;
import com.ido.mapper.EmployeeMapper;
import com.ido.mapper.JobMapper;

@Service
public class JobServiceImpl implements JobServiceI {

	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private JobMapper jobMapper;

	/**
	 * 新增职位
	 */
	@Override
	public boolean addJob(Job job) {
		return jobMapper.insertSelective(job) > 0;
	}

	/**
	 * 职位合并
	 */
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean mergeJob(String oldJobid, String newJobid) {
		// 更新原职位员工信息
		// 删除原职位信息
		return employeeMapper.updateByJobid(oldJobid, newJobid) < 0 ? false
				: jobMapper.deleteByPrimaryKey(oldJobid) < 0 ? false : true;
	}

	/**
	 * 修改职位信息
	 */
	@Override
	public boolean modifyJob(Job job) {
		return jobMapper.updateByPrimaryKeySelective(job) > 0;
	}

	/**
	 * 查询所有职位
	 */
	@Override
	public List<Job> findJobs(Integer pageIndex, Integer pageSize, String search, String order, String orderName) {
		// 分页
		PageHelper.startPage(pageIndex == null ? 1 : pageIndex, pageSize == null ? 10 : pageSize);
		// 排序
		if (order != null && orderName != null)
			PageHelper.orderBy(orderName + " " + order);
		return jobMapper.selectAll();
	}

	/**
	 * 根据职位编号查询所有职位
	 */
	@Override
	public Job findJobByJobid(String jobid) {
		return jobMapper.selectByPrimaryKey(jobid);
	}

	@Override
	public List<Job> findAllJobNameAndNo() {
		return jobMapper.selectAllNameAndNo();
	}

}
