package com.tyler.dao;

import com.tyler.model.Contain;

public interface ContainMapper {
    int deleteByPrimaryKey(Integer autoId);

    int insert(Contain record);

    int insertSelective(Contain record);

    Contain selectByPrimaryKey(Integer autoId);

    int updateByPrimaryKeySelective(Contain record);

    int updateByPrimaryKey(Contain record);
}