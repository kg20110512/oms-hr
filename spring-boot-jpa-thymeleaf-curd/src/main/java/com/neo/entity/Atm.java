package com.neo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Atm {

    @Id
    String id;
    String name;
    String userid;

    private String contentType; // 文件类型
    private long size;
    private Date uploadDate;
    private String md5;
    @JsonIgnore
    private Binary content; // 文件内容
    private String path; // 文件路径

    public Atm(String name, String userid, String contentType, long size, Binary content) {
        this.name = name;
        this.userid = userid;
        this.contentType = contentType;
        this.size = size;
        this.uploadDate = new Date();
        this.content = content;
    }

}
