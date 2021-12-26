package com.company;

public class personalInfo {
    protected String Name;
    protected String  email;
    protected String password;
    protected int phone;

    public personalInfo(String Name,String  email,int phone, String password){
        this.Name=Name;
        this.email=email;
        this.phone=phone;
        this.password=password;
    }
    public personalInfo() {}
    public void setName(String name) {
        Name = name;
    }
    public String getName() {
        return Name;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getPhone() {
        return phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
