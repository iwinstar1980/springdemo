package com.blankwang.springdemo.login.domain.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SignupForm {

    private String userId;
    private String password;
    private String userName;

    /**
     * @DateTimeFormat アノテーション
     * 画面から渡されてきた文字列を日付型に変換
     * pattern属性にどのようなフォーマットでデータが渡されてくるかを指定
     */
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date birthday;

    private int age;
    private boolean marriage;
}
