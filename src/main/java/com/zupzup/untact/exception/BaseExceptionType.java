package com.zupzup.untact.exception;

import org.springframework.http.HttpStatus;

public interface BaseExceptionType {

//    int getErrCode();
    HttpStatus getHttpStatus();
    String getErrMsg();
}
