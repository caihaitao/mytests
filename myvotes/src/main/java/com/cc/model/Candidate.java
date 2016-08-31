package com.cc.model;

import java.util.Date;

/**
 * Created by Administrator on 2016/8/15.
 */
public class Candidate {
    private Integer id;
    private String name;
    private Integer votes;
    private String imagePath;
    private Integer version;
    private Date createDate;
    private Date lastUpdate;
    private String lastUpdator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getLastUpdator() {
        return lastUpdator;
    }

    public void setLastUpdator(String lastUpdator) {
        this.lastUpdator = lastUpdator;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", votes=" + votes +
                ", imagePath='" + imagePath + '\'' +
                ", version=" + version +
                ", createDate=" + createDate +
                ", lastUpdate=" + lastUpdate +
                ", lastUpdator='" + lastUpdator + '\'' +
                '}';
    }
}
