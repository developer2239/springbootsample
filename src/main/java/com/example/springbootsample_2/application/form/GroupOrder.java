package com.example.springbootsample_2.application.form;

import jakarta.validation.GroupSequence;

@GroupSequence({ValidGroup1.class,ValidGroup2.class})
public interface GroupOrder {
    
}
