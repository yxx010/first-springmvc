package com.imooc.springmvc.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
@Data
public class User {
    private String username;
    private Long password;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
}
