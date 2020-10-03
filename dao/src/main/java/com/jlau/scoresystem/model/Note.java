package com.jlau.scoresystem.model;

import java.io.Serializable;

/**
 * Created by cxr1205628673 on 2020/8/3.
 */
public class Note implements Serializable{
    private int id;
    private String content;
    private String createTime;
    private String person;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}
