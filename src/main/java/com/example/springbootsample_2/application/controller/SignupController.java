package com.example.springbootsample_2.application.controller;

import java.util.Map;
import java.util.Locale;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springbootsample_2.application.form.GroupOrder;
import com.example.springbootsample_2.application.form.SignupForm;
import com.example.springbootsample_2.application.service.UserApplicationService;
import com.example.springbootsample_2.application.user.model.MUser;
import com.example.springbootsample_2.application.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * ユーザ登録処理のコントローラです。
 * URLプレフィックス’/user’以下の処理クラス。
 * @author　Ichitaro Uezono
 * @version 1.0
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class SignupController {

    @Autowired
    UserApplicationService userApplicationService;

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    /** 
     * ユーザ登録画面を表示
     * @param model
     * @return URLパス
    */
    @GetMapping("/signup")
    public String getSignup(Model model,Locale locale,@ModelAttribute SignupForm form){

        // 性別マッピングを取得し、modelへ渡す
        Map<String,Integer> genderMap = userApplicationService.getGenderMap(locale);
        model.addAttribute("genderMap", genderMap);
        
        return "user/signup";
    }

    /** 
     * ユーザ登録処理
     * @return URLパス
     */
    @PostMapping("/signup")
    public String postSignup(Model model,Locale locale,@ModelAttribute @Validated(GroupOrder.class) SignupForm form,BindingResult bindingResult){

        // フォームのエラーチェック（バリデーションチェック）
        if (bindingResult.hasErrors()) {
            return getSignup(model, locale, form);
        }
        log.info(form.toString());

        // form　を　MUser　クラスに変換
        MUser user = modelMapper.map(form,MUser.class);

        // ユーザ登録
        userService.signup(user);

        return "redirect:/login";
    }
    
}
