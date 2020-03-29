package com.blankwang.springdemo.login.controller;

import com.blankwang.springdemo.login.domain.model.GroupOrder;
import com.blankwang.springdemo.login.domain.model.SignupForm;
import com.blankwang.springdemo.login.domain.model.User;
import com.blankwang.springdemo.login.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class SignupController {

    @Autowired
    private UserService userService;

    // ラジオボタン用変数
    private Map<String, String> radioMarriage;

    // ラジオボタン初期化メソッド
    private Map<String, String> initRadioMarrige(){
        Map<String, String> radio = new LinkedHashMap<>();

        radio.put("既婚", "true");
        radio.put("未婚", "false");

        return radio;
    }

    // ユーザー登録画面のGET用コントローラー
    /**
     * @ModelAttribute
     * 引数のformクラスに@ModelAttributeアノテーションを付けると、
     * 自動でModelクラスに登録（addAttribute）してくれる
     * イメージ：mode.addAttribute("signupForm", form);
     */
    @GetMapping("/signup")
    public String getSignUp(@ModelAttribute SignupForm form, Model model){

        //ラジオボタンの初期化
        radioMarriage = initRadioMarrige();

        //ラジオボタン用のMapをModelに登録
        model.addAttribute("radioMarriage", radioMarriage);

        return "login/signup";
    }

    // ユーザー登録画面のPOST用コントローラー
    @PostMapping("/signup")
    //BindingResult データバインド結果の受取
    public String postSignUp(@ModelAttribute @Validated(GroupOrder.class) SignupForm form, BindingResult bindingResult,
                             Model model){
        // 入力チェックに引っかかった場合、ユーザー登録画面に戻る
        if (bindingResult.hasErrors()){

            // GETリクエスト用のメソッドを呼び出して、ユーザー登録画面に戻る
            return getSignUp(form, model);
        }

        //画面から渡された値を確認するため、formの中身をコンソールに出力
        System.out.println(form);

        // insert用変数
        User user = new User();
        user.setUserId(form.getUserId());
        user.setPassword(form.getPassword());
        user.setUserName(form.getUserName());
        user.setBirthday(form.getBirthday());
        user.setAge(form.getAge());
        user.setMarriage(form.isMarriage());
        user.setRole("ROLE_GENERAL"); // ロール権限（一般）

        // ユーザー登録処理
        boolean result = userService.insert(user);

        // ユーザー登録結果の判定
        if (result == true) {
            System.out.println("insert成功");
        } else {
            System.out.println("inser失敗");
        }

        return "redirect:/login";
    }
}
