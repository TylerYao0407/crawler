package com.tyler.dao;

import com.tyler.model.NewsDetails;

public interface NewsDetailsMapper {
    int deleteByPrimaryKey(Integer autoId);

    int insert(NewsDetails record);

    int insertSelective(NewsDetails record);

    NewsDetails selectByPrimaryKey(Integer autoId);

    int updateByPrimaryKeySelective(NewsDetails record);

    int updateByPrimaryKeyWithBLOBs(NewsDetails record);

    int updateByPrimaryKey(NewsDetails record);
}