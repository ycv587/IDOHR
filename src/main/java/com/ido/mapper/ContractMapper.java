package com.ido.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ido.bean.Contract;

@Repository
public interface ContractMapper {
	int deleteByPrimaryKey(String conno);

	int insert(Contract record);

	int insertSelective(Contract record);

	Contract selectByPrimaryKey(String conno);

	int updateByPrimaryKeySelective(Contract record);

	int updateByPrimaryKey(Contract record);

	/** 查询所有合同编号和名称 */
	List<Contract> selectAllContractNameAndNo();
}