package com.neo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Document
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    @JsonFormat(timezone = "GMT+8", locale = "zh", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date entryday; // 入职日期
    @JsonFormat(timezone = "GMT+8", locale = "zh", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date leaveday; // 离职日期
    @JsonFormat(timezone = "GMT+8", locale = "zh", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday; // 生日
    String phoneno; //手机号
    String college; //毕业院校
    String bankcardno;//银行卡号
    String bankcardbank; //开户行（支行）
    String bankcardbigbank; //开户银行
    private String idcardno;// 身份证号
    private String idcardaddr; //身份证地址
    private int age;
    private sex sex;

    private enum sex{
        male, female
    }

}
