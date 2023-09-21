package com.example.springbootsample_2.application.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springbootsample_2.application.repository.UserMapper;
import com.example.springbootsample_2.application.user.model.MUser;
import com.example.springbootsample_2.application.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /** ユーザ登録 */
    @Override
    public void signup(MUser user) {
        user.setDepartmentId(1); // 部署
        user.setRole("ROLE_GENERAL");   // ロール
        // パスワード暗号化
        String rawPassword = user.getPassword();
        user.setPassword(passwordEncoder.encode(rawPassword));
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
    @Transactional
    @Override
    public void updateUserOne(MUser user) {
        // パスワード暗号化
        String rawPassword = user.getPassword();
        user.setPassword(passwordEncoder.encode(rawPassword));

        mapper.updateOne(user);
        // added error code intentionally
        // int i = 1/0;
        // added error code intentionally

    }

    /** ユーザ削除（１件） */
    @Override
    public void deleteUserOne(String userId) {
        mapper.deleteOne(userId);
    }
    
}
