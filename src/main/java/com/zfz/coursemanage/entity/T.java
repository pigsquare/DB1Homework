package com.zfz.coursemanage.entity;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

@Data
public class T {
    private String tno;
    private String tname;
    private String tdept;
    private String tclass;
    private String logn;
    @JsonIgnore
    private String pswd;
}
