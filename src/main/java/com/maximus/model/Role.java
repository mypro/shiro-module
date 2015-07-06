package com.maximus.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Role implements Serializable {
    private static final long serialVersionUID = -8122668953176612616L;

    private int id;
    private String name;
    private String description;
    private List<Permission> permission;
    private Date updateTime;
    private Date createdTime;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Permission> getPermission() {
        return permission;
    }

    public void setPermission(List<Permission> permission) {
        this.permission = permission;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
