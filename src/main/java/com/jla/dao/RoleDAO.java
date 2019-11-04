package com.jla.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * 所有对role_jla和user_role的操作
 * @Author:蒋林安
 */
public interface RoleDAO {
    Set<String> queryAllRolenameByUsername(@Param("username") String username);
    void insertUserRole(@Param("userId") Integer userId,@Param("roleId") Integer roleId);
}
