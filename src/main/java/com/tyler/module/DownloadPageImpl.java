package com.tyler.module;

import com.tyler.model.DownloadResult;
import com.tyler.module.DownloadPage;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  下载实现类
 * Created by tyler on 2017/4/24.
 */
@Service
public class DownloadPageImpl implements DownloadPage {
    public DownloadResult downloadPage(String url) {
        /**
         * 通过utf-8先默认下载页面
         */
        DownloadResult dr = getHtmlByUrl(url,"utf-8");
        dr.setCharset("utf-8");
        Document document = Jsoup.parse(dr.getPage());
        Elements metas = document.getElementsByTag("meta");
        for (Element meta : metas) {
            String content = meta.attr("content");
            String charset = getCharSet(content);
            if(charset!=null&&!charset.equals("")&&!charset.toLowerCase().equals("utf-8")){
                dr = getHtmlByUrl(url,charset);
                dr.setCharset(charset);
            }
            String charset1 = meta.attr("charset");
            if(charset1!=null&&!charset1.equals("")&&!charset1.toLowerCase().equals("utf-8")){
                dr = getHtmlByUrl(url,charset);
                dr.setCharset(charset1);
            }
        }
        return dr;
    }
    private static DownloadResult getHtmlByUrl(String url,String charset){
        DownloadResult dr = new DownloadResult();
        //创建httpClient对象
        HttpClient httpClient = new DefaultHttpClient();
        //以get方式请求该URL
        HttpGet httpget = new HttpGet(url);
        try {
            //得到responce对象
            HttpResponse response = httpClient.execute(httpget);
            //返回码
            int resStatus = response.getStatusLine().getStatusCode();
            dr.setCode(resStatus);
            dr.setDownloadTime(new Timestamp(System.currentTimeMillis()));
            dr.setUrl(url);
            //200正常  其他就不对
            if (resStatus== HttpStatus.SC_OK) {
                //获得相应实体
                HttpEntity entity = response.getEntity();
                if (entity!=null) {
                    //获得html源代码
                    dr.setPage(EntityUtils.toString(entity,charset));
                }
            }
        } catch (Exception e) {
            System.out.println("访问【"+url+"】出现异常!");
            e.printStackTrace();
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return dr;
    }
    private static String getCharSet(String content){
        String regex = ".*charset=([^;]*).*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        if(matcher.find())
            return matcher.group(1);
        else
            return null;
    }
}
