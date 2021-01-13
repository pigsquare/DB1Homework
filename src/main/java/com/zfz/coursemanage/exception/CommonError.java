package com.zfz.coursemanage.exception;

public interface CommonError {
    Integer getErrCode();

    String getMsg();

    CommonError setErrMsg(String errMsg);
}
