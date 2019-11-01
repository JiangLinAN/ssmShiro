package com.jla.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jla.pojo.User;
import com.jla.realm.MyRealm;
import com.jla.service.RoleService;
import com.jla.service.UserService;
import com.jla.utils.MyStatus;
import lombok.extern.log4j.Log4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 关于用户操作的controller
 * 包括:登录,注册
 * 对用户表的添加,修改,删除,查询
 *
 * @Author:蒋林安
 */
@Controller
@RequestMapping("/user")
@Log4j
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    /**
     * 用户登录
     *
     * @param user 从前端接受到的数据
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public MyStatus userLogin(@RequestBody User user) {
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        return MyStatus.ok("登录成功");
    }

    /**
     * @param code    验证码
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkCode")
    public MyStatus checkCode(@RequestBody String code, HttpSession session) {
        String cap = (String) session.getAttribute("captcha");
        String substring = code.substring(10, code.length() - 2);
        if (substring.equalsIgnoreCase(cap)) {
            return MyStatus.ok("验证码ok");
        } else {
            return MyStatus.error("验证码不正确");
        }
    }

    /**
     * 学生注册
     *
     * @param user
     * @return
     */
    @RequestMapping("/regist")
    @ResponseBody
    public MyStatus registUser(@RequestBody User user) {
        try {
            userService.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return MyStatus.error("查无此班级,请重新注册");
        }
        roleService.insertUserRole(user.getId(), 1);
        return MyStatus.ok("注册成功");
    }

    /**
     * 老师注册
     *
     * @param user
     * @return
     */
    @RequestMapping("/regist2")
    @ResponseBody
    public MyStatus tearegistUser(@RequestBody User user) {
        userService.insertUser(user);
        roleService.insertUserRole(user.getId(), 2);
        return MyStatus.ok("注册成功");
    }


    @RequestMapping("/allUser")
    public String clazUser(Integer clazId, String num,HttpServletRequest request){
        Integer pn=1;
        if (num!=null){
            pn=Integer.parseInt(num);
        }
        if (pn<1){
            pn=1;
        }
        PageHelper.startPage(pn,5);
        List<User> users=userService.findUserByClazId(clazId);
        PageInfo<User> pageInfo=new PageInfo<>(users);
        request.setAttribute("clazId",clazId);
        request.setAttribute("pageInfo",pageInfo);
        return "WEB-INF/student";
    }

    @RequestMapping("del")
    public void deleUser(Integer id){
        userService.deleUser(id);
    }
}
