package com.jla.service;

import com.jla.dao.PermDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Author:蒋林安
 */
@Service
public class PermServiceImpl implements PermService {
    @Autowired
    private PermDAO permDAO;
    @Override
    public Set<String> queryAllPermByUsername(String username) {
        return permDAO.queryAllPermByUsername(username);
    }
}
