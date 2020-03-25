package com.blankwang.springdemo.login.domain.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class SignupForm {

//    必須入力、メールアドレス形式
    @NotBlank(message = "{require_check}", groups = ValidGroup1.class)
    @Email(message = "{email_check}", groups = ValidGroup2.class)
    private String userId;

    //必須入力、長さ４から１００桁まで、半角英数字のみ
    @NotBlank(message = "{require_check}", groups = ValidGroup1.class)
    @Length(min = 4, max = 100, message = "{length_check}", groups = ValidGroup2.class)
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "{pattern_check}", groups = ValidGroup3.class)
    private String password;

    //必須入力
    @NotBlank(message = "{require_check}", groups = ValidGroup1.class)
    private String userName;

    /**
     * @DateTimeFormat アノテーション
     * 画面から渡されてきた文字列を日付型に変換
     * pattern属性にどのようなフォーマットでデータが渡されてくるかを指定
     */
    @NotNull(message = "{require_check}", groups = ValidGroup1.class)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date birthday;

    //値が２０から１００まで
    @Min(value = 20, message = "{min_check}", groups = ValidGroup2.class)
    @Max(value = 100, message = "{max_check}", groups = ValidGroup2.class)
    private int age;

    //falseのみ可能
    @AssertFalse(message = "{false_check}", groups = ValidGroup2.class)
    private boolean marriage;
}
