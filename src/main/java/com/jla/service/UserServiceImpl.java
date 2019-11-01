package com.jla.service;

import com.jla.dao.UserDAO;
import com.jla.pojo.User;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

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

    @Override
    public void insertUser(User user) {
        //自动生产一个盐
        user.setSalt(UUID.randomUUID().toString());
        //注册时间
        user.setRegistTime(new Date());
        //密码加密
        Sha256Hash sha256Hash=new Sha256Hash(user.getPassword(),user.getSalt(), 10000);
        user.setPassword(sha256Hash.toBase64());

        userDAO.insertUser(user);
    }
}
