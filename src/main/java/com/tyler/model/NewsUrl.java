package com.tyler.model;

import java.util.Date;

public class NewsUrl {
    private Integer autoId;

    private String newsUrl;

    private String newsMd5;

    private Date insertTime;

    private Byte status;

    public NewsUrl(Integer autoId, String newsUrl, String newsMd5, Date insertTime, Byte status) {
        this.autoId = autoId;
        this.newsUrl = newsUrl;
        this.newsMd5 = newsMd5;
        this.insertTime = insertTime;
        this.status = status;
    }

    public NewsUrl() {
        super();
    }

    public Integer getAutoId() {
        return autoId;
    }

    public void setAutoId(Integer autoId) {
        this.autoId = autoId;
    }

    public String getNewsUrl() {
        return newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl == null ? null : newsUrl.trim();
    }

    public String getNewsMd5() {
        return newsMd5;
    }

    public void setNewsMd5(String newsMd5) {
        this.newsMd5 = newsMd5 == null ? null : newsMd5.trim();
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}