package com.tyler.service;

import com.tyler.dao.ListUrlMapper;
import com.tyler.dao.NewsUrlMapper;
import com.tyler.model.ListUrl;
import com.tyler.model.NewsUrl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by tyler on 2017/4/25.
 */
public class NewsUrlServiceImpl implements NewsUrlService {
    public int insertNewsUrl(List<NewsUrl> list) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        NewsUrlMapper newsUrlMapper = (NewsUrlMapper)ac.getBean("newsUrlMapper");
        return newsUrlMapper.insert(list);
    }

    public ListUrl selectByPrimaryKey(Integer autoId) {
        return null;
    }

    public int updateByPrimaryKeySelective(ListUrl record) {
        return 0;
    }
}
