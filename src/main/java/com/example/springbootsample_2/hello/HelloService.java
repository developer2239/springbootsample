package com.example.springbootsample_2.hello;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Autowired
    private HelloRepository repository;

    /** 従業員を一人取得する */
    public Employee getEmployee(String id){
        //検索
        Map<String,Object> map = repository.findById(id);

        //Mapから値を取得
        String employeeId = (String) map.get("id");
        String employeeName = (String) map.get("name");
        Integer employeeAge = (Integer) map.get("age");

        Employee employee = new Employee();
        employee.setEmployeeId(employeeId);
        employee.setEmployeeName(employeeName);
        employee.setEmployeeAge(employeeAge);

        return employee;
    }
    
}
