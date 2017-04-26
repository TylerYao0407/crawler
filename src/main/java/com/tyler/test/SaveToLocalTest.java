package com.tyler.test;

import com.tyler.model.DownloadResult;
import com.tyler.module.DownloadPage;
import com.tyler.module.DownloadPageImpl;
import com.tyler.module.SaveToLocal;
import com.tyler.module.SaveToLocalImpl;
import org.junit.Test;

/**
 * Created by tyler on 2017/4/26.
 */
public class SaveToLocalTest {
    @Test
    public void save(){
        DownloadPage downloadPage = new DownloadPageImpl();
        SaveToLocal saveToLocal = new SaveToLocalImpl();
        DownloadResult downloadResult = downloadPage.downloadPage("https://zhidao.baidu.com/question/125343134.html");
        String path = saveToLocal.saveToLocal(downloadResult);
        System.out.println(path);
    }
}
