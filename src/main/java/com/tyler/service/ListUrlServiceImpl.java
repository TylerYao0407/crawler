package com.tyler.service;

import com.tyler.dao.ListUrlMapper;
import com.tyler.model.ListUrl;
import com.tyler.module.AnalyzePageImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tyler on 2017/4/25.
 */
@Service
public class ListUrlServiceImpl implements ListUrlService {
    /**
     * 将解析后得到的url添加到数据库中
     * @param list
     * @return
     */
    public int insertListUrl(List<ListUrl> list) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ListUrlMapper listUrlMapper = (ListUrlMapper)ac.getBean("listUrlMapper");
        return listUrlMapper.insert(list);
    }

    public ListUrl selectByPrimaryKey(Integer autoId) {
        return null;
    }

    public int updateByPrimaryKeySelective(ListUrl record) {
        return 0;
    }
}
