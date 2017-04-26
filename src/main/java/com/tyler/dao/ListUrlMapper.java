package com.tyler.dao;

import com.tyler.model.ListUrl;
import com.tyler.model.NewsUrl;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public interface ListUrlMapper {
    int deleteByPrimaryKey(Integer autoId);

    int insert(List<ListUrl> list);

    int insertSelective(ListUrl record);

    ListUrl selectByPrimaryKey(Integer autoId);

    int updateByPrimaryKeySelective(ListUrl record);

    int updateByPrimaryKey(ListUrl record);
}