package com.ido.mapper;

import org.springframework.stereotype.Repository;

import com.ido.bean.Card;

@Repository
public interface CardMapper {
    int deleteByPrimaryKey(String carno);

    int insert(Card record);

    int insertSelective(Card record);

    Card selectByPrimaryKey(String carno);

    int updateByPrimaryKeySelective(Card record);

    int updateByPrimaryKey(Card record);
    
    /* 根据员工编号查询卡号信息 */
    Card selectCardByEmpno(String empno);
}