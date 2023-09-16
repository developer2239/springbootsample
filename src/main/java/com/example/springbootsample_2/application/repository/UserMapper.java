package com.example.springbootsample_2.application.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.springbootsample_2.application.user.model.MUser;

@Mapper
public interface UserMapper {
    /* ユーザ登録 */
    public int insertOne(MUser user);
    
}
