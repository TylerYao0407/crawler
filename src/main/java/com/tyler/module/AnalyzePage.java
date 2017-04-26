package com.tyler.module;

import com.tyler.model.DownloadResult;
import com.tyler.model.ListUrl;
import com.tyler.model.NewsDetails;
import com.tyler.model.NewsUrl;
import org.htmlcleaner.XPatherException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Created by tyler on 2017/4/20.
 */
public interface AnalyzePage {
    /**
     * 通过正则表达式解析并获取当前页面的所有列表URL
     * @param page 当前页面源代码
     * @return 当前页面的所有列表URL及其他信息
     * 以备入队列使用
     */
    List<ListUrl> getListUrl(String page);

    /**
     * 通过正则表达式解析并获取当前页面的所有列表URL
     * @param page 当前页面源代码
     * @return 当前页面的所有新闻URL及其他信息
     * 以备入队列使用
     */
    List<NewsUrl> getNewsUrl(String page);

    /**
     * 解析并提取当前页面中所有详细信息
     * @param downloadResult 当前页面对象
     * @return 页面中所有详细信息
     */
    NewsDetails getPageDetails(DownloadResult downloadResult) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException, XPatherException;
}
