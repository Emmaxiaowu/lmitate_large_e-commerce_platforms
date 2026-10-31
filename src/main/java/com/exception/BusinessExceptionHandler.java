package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestControllerAdvice
public class BusinessExceptionHandler{

    private static final Logger log = LoggerFactory.getLogger(BusinessExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e)
    {
        ErrorResponse r =  new ErrorResponse("SYSTEM_ERROR","系统繁忙，请稍后再试！");
        log.error("系统发生未处理异常：",e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(r);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> businessExceptionHandler(BusinessException e){
        ErrorResponse response = new ErrorResponse(e.getCode(),e.getMessage());

        HttpStatus status = switch (e.getCode()) {
            case "PRODUCT_NOT_FOUND" -> HttpStatus.NOT_FOUND;
            case "USER_EXIST" -> HttpStatus.CONFLICT;
            case "201" -> HttpStatus.BAD_REQUEST;
            default -> HttpStatus.BAD_REQUEST;
        };

        return ResponseEntity.status(status).body(response);

    }


}
