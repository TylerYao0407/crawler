package com.tyler.module;

import com.tyler.model.*;
import com.tyler.module.AnalyzePage;
import com.tyler.util.UrlMd5;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by tyler on 2017/4/24.
 */
@Service
public class AnalyzePageImpl implements AnalyzePage{
    public List<ListUrl> getListUrl(String page) {
        List<ListUrl> listUrls = new ArrayList<ListUrl>();
        String list = "a[href~=^http(s?).*(163|qq|sina).*\\/$]";
        Elements links = Jsoup.parse(page).select(list);
        for (Element link : links) {
            String linkHref = link.attr("href");
            String linkText = link.text();
            if(!linkHref.equals("")){
                ListUrl listUrl = new ListUrl();
                listUrl.setListUrl(linkHref);
                listUrl.setSitename(linkText);
                listUrl.setListMd5(UrlMd5.md5(linkHref));
                listUrl.setInsertTime(new Date(System.currentTimeMillis()));
                listUrl.setUpdateTime(new Date(System.currentTimeMillis()));
                listUrl.setStatus((byte)1);
                listUrls.add(listUrl);
            }

        }
        return listUrls;
    }

    public List<NewsUrl> getNewsUrl(String page) {
        List<NewsUrl> newsUrls = new ArrayList<NewsUrl>();
        String news = "a[href~=^http(s?):\\/\\/.*(163|qq|sina).*(.html)$]";
        Elements links = Jsoup.parse(page).select(news);
        for (Element link : links) {
            String linkHref = link.attr("href");
            if(!linkHref.equals("")){
                NewsUrl newsUrl = new NewsUrl();
                newsUrl.setNewsUrl(linkHref);
                newsUrl.setNewsMd5(UrlMd5.md5(linkHref));
                newsUrl.setInsertTime(new Date(System.currentTimeMillis()));
                newsUrl.setStatus((byte)1);
                newsUrls.add(newsUrl);
            }
        }
        return newsUrls;
    }

    public NewsDetails getPageDetails(DownloadResult downloadResult) throws IOException, XPatherException {
        NewsDetails nd = new NewsDetails();
        HtmlCleaner cleaner = new  HtmlCleaner();
        TagNode node = cleaner.clean(downloadResult.getPage());
        Object[] title = node.evaluateXPath("//div[@class='page-header']/h1[@id='artibodyTitle']/text()" );
        Object[] content = node.evaluateXPath("//div[@id='articleContent']//div[@id='artibody']/p[position()<last()]/text()");
        Object[] editor = node.evaluateXPath("//p[@class='article-editor']/text()");
        Object[] media = node.evaluateXPath("//DIV[@class='page-info']/span[@id='navtimeSource']//span/text()");
        Object[] pub_time = node.evaluateXPath("//DIV[@class='page-info']/span[@id='navtimeSource']/text()");
        Object[] picture = node.evaluateXPath("//DIV[@id='artibody']//DIV[@class='img_wrapper']/img/@src");
        StringBuilder contents = new StringBuilder("");
        List<NewsPicture> list = new ArrayList<NewsPicture>();
        nd.setTitle(title[0].toString().trim());
        for(Object o : content){
            contents.append(o.toString().trim());
        }
        nd.setContent(contents.toString());
        nd.setEditor(editor[0].toString().trim());
        nd.setMediaName(media[0].toString().trim());
        nd.setPubTime(timeFormat(pub_time[0].toString()));
        for(Object pic : picture){
            NewsPicture newsPicture = new NewsPicture();
            newsPicture.setPicture(pic.toString());
            newsPicture.setNewsUrlMd5(nd.getNewsMd5());
            list.add(newsPicture);
        }
        nd.setNewsPictures(list);
        nd.setNewsUrl(downloadResult.getUrl());
        nd.setNewsMd5(UrlMd5.md5(downloadResult.getUrl()));
        nd.setInitime(new Date(System.currentTimeMillis()));
        //得到本地路径
        Calendar calendar = Calendar.getInstance();
        String suffix = downloadResult.getUrl().substring(downloadResult.getUrl().lastIndexOf("."));
        String path = "/"+calendar.get(Calendar.YEAR)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.DAY_OF_MONTH)+"/"+ UrlMd5.md5(downloadResult.getUrl())+suffix;
        nd.setPath(path);
        return nd;
    }
    private static Timestamp timeFormat(String time){
        String year = time.substring(0,4);
        String month = time.substring(5,7);
        String day = time.substring(8,10);
        String other = time.substring(11,16);
        String nowTime = year+"-"+month+"-"+day+" "+other+":00";
        return Timestamp.valueOf(nowTime);
    }
}
