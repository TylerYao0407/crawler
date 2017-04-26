package com.tyler.module;

import com.tyler.model.DownloadResult;

/**
 * Created by tyler on 2017/4/20.
 */
public interface DownloadPage {
    /**
     * 通过给定的url下载页面（使用默认编码下载）
     * @param url：要下载页面的url
     * @return 这个页面
     */
    DownloadResult downloadPage(String url);
}
