package com.jla.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * 有关perm_jla的操作
 * @Author:蒋林安
 */
public interface PermDAO {
    Set<String> queryAllPermByUsername(@Param("username") String username);
}
