package com.tyler.model;

import java.util.Date;

public class ListUrl {
    private Integer autoId;

    private String listUrl;

    private String sitename;

    private String listMd5;

    private Date insertTime;

    private Date updateTime;

    private Byte updateLevel;

    private Byte status;

    public ListUrl(Integer autoId, String listUrl, String sitename, String listMd5, Date insertTime, Date updateTime, Byte updateLevel, Byte status) {
        this.autoId = autoId;
        this.listUrl = listUrl;
        this.sitename = sitename;
        this.listMd5 = listMd5;
        this.insertTime = insertTime;
        this.updateTime = updateTime;
        this.updateLevel = updateLevel;
        this.status = status;
    }

    public ListUrl() {
        super();
    }

    public Integer getAutoId() {
        return autoId;
    }

    public void setAutoId(Integer autoId) {
        this.autoId = autoId;
    }

    public String getListUrl() {
        return listUrl;
    }

    public void setListUrl(String listUrl) {
        this.listUrl = listUrl == null ? null : listUrl.trim();
    }

    public String getSitename() {
        return sitename;
    }

    public void setSitename(String sitename) {
        this.sitename = sitename == null ? null : sitename.trim();
    }

    public String getListMd5() {
        return listMd5;
    }

    public void setListMd5(String listMd5) {
        this.listMd5 = listMd5 == null ? null : listMd5.trim();
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getUpdateLevel() {
        return updateLevel;
    }

    public void setUpdateLevel(Byte updateLevel) {
        this.updateLevel = updateLevel;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}