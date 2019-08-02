package com.ido.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ido.bean.Incometax;
import com.ido.mapper.IncometaxMapper;

@Service
public class IncometaxServiceImpl implements IncometaxServiceI {

	@Autowired
	private IncometaxMapper incometaxMapper;

	@Override
	public boolean addIncometax(Incometax incometax) {
		return incometaxMapper.insertSelective(incometax) == 1;
	}

	@Override
	public boolean modifyIncometax(Incometax incometax) {
		return incometaxMapper.updateByPrimaryKeySelective(incometax) == 1;
	}

	@Override
	public List<Incometax> findAllIncometax() {
		return incometaxMapper.selectAll();
	}

}
