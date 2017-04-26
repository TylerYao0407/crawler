package com.tyler.model;

import java.util.Date;

public class Contain {
    private Integer autoId;

    private Integer listId;

    private Integer newsId;

    private Date updateTime;

    public Contain(Integer autoId, Integer listId, Integer newsId, Date updateTime) {
        this.autoId = autoId;
        this.listId = listId;
        this.newsId = newsId;
        this.updateTime = updateTime;
    }

    public Contain() {
        super();
    }

    public Integer getAutoId() {
        return autoId;
    }

    public void setAutoId(Integer autoId) {
        this.autoId = autoId;
    }

    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}