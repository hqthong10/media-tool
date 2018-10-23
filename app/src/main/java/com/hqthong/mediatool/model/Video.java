package com.hqthong.mediatool.model;


import java.io.Serializable;


public class Video implements Serializable {

    private String title;
    private String descript;
    private String src;
    private long duration;

    public Video() {
    }

    public Video(String title, String descript, String src, long duration) {
        this.title = title;
        this.descript = descript;
        this.src = src;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}