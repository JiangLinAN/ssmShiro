package com.jla.daoTest;

import com.jla.dao.PermDAO;
import com.jla.dao.RoleDAO;
import com.jla.dao.UserDAO;
import com.jla.pojo.Perm;
import com.jla.pojo.User;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * @Author:蒋林安
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@Log4j
public class TestDAO {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private RoleDAO roleDAO;
    @Autowired
    private PermDAO permDAO;

    @Test
    public void testqueryUserByUsername(){
        User jla = userDAO.queryUserByUsername("jla");
        log.info(jla);
    }
    @Test
    public void testRole(){
        Set<String> jla = roleDAO.queryAllRolenameByUsername("jla");
        for (String s : jla) {
            log.info(s);
        }
    }
    @Test
    public void testPerm(){
        Set<String> v = permDAO.queryAllPermByUsername("king");
        for (String s : v) {
            log.info(s);
        }
    }
/**
 * 测试插入一条用户角色信息
 */
@Test
    public void testUserRole(){
    roleDAO.insertUserRole(5,1);
}
}
