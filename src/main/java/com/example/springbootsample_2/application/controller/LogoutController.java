package com.example.springbootsample_2.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class LogoutController {

    @PostMapping(value="logout")
    public String postLogout() {
        log.info("ログアウト");
        return "";
    }
    
}
