package com.example.chapter1.bean;

public class MybatisBean {
    private Long id;
    private String userName;
    private String password;
    private UserSexEnum user_sex;
    private String nick_name;

    public MybatisBean() {
       super();
    }

    public MybatisBean(String userName, String password, UserSexEnum user_sex, String nick_name) {
        this.userName = userName;
        this.password = password;
        this.user_sex = user_sex;
        this.nick_name = nick_name;
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

    public UserSexEnum getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(UserSexEnum user_sex) {
        this.user_sex = user_sex;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }
}