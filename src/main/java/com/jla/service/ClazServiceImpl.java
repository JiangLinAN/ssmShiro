package com.jla.service;

import com.jla.dao.ClazDAO;
import com.jla.pojo.Claz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:蒋林安
 */
@Service
public class ClazServiceImpl implements ClazService {
    @Autowired
    private ClazDAO clazDAO;
    @Override
    public List<Claz> findAllClaz() {
        return clazDAO.findAllClaz();
    }

    @Override
    public Claz queryClazById(Integer id) {
        return clazDAO.queryClazById(id);
    }
}
