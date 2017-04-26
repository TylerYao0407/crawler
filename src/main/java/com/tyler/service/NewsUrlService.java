package com.tyler.service;

import com.tyler.model.ListUrl;
import com.tyler.model.NewsUrl;

import java.util.List;

/**
 * Created by tyler on 2017/4/25.
 */
public interface NewsUrlService {
    int insertNewsUrl(List<NewsUrl> list);

    ListUrl selectByPrimaryKey(Integer autoId);

    int updateByPrimaryKeySelective(ListUrl record);
}
