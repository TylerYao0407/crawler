package com.tyler.service;

import com.tyler.model.ListUrl;
import com.tyler.model.NewsUrl;

import java.util.List;
import java.util.Set;

/**
 * Created by tyler on 2017/4/25.
 */
public interface ListUrlService {
    int insertListUrl(List<ListUrl> list);

    ListUrl selectByPrimaryKey(Integer autoId);

    int updateByPrimaryKeySelective(ListUrl record);

}
