package com.ido.service;

import java.util.List;

import com.ido.bean.Contract;

public interface ContractServiceI {

	/** 新增合同 */
	public String addContract(Contract contract);

	/** 合同名去重 */
	public boolean isRepeat(Contract contract);

	/** 根据合同号查询合同名称 */
	public Contract findByConno(String conno);

	/** 查询所有合同编号和名称 */
	public List<Contract> findAllContractNameAndNo();
}
