package com.example.springbootsample_2.application.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springbootsample_2.application.form.UserDetailForm;
import com.example.springbootsample_2.application.user.model.MUser;
import com.example.springbootsample_2.application.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserDetailController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    /** ユーザ詳細画面を表示
     * @param form
     * @param model
     * @param userId
     * @return
     */
    @GetMapping("/detail/{userId:.+}")
    public String getUser(UserDetailForm form,Model model,@PathVariable String userId){
        MUser user = userService.getUserOne(userId);
        user.setPassword("");
        form = modelMapper.map(user,UserDetailForm.class);
        // System.out.println(user);
        form.setSalaryList(user.getSalaryList());
        model.addAttribute("userDetailForm", form);
        return "/user/detail";
    }

    @PostMapping(value="/detail", params="update")
    public String updateUser(UserDetailForm form,Model model){
        MUser user = userService.getUserOne(form.getUserId());
        user.setUserName(form.getUserName());
        user.setPassword(form.getPassword());
        userService.updateUserOne(user);
        return "redirect:/user/list";
    }

    /**
     * @param form 削除対象のフォームデータ、ユーザデータ
     * @param model
     * @return　リスト画面へのリダイレクト、パス情報
     */
    @PostMapping(value="/detail", params="delete")
    public String deleteUser(UserDetailForm form,Model model){
        userService.deleteUserOne(form.getUserId());;
        return "redirect:/user/list";
    }

}
