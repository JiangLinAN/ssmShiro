package com.jla.service;

import java.util.Set;

public interface PermService {
    Set<String> queryAllPermByUsername(String username);
}
