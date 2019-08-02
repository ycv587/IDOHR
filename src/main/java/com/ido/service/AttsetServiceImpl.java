package com.ido.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ido.bean.Attset;
import com.ido.mapper.AttsetMapper;

@Service
public class AttsetServiceImpl implements AttsetServiceI {

	// Mapper注入
	@Autowired
	private AttsetMapper attsetMapper;

	@Override
	public boolean addAttset(Attset attset) {
		attsetMapper.insertSelective(attset);
		return true;
	}

	@Override
	public boolean delAttset(String setno) {
		attsetMapper.deleteByPrimaryKey(setno);
		return true;
	}

	@Override
	public boolean onAttset(String setno) {
		Attset attset = new Attset();
		attset.setSetno(setno);
		attset.setAttflag(1);
		attsetMapper.updateByPrimaryKeySelective(attset);
		return true;
	}

	@Override
	public boolean offAttset(String setno) {
		Attset attset = new Attset();
		attset.setSetno(setno);
		attset.setAttflag(0);
		attsetMapper.updateByPrimaryKeySelective(attset);
		return true;
	}

	@Override
	public boolean modifyAttset(Attset attset) {
		attsetMapper.updateByPrimaryKeySelective(attset);
		return true;
	}

	@Override
	public List<Attset> findAllAttset(Integer pageIndex, Integer pageSize, String search, String order,
			String orderName) {
		// 分页
		PageHelper.startPage(pageIndex == null ? 1 : pageIndex, pageSize == null ? 10 : pageSize);
		// 排序
		if (order != null && orderName != null)
			PageHelper.orderBy(orderName + " " + order);
		return attsetMapper.selectAll();
	}

	@Override
	public List<Attset> findOnAttset() {
		return attsetMapper.selectOn();
	}

	@Override
	public List<Attset> findOffAttset() {
		return attsetMapper.selectOff();
	}

	@Override
	public Attset findAttsetBySetno(String setno) {
		return attsetMapper.selectByPrimaryKey(setno);
	}

}
