package com.thoughtworks.capacity.gtb.mvc.ErrorException;

public class UserNotExist extends RuntimeException{
    public UserNotExist(String message) {
        super(message);
    }
}
