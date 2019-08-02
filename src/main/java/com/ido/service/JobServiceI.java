package com.ido.service;

import java.util.List;

import com.ido.bean.Job;

public interface JobServiceI {

	/** 新增职位 */
	public boolean addJob(Job job);

	/** 职位合并 */
	public boolean mergeJob(String oldJobid, String newJobid);

	/** 修改职位信息 */
	public boolean modifyJob(Job job);

	/** 查找所有职位信息 */
	public List<Job> findJobs(Integer pageIndex, Integer pageSize, String search, String order, String orderName);

	/** 根据职位编号查找职位信息 */
	public Job findJobByJobid(String jobid);

	/** 查询所有职位编号和名称 */
	public List<Job> findAllJobNameAndNo();
}
