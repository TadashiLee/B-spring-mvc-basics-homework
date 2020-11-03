package com.thoughtworks.capacity.gtb.mvc.ErrorException;

public class UserExist extends RuntimeException{
    public UserExist(String message) {
        super(message);
    }
}
