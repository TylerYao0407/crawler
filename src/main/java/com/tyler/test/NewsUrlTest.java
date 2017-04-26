package com.tyler.test;

import com.tyler.model.DownloadResult;
import com.tyler.model.NewsUrl;
import com.tyler.module.AnalyzePage;
import com.tyler.module.AnalyzePageImpl;
import com.tyler.module.DownloadPage;
import com.tyler.module.DownloadPageImpl;
import com.tyler.service.NewsUrlServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * Created by tyler on 2017/4/25.
 */
public class NewsUrlTest {
    @Test
    public void insert(){
        DownloadPage downloadPage = new DownloadPageImpl();
        AnalyzePage analyzePage = new AnalyzePageImpl();
        DownloadResult downloadResult = downloadPage.downloadPage("http://www.sina.com.cn/");
        String page = downloadResult.getPage();
        List<NewsUrl> newsUrls  = analyzePage.getNewsUrl(page);
        System.out.println(new NewsUrlServiceImpl().insertNewsUrl(newsUrls));
    }
}
