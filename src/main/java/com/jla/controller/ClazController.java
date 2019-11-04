package com.jla.controller;

import com.jla.pojo.Claz;
import com.jla.service.ClazService;
import lombok.extern.log4j.Log4j;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author:蒋林安
 */
@RequestMapping("/claz")
@RequiresAuthentication
@Log4j
@Controller
public class ClazController {
    @Autowired
    private ClazService clazService;

    @RequestMapping("list")
    public String listClaz(HttpServletRequest request ){
        List<Claz> allClaz = clazService.findAllClaz();
        request.setAttribute("allClaz",allClaz);
        return "WEB-INF/index";
    }

}
