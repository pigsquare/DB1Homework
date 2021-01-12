package com.zfz.coursemanage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class S {
    private String sno;
    private String sname;
    private String sex;
    private Integer age;
    private String sdept;
    private String logn;
    @JsonIgnore
    private String pswd;
}
