package com.ido.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ido.bean.Attset;

@Repository
public interface AttsetMapper {
    int deleteByPrimaryKey(String setno);

    int insert(Attset record);

    int insertSelective(Attset record);

    Attset selectByPrimaryKey(String setno);

    int updateByPrimaryKeySelective(Attset record);

    int updateByPrimaryKey(Attset record);
    
    /** 查询所有配置项 */
    List<Attset> selectAll();
    
    /** 查询已启用的配置 */
    List<Attset> selectOn();
    
    /** 查询未启用的配置 */
    List<Attset> selectOff();
}