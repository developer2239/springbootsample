package com.example.springbootsample_2.application.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootsample_2.application.repository.UserMapper;
import com.example.springbootsample_2.application.user.model.MUser;
import com.example.springbootsample_2.application.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper mapper;

    /** ユーザ登録 */
    @Override
    public void signup(MUser user) {
        user.setDepartmentId(1); // 部署
        user.setRole("ROLE_GENERAL");   // ロール
        mapper.insertOne(user);
    }

    /** ユーザ取得 */
    @Override
    public List<MUser> getUsers(MUser user) {
        return mapper.findMany(user);
    }

    /** ユーザ取得（１件） */
    @Override
    public MUser getUserOne(String userId) {
        return mapper.findOne(userId);
    }

    /** ユーザ更新（１件） */
    @Override
    public void updateUserOne(MUser user) {
        mapper.updateOne(user);
    }

    /** ユーザ削除（１件） */
    @Override
    public void deleteUserOne(String userId) {
        mapper.deleteOne(userId);
    }
    
}
