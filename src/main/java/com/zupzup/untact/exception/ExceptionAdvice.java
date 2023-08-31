package com.zupzup.untact.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity handleBaseException(BaseException ex) {

        log.error("BaseException errorMessage(): {}",ex.getExceptionType().getErrMsg());
        log.error("BaseException errorCode(): {}",ex.getExceptionType().getErrCode());

        return new ResponseEntity(new ExceptionRes(ex.getExceptionType().getErrCode(), ex.getExceptionType().getErrMsg()),
                ex.getExceptionType().getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleLoginEx(Exception ex) {

        ex.printStackTrace();
        return new ResponseEntity(HttpStatus.OK);
    }

    @Data
    @AllArgsConstructor
    static class ExceptionRes {

        private Integer errCode;
        private String errMsg;
    }
}
