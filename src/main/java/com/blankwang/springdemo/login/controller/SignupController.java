package com.blankwang.springdemo.login.controller;

import com.blankwang.springdemo.login.domain.model.GroupOrder;
import com.blankwang.springdemo.login.domain.model.SignupForm;
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

    private Map<String, String> radioMarriage;

    private Map<String, String> initRadioMarrige(){
        Map<String, String> radio = new LinkedHashMap<>();

        radio.put("既婚", "true");
        radio.put("未婚", "false");

        return radio;
    }

    /**
     * @ModelAttribute
     * 引数のformクラスに@ModelAttributeアノテーションを付けると、
     * 自動でModelクラスに登録（addAttribute）してくれる
     */
    @GetMapping("/signup")
    public String getSignUp(@ModelAttribute SignupForm form, Model model){

        //ラジオボタンの初期化
        radioMarriage = initRadioMarrige();

        //ラジオボタン用のMapをModelに登録
        model.addAttribute("radioMarriage", radioMarriage);

        return "login/signup";
    }

    @PostMapping("/signup")
    //BindingResult データバインド結果の受取
    public String postSignUp(@ModelAttribute @Validated(GroupOrder.class) SignupForm form, BindingResult bindingResult,
                             Model model){
        if (bindingResult.hasErrors()){

            System.out.println(form);
            System.out.println(bindingResult);
            return getSignUp(form, model);
        }

        //画面から渡された値を確認するため、formの中身をコンソールに出力
        System.out.println(form);
        System.out.println(bindingResult);

        return "redirect:/login";
    }
}
