package com.example.springbootsample_2.application.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Aspect
@Component
@Slf4j
public class LogAspect {

    /**
     * サービスの実行前にログを出力する
     * 対象:[UserService]をクラス名に含んでいる
     * @param jp
     */
    // @Before("execution(* *..*.*UserService.*(..))")
    @Before("execution(* com.example.springbootsample_2.application.user.service.*.*(..))")
    public void startLog(JoinPoint jp){
        log.info("メソッド開始"+jp.getSignature());
    }

    /**
     * サービスの実行後にログを出力する
     * 対象:[UserService]をクラス名に含んでいる
     * @param jp
     */
    @After("execution(* com.example.springbootsample_2.application.user.service.*.*(..))")
    public void endLog(JoinPoint jp){
        log.info("メソッド終了:"+jp.getSignature());
    }
    
}
