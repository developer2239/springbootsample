package com.example.springbootsample_2.application.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.springbootsample_2.application.user.model.MUser;

@Mapper
public interface UserMapper {
    /* ユーザ登録 */
    public int insertOne(MUser user);
    /* ユーザ取得 */
    public List<MUser> findMany(MUser user);
    /* ユーザ一取得（１件） */
    public MUser findOne(String userId);
    /* ユーザ更新 */
    public void updateOne(@Param("user")MUser user);
    /* ユーザ削除 */
    public void deleteOne(@Param("userId")String userId);
    
}
