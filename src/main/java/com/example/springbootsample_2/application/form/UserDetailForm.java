package com.example.springbootsample_2.application.form;

import java.util.Date;
import java.util.List;

import com.example.springbootsample_2.application.user.model.Department;
import com.example.springbootsample_2.application.user.model.Salary;

import lombok.Data;

@Data
public class UserDetailForm {
    private String userId;
    private String userName;
    private String password;
    private Date birthday;
    private Integer age;
    private Integer gender;
    private Department department;
    private List<Salary> salaryList;
}
