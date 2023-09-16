package com.example.springbootsample_2.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @Autowired
    HelloService service;

    @GetMapping(path="/hello")
    public String getHello(){
        return "/hello";
    }

    @PostMapping(path="/hello")
    public String postHello(@RequestParam("text1")String name,Model model){
        model.addAttribute("name",name);
        return "/hello/response";
    }

    @PostMapping("/hello/db")
    public String postDbRequest(@RequestParam("text2")String id,Model model){
        //一件検索
        Employee employee = service.getEmployee(id);
        //検索結果をModelに登録
        model.addAttribute("employee", employee);
        return "hello/db";
    }

}