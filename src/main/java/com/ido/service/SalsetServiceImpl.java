package com.ido.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ido.bean.Salset;
import com.ido.mapper.SalsetMapper;

@Service
public class SalsetServiceImpl implements SalsetServiceI {

	@Autowired
	private SalsetMapper salsetMapper;

	@Override
	public boolean addSalset(Salset salset) {
		return salsetMapper.insertSelective(salset) == 1;
	}

	@Override
	public boolean modifySalset(Salset salset) {
		return salsetMapper.updateByPrimaryKeySelective(salset) == 1;
	}

	@Override
	public boolean deleteSalset(String ssetno) {
		return salsetMapper.deleteByPrimaryKey(ssetno) == 1;
	}

	@Override
	public List<Salset> findAllSalset() {
		return salsetMapper.selectAll();
	}

}
