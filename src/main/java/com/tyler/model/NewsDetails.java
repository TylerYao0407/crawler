package com.tyler.model;

import java.util.Date;
import java.util.List;

public class NewsDetails {
    private Integer autoId;

    private String title;

    private String editor;

    private String mediaName;

    private Date initime;

    private String newsUrl;

    private String newsMd5;

    private Date pubTime;

    private String path;

    private String content;

    private List<NewsPicture> newsPictures;

    public Integer getAutoId() {
        return autoId;
    }

    public void setAutoId(Integer autoId) {
        this.autoId = autoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public Date getInitime() {
        return initime;
    }

    public void setInitime(Date initime) {
        this.initime = initime;
    }

    public String getNewsUrl() {
        return newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl;
    }

    public String getNewsMd5() {
        return newsMd5;
    }

    public void setNewsMd5(String newsMd5) {
        this.newsMd5 = newsMd5;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<NewsPicture> getNewsPictures() {
        return newsPictures;
    }

    public void setNewsPictures(List<NewsPicture> newsPictures) {
        this.newsPictures = newsPictures;
    }
}