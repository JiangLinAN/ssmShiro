package com.jla.service;


import com.jla.pojo.Claz;

import java.util.List;

public interface ClazService {
    List<Claz> findAllClaz();
    Claz queryClazById( Integer id);
}
