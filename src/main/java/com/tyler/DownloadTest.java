package com.tyler;

import com.tyler.model.DownloadResult;
import com.tyler.model.ListUrl;
import com.tyler.module.AnalyzePage;
import com.tyler.module.AnalyzePageImpl;
import com.tyler.module.DownloadPage;
import com.tyler.module.DownloadPageImpl;

import java.util.List;

/**
 * Created by tyler on 2017/4/24.
 */
public class DownloadTest {
    public static void main(String[] args) {
        DownloadPage downloadPage = new DownloadPageImpl();
        DownloadResult downloadResult = downloadPage.downloadPage("http://sports.sina.com.cn/g/premierleague/");
        AnalyzePage analyzePage = new AnalyzePageImpl();
        List<ListUrl> list = analyzePage.getListUrl(downloadResult.getPage());
        int count = 0;
        for(ListUrl listUrl : list){
            System.out.println(listUrl.getListUrl()+"  "+listUrl.getSitename());
            count++;
        }
        System.out.println(count);
    }
}