package com.jla.dao;

import com.jla.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户DAO,所有用户对数据表user_jla的操作
 */
public interface UserDAO {
    User queryUserByUsername(@Param("username")String username);

    void insertUser(User user);

    List<User> findUserByClazId(@Param("clazId") Integer clazId);

    void deleUser(@Param("id") Integer id);
}
