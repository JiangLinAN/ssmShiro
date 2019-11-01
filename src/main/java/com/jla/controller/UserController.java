package com.jla.controller;

import com.jla.pojo.User;
import com.jla.realm.MyRealm;
import com.jla.service.UserService;
import com.jla.utils.MyStatus;
import lombok.extern.log4j.Log4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 关于用户操作的controller
 * 包括:登录,注册
 * 对用户表的添加,修改,删除,查询
 * @Author:蒋林安
 */
@Controller
@RequestMapping("/user")
@Log4j
public class UserController {
    @Autowired
    private UserService userService;


    /**
     * 用户登录
     * @param user 从前端接受到的数据
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public MyStatus userLogin(@RequestBody User user){
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        token.setRememberMe(true);
        return MyStatus.ok("登录成功");
    }

    @ResponseBody
    @RequestMapping("/checkCode")
    public MyStatus checkCode(@RequestBody String code, HttpSession session) {
        String cap = (String) session.getAttribute("captcha");
        log.info(cap);
        String substring = code.substring(10, code.length()-2);
        log.info(substring);
        if (substring.equalsIgnoreCase(cap)) {
            return MyStatus.ok("验证码ok");
        } else {
            return MyStatus.error("验证码不正确");
        }
    }

}
