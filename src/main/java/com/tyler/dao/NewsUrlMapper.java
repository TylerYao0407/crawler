package com.tyler.dao;

import com.tyler.model.NewsUrl;

import java.util.List;

public interface NewsUrlMapper {
    int deleteByPrimaryKey(Integer autoId);

    int insert(List<NewsUrl> list);

    int insertSelective(NewsUrl record);

    NewsUrl selectByPrimaryKey(Integer autoId);

    int updateByPrimaryKeySelective(NewsUrl record);

    int updateByPrimaryKey(NewsUrl record);
}