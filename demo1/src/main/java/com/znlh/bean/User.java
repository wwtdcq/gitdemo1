package com.znlh.bean;

import java.util.Date;

public class User {
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        System.out.println("wangwei 1 在开发");


        System.out.println("wang wei 2 在开发");
    }
}
