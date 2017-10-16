package com.example.saurabh.wikipediatextsearch.models;

import java.io.Serializable;

/**
 * Created by danilolemes on 13/10/2017.
 */

public class WikipediaResultItem implements Serializable {
    private Integer ns;
    private String title;
    private Integer pageid;
    private Integer size;
    private Long wordcount;
    private String snippet;
    private String timestamp;

    public WikipediaResultItem() {
    }

    public WikipediaResultItem(Integer ns, String title, Integer pageid, Integer size, Long wordcount, String snippet, String timestamp) {
        this.ns = ns;
        this.title = title;
        this.pageid = pageid;
        this.size = size;
        this.wordcount = wordcount;
        this.snippet = snippet;
        this.timestamp = timestamp;
    }

    public Integer getNs() {
        return ns;
    }

    public void setNs(Integer ns) {
        this.ns = ns;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPageid() {
        return pageid;
    }

    public void setPageid(Integer pageid) {
        this.pageid = pageid;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getWordcount() {
        return wordcount;
    }

    public void setWordcount(Long wordcount) {
        this.wordcount = wordcount;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
