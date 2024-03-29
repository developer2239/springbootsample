package com.example.springbootsample_2.application.aspect;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllAdvice {
    
    /**
     * データベース関連の例外処理
     * @param e
     * @param model
     * @return
     */
    @ExceptionHandler(DataAccessException.class)
    public String dataAccessExceptionHandler(DataAccessException e, Model model){
        model.addAttribute("error", "");
        model.addAttribute("message", "DataAccessExceptionが発生しました。");
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
        return "error";
    }
    
    /**
     * その他の例外処理
     * @param e
     * @param model
     * @return
     */
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(DataAccessException e, Model model){
        model.addAttribute("error", "");
        model.addAttribute("message", "Exceptionが発生しました");
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
        return "error";
    }
}
