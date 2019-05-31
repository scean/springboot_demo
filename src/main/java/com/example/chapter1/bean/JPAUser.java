package com.example.chapter1.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class JPAUser {

    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String password;
    private String nickName;
    private String email;
    private String regTime;

    public JPAUser() {
        super();
    }

    public JPAUser(String userName, String password, String nickName, String email, String regTime) {
        this.userName = userName;
        this.password = password;
        this.nickName = nickName;
        this.email = email;
        this.regTime = regTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }
}
