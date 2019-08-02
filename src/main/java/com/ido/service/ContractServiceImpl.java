package com.ido.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ido.bean.Contract;
import com.ido.mapper.ContractMapper;

@Service
public class ContractServiceImpl implements ContractServiceI {

	@Autowired
	private ContractMapper contractMapper;

	/**
	 * 查询所有合同编号和名称
	 */
	@Override
	public List<Contract> findAllContractNameAndNo() {
		return contractMapper.selectAllContractNameAndNo();
	}

	@Override
	public String addContract(Contract contract) {
		if (isRepeat(contract)) {
			return "0";
		}
		return contractMapper.insertSelective(contract) == 1 ? contract.getConno() + "---" + contract.getConname()
				: "0";
	}

	@Override
	public boolean isRepeat(Contract contract) {
		for (Contract con : findAllContractNameAndNo()) {
			if (con.getConname().equals(contract.getConname())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Contract findByConno(String conno) {
		return contractMapper.selectByPrimaryKey(conno);
	}

}
