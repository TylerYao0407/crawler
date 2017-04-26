package com.tyler.module;

import com.tyler.model.DownloadResult;

/**
 * Created by tyler on 2017/4/20.
 */
public interface SaveToLocal {
    /**
     * 将页面保存到本地
     * @param downloadResult 当前页面
     * @return 保存地址
     * 保存到本地的格式应该为：/年/月/日/url的MD5值.文件后缀
     * 例如：/2017/04/20/84675a6817fc8715e33bc1c631154b5d.html
     */
    String saveToLocal(DownloadResult downloadResult);
}
