package com.tyler.module;

import java.util.Queue;

/** URL管理模块接口
 * Created by tyler on 2017/4/21.
 */
public interface UrlManager {
    /**
     * 去重
     * @param queue 准备去重的队列
     * @return 去重之后的队列
     */
    Queue<String> uniqURL(Queue<String> queue);
}
