package com.jla.service;

import com.jla.dao.RoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Author:蒋林安
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDAO roleDAO;
    @Override
    public Set<String> queryAllRolenameByUsername(String username) {
        return roleDAO.queryAllRolenameByUsername(username);
    }
}
