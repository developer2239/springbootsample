package com.example.springbootsample_2.application.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value="/detail/{userId:.+}",method=RequestMethod.GET)
    public String getUser(UserDetailForm form,Model model,@PathVariable String userId){
        MUser user = userService.getUserOne(userId);
        user.setPassword("");
        form = modelMapper.map(user,UserDetailForm.class );
        model.addAttribute("userDetailForm", form);
        return "/user/detail";
    }
}
