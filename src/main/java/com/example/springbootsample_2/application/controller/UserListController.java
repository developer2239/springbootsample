package com.example.springbootsample_2.application.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springbootsample_2.application.form.UserListForm;
import com.example.springbootsample_2.application.user.model.MUser;
import com.example.springbootsample_2.application.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserListController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;
    
    /* ユーザ一覧画面を表示 */
    @GetMapping("/list")
    public String getUserList(@ModelAttribute UserListForm form,Model model){
        MUser user = modelMapper.map(form, MUser.class);
        // ユーザ一覧取得
        List<MUser> userList = userService.getUsers(user);
        model.addAttribute("userList",userList);
        return "/user/list";
    }

    /* ユーザ検索処理 */
    @PostMapping("/list")
    public String postUserList(@ModelAttribute UserListForm form, Model model){
        //formをMUserクラスへ変換
        MUser user = modelMapper.map(form,MUser.class);
        //ユーザ検索
        List<MUser> userList = userService.getUsers(user);
        model.addAttribute("userList", userList);
        return "/user/list";
    }
    
}
