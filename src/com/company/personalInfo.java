package com.company;

public class personalInfo {


    private String userName;
    private String mobile;
    private String email;
    private String password;
    public personalInfo(String userName, String password, String mobile) {
        this.userName = userName;
        this.mobile = mobile;
        this.password = password;
    }
    public personalInfo(String userName, String password, String mobile, String email) {
        this(userName, password, mobile);
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getUserName() {
        return this.userName;
    }
    public String getPassword() {
        return this.password;
    }
    public String getEmail() {
        return this.email;
    }
    String getMobile() {
        return this.mobile;
    }
}