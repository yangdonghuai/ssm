package com.xtkj.pojo;

public class UserInfo {
    private Integer id;

    private String userId;

    private String userPwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public UserInfo(Integer id, String userId, String userPwd) {
        this.id = id;
        this.userId = userId;
        this.userPwd = userPwd;
    }
}