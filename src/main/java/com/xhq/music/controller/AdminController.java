package com.xhq.music.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xhq.music.service.AdminService;
import com.xhq.music.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    /*
     * 判断是否登录成功
     * */

    @RequestMapping(value = "/admin/login/status", method = RequestMethod.POST)
    public Object loginStatus(HttpServletRequest request, HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        boolean flag = adminService.verifyPassword(name, password);

        System.out.println(name+" "+password);

        if (flag) {
            jsonObject.put(Const.code, 1);
            jsonObject.put(Const.msg, "登录成功");
            session.setAttribute(Const.NAME, name);
            return jsonObject;
        } else {
            jsonObject.put(Const.code, 0);
            jsonObject.put(Const.msg, "用户名或密码错误");
            session.setAttribute(Const.NAME, name);
            return jsonObject;
        }

    }
}
