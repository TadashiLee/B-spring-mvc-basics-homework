package com.thoughtworks.capacity.gtb.mvc.Service;

import com.thoughtworks.capacity.gtb.mvc.Dto.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {
    private Map<String, User> userMap = new HashMap<>();

    public UserService() {
        userMap.put("lucky", new User("lucky", "123", "123@qq.com"));
        userMap.put("Tadashi", new User("Tadashi", "111", "234@163.com"));
    }

    public boolean login(String name, String password) {
        if(userMap.get(name) == null) {
            return false;
        }else {
            if(userMap.get(name).getPassWord() == password){
                return true;
            }else {
                return false;
            }
        }
    }
}
