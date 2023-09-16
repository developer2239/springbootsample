package com.example.springbootsample_2.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * ログインページのコントローラ
 * /loginへの処理。
 * @author ICHITARO UEZONO
 * @version 1.0
 */
@Controller
public class LoginController {
    
    @GetMapping("/login")
    public String getLogin(){
        return "/login/login";
    }

    @PostMapping("/login")
    public String postLogin(){
        return "redirect:/user/list";
    }
}
