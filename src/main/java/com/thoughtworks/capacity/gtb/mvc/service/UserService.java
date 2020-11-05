package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.entity.User;
import com.thoughtworks.capacity.gtb.mvc.exception.DuplicateUserNameException;
import com.thoughtworks.capacity.gtb.mvc.exception.LoginException;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<String, User> users = new HashMap<>();

    public void register(User user) {
        if (users.containsKey(user.getUsername())) {
            throw new DuplicateUserNameException("用户名重复");
        }
        user.setId(users.size()+1);
        users.put(user.getUsername(), user);
    }

    public User login(String username, String password){
        User user = users.get(username);
        if (user == null || !user.getPassword().equals(password)){
            throw new LoginException("用户名或密码错误");
        }
        return user;
    }
}
