package com.maximus.model;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Account implements Serializable {
    private static final long serialVersionUID = -2277935926758771552L;

    private int id;
    private String loginName;
    private String userId;
    private String nickName;
    private List<Role> roles;
    private Boolean allowInternet;
    private Date updateTime;
    private Date createdTime;



    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }



    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Boolean getAllowInternet() {
        return allowInternet;
    }

    public void setAllowInternet(Boolean allowInternet) {
        this.allowInternet = allowInternet;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Boolean isAllowInternet() {
        return allowInternet;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
