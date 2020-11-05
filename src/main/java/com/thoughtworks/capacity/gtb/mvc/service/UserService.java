package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.entity.User;
import com.thoughtworks.capacity.gtb.mvc.exception.DuplicateUserNameException;
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
        users.put(user.getUsername(), user);
    }
}
