package com.thoughtworks.capacity.gtb.mvc.Controller;

import com.thoughtworks.capacity.gtb.mvc.Dto.ErrorResult;
import com.thoughtworks.capacity.gtb.mvc.ErrorException.PasswordIsWrong;
import com.thoughtworks.capacity.gtb.mvc.ErrorException.UserExist;
import com.thoughtworks.capacity.gtb.mvc.ErrorException.UserNotExist;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler(UserExist.class)
    public ResponseEntity<ErrorResult> handle(UserExist ex){
        ErrorResult errorResult = new ErrorResult(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List> handle(MethodArgumentNotValidException ex) {
        List<String> errorList = ex.getBindingResult().getAllErrors().stream().map(objectError -> objectError.getDefaultMessage()).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<String>> handle(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        List<String> errorList = new ArrayList<>();
        String message = "";
        for (ConstraintViolation<?> constraint : violations) {
            message = constraint.getMessage();
            ErrorResult errorResult = new ErrorResult(message);
            errorList.add(errorResult.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
    }
}
