package com.tyler.model;

import java.util.List;

public class NewsPicture {
    private Integer autoId;

    private String newsUrlMd5;

    private String picture;

    private NewsDetails newsDetails;

    public Integer getAutoId() {
        return autoId;
    }

    public void setAutoId(Integer autoId) {
        this.autoId = autoId;
    }

    public String getNewsUrlMd5() {
        return newsUrlMd5;
    }

    public void setNewsUrlMd5(String newsUrlMd5) {
        this.newsUrlMd5 = newsUrlMd5;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public NewsDetails getNewsDetails() {
        return newsDetails;
    }

    public void setNewsDetails(NewsDetails newsDetails) {
        this.newsDetails = newsDetails;
    }
}