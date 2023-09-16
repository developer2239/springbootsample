package com.example.springbootsample_2.hello;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelloRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Map<String,Object> findById(String id) {

        // 一件取得のクエリ
        String query = "SELECT * FROM employee WHERE id = ?";
        // 検索処理
        Map<String,Object> employee = jdbcTemplate.queryForMap(query, id);

        return employee;
    }
}
