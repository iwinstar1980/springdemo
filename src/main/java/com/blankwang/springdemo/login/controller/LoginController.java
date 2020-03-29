package com.blankwang.springdemo.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    //ログイン画面のGET用コントローラ
    @GetMapping("/login")
    public String getLogin(Model model){

        //login.htmlに画面遷移
        return "login/login";
    }

    //ログイン画面のPOST用コントローラ
    @PostMapping("/login")
    public String postLogin(Model model){

        // ホーム画面に遷移（GETメソッド）
        return "redirect:/home";
    }
}
