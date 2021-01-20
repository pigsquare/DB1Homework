package com.zfz.coursemanage.exception;

import com.zfz.coursemanage.util.TimeUtil;
import lombok.Data;

import java.util.Date;

@Data
public class ErrorResult {
    private String timestamp;

    private Integer status;

    private String error;

    private String message;

    private String path;

    public ErrorResult(Integer status,
                       String error,
                       String message,
                       String path) {
        Date date = new Date(System.currentTimeMillis());

        this.timestamp = TimeUtil.DateToString(date);
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
