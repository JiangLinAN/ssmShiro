package com.jla.dao;

import com.jla.pojo.Claz;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 对claz_jla表和的操作
 * @Author:蒋林安
 */
public interface ClazDAO {
    List<Claz> findAllClaz();
    Claz queryClazById(@Param("id") Integer id);
}
