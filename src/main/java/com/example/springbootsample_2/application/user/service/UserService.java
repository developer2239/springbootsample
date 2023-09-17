package com.example.springbootsample_2.application.user.service;

import java.util.List;

import com.example.springbootsample_2.application.user.model.MUser;

public interface UserService {
    /**  ユーザ登録 */
    public void signup(MUser user);
    /**  ユーザ取得 */
    public List<MUser> getUsers();
    /**  ユーザ取得（１件）*/
    public MUser getUserOne(String userId);
    /** ユーザ更新 （１件）*/
    public void updateUserOne(MUser user);
    /** ユーザ削除（１件） */
    public void deleteUserOne(String userId);
}
