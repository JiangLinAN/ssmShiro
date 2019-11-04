package com.jla.serviceTest;

import com.jla.pojo.Claz;
import com.jla.pojo.User;
import com.jla.service.ClazService;
import com.jla.service.RoleService;
import com.jla.service.UserService;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

/**
 * @Author:蒋林安
 */
@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private ClazService clazService;
@Autowired
private RoleService roleService;
    @Test
    public void insertUser(){
        User user=new User();
        user.setUsername("nore");
        user.setPassword("123");
        user.setGender("男");
        user.setClazId(1);
        userService.insertUser(user);
    }
    @Test
    public void testRole(){
        List<Claz> allClaz = clazService.findAllClaz();
        for (Claz claz : allClaz) {
            log.info(claz);
        }
    }
    @Test
    public void testAllRole(){
        Set<String> nore = roleService.queryAllRolenameByUsername("nore");
        for (String s : nore) {
            System.out.println(s);
        }
    }
}
