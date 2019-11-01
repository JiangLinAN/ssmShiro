package com.jla.service;

import com.jla.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户service层,负责调用UserDAO层
 */
public interface UserService {
    User queryUserByUsername(String username);

    void insertUser(User user);

    List<User> findUserByClazId(Integer clazId);

    void deleUser(Integer id);
}
