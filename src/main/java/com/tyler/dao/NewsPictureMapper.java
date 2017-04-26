package com.tyler.dao;

import com.tyler.model.NewsPicture;

public interface NewsPictureMapper {
    int deleteByPrimaryKey(Integer autoId);

    int insert(NewsPicture record);

    int insertSelective(NewsPicture record);

    NewsPicture selectByPrimaryKey(Integer autoId);

    int updateByPrimaryKeySelective(NewsPicture record);

    int updateByPrimaryKey(NewsPicture record);
}