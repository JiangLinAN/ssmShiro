package com.jla.service;

import com.jla.pojo.User;
import org.springframework.stereotype.Service;

/**
 * 用户service层,负责调用UserDAO层
 */
public interface UserService {
    User queryUserByUsername(String username);

    void insertUser(User user);
}
