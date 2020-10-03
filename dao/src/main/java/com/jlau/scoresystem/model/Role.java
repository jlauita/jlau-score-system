package com.jlau.scoresystem.model;

import java.io.Serializable;

/**
 * Created by cxr1205628673 on 2020/8/2.
 */
public class Role implements Serializable{
    private int id;
    private String name;
    private String zhName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZhName() {
        return zhName;
    }

    public void setZhName(String zhName) {
        this.zhName = zhName;
    }
}
