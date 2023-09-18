package com.example.springbootsample_2.application.user.model;

import lombok.Data;

@Data
public class Salary {
    private String userId;
    private String yearMonth;
    private Integer salary;
}
