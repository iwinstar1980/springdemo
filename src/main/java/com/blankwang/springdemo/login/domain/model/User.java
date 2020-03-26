package com.blankwang.springdemo.login.domain.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private String userId;
    private String password;
    private String userName;
    private Date birthday;
    private int age;
    private boolean marriage;
    private String role; // 権限ロール
}
