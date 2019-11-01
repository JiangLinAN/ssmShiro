package com.jla.service;

import java.util.Set;

public interface RoleService {
    Set<String> queryAllRolenameByUsername(String username);
    void insertUserRole(Integer userId,Integer roleId);
}
