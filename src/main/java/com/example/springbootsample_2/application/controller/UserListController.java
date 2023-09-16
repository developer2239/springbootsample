package com.example.springbootsample_2.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserListController {

    // ユーザ一覧画面を表示
    @GetMapping("/list")
    public String getUserList(){
        return "/user/list";
    }
    
}