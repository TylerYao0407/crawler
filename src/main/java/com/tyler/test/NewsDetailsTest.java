package com.tyler.test;

import com.tyler.model.DownloadResult;
import com.tyler.model.NewsDetails;
import com.tyler.model.NewsUrl;
import com.tyler.module.AnalyzePage;
import com.tyler.module.AnalyzePageImpl;
import com.tyler.module.DownloadPage;
import com.tyler.module.DownloadPageImpl;
import com.tyler.service.NewsDetailsServiceImpl;
import com.tyler.service.NewsUrlServiceImpl;
import jdk.internal.util.xml.impl.Input;
import org.htmlcleaner.XPatherException;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.*;
import java.util.List;

/**
 * Created by tyler on 2017/4/25.
 */
public class NewsDetailsTest {
    @Test
    public void insert() throws IOException, ParserConfigurationException, SAXException, XPathExpressionException, XPatherException {
        InputStream is = new FileInputStream(new File("E:\\BData\\crawler\\src\\main\\java\\com\\tyler\\test\\1.html"));

        InputStreamReader isr = new InputStreamReader(is,"utf-8");
        BufferedReader br = new BufferedReader(isr);
        StringBuilder content = new StringBuilder("");
        String line = null;
        while((line = br.readLine())!=null){
            content = content.append(line);
        }
        String page = content.toString();
        DownloadResult downloadResult = new DownloadResult();
        downloadResult.setUrl("1.html");
        downloadResult.setPage(page);
        AnalyzePage analyzePage = new AnalyzePageImpl();
        NewsDetails newsDetails  = analyzePage.getPageDetails(downloadResult);
        System.out.println(new NewsDetailsServiceImpl().insert(newsDetails));
    }
}
