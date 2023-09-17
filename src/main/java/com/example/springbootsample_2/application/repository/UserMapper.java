package com.example.springbootsample_2.application.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.example.springbootsample_2.application.user.model.MUser;

@Mapper
public interface UserMapper {
    /* ユーザ登録 */
    public int insertOne(MUser user);
    /* ユーザ取得 */
    public List<MUser> findMany();
    /* ユーザ一取得（１件） */
    public MUser findOne(String userId);
    
}
