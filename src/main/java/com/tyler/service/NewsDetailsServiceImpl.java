package com.tyler.service;

import com.tyler.dao.ListUrlMapper;
import com.tyler.dao.NewsDetailsMapper;
import com.tyler.model.NewsDetails;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tyler on 2017/4/25.
 */
public class NewsDetailsServiceImpl implements NewsDetailsService {

    public int insert(NewsDetails record) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        NewsDetailsMapper newsDetailsMapper = (NewsDetailsMapper) ac.getBean("newsDetailsMapper");
        return newsDetailsMapper.insert(record);
    }
}
