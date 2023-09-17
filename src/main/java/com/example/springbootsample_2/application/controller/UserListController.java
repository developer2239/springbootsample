package com.example.springbootsample_2.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springbootsample_2.application.user.model.MUser;
import com.example.springbootsample_2.application.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserListController {

    @Autowired
    private UserService userService;
    
    // ユーザ一覧画面を表示
    @GetMapping("/list")
    public String getUserList(Model model){
        // ユーザ一覧取得
        List<MUser> userList = userService.getUsers();
        model.addAttribute("userList",userList);
        return "/user/list";
    }
    
}
