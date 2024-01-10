package com.zupzup.untact.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity handleBaseException(BaseException ex) {

        log.error("BaseException errorMessage(): {}",ex.getExceptionType().getErrMsg());
//        log.error("BaseException errorCode(): {}",ex.getExceptionType().getErrCode());

        // ResponseEntity의 본문으로 직접 문자열 전달
        return new ResponseEntity<>(ex.getExceptionType().getErrMsg(), ex.getExceptionType().getHttpStatus());
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity handleLoginEx(Exception ex) {
//
//        ex.printStackTrace();
//        return new ResponseEntity(HttpStatus.OK);
//    }
}
