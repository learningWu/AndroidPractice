package com.example.dzj.android_practice.model;

public class User {
    public static User user = new User();

    static {
        user.name = "名字";
        user.password = "密码";
    }

    public String name;
    public String password;
}
