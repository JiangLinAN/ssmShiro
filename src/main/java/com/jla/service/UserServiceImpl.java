package com.jla.service;

import com.jla.dao.UserDAO;
import com.jla.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService的实现类
 * @Author:蒋林安
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Override
    public User queryUserByUsername(String username) {
        return userDAO.queryUserByUsername(username);
    }
}
