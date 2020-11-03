package com.thoughtworks.capacity.gtb.mvc.ErrorException;

public class PasswordIsWrong extends RuntimeException{
    public PasswordIsWrong(String message) {
        super(message);
    }
}
