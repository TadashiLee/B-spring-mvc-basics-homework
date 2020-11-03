package com.thoughtworks.capacity.gtb.mvc.Controller;

import com.thoughtworks.capacity.gtb.mvc.Dto.ErrorResult;
import com.thoughtworks.capacity.gtb.mvc.ErrorException.PasswordIsWrong;
import com.thoughtworks.capacity.gtb.mvc.ErrorException.UserNotExist;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotExist.class)
    public ResponseEntity<ErrorResult> handle(UserNotExist ex){
        ErrorResult errorResult = new ErrorResult(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);
    }

    @ExceptionHandler(PasswordIsWrong.class)
    public ResponseEntity<ErrorResult> handle(PasswordIsWrong ex){
        ErrorResult errorResult = new ErrorResult(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);
    }
}
