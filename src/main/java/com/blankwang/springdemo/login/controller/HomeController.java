package com.blankwang.springdemo.login.controller;

import com.blankwang.springdemo.login.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @GetMapping("/home")
    public String getHome(Model model) {

        // コンテンツ部分にホーム画面を表示するための文字列を登録
        model.addAttribute("contents", "login/home::home_contents");

        return "login/homeLayout";
    }

    @PostMapping("/logout")
    public String postLogout(){

        // ログイン画面にリダイレクト
        return "redirect:/login";
    }
}
