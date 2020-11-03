package com.thoughtworks.capacity.gtb.mvc.Service;

import com.thoughtworks.capacity.gtb.mvc.Dto.User;
import com.thoughtworks.capacity.gtb.mvc.ErrorException.PasswordIsWrong;
import com.thoughtworks.capacity.gtb.mvc.ErrorException.UserExist;
import com.thoughtworks.capacity.gtb.mvc.ErrorException.UserNotExist;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {
    private Map<String, User> userMap = new HashMap<>();

    public UserService() {
        userMap.put("lucky", new User(1,"lucky", "123", "123@qq.com"));
        userMap.put("Tadashi", new User(2,"Tadashi", "111", "234@163.com"));
    }

    public User login(String name, String password) {
        if(userMap.get(name) == null) {
            throw new UserNotExist("用户名不存在");
        }else {
            if(userMap.get(name).getPassWord().equals(password)){
                return userMap.get(name);
            }else {
                throw new PasswordIsWrong("密码错误");
            }
        }
    }

    public void register(User user){
        if(userMap.get(user.getName()) == null){
            user.setId(userMap.size());
            userMap.put(user.getName(), user);
        }else {
            throw new UserExist("该用户名已被注册");
        }
    }
}
