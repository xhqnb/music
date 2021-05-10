package com.xhq.music.controller;

import com.alibaba.fastjson.JSONObject;
import com.xhq.music.domain.Singer;
import com.xhq.music.service.SingerService;
import com.xhq.music.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value = "/singer")
public class SingerController {
    @Autowired
    SingerService singerService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object addSinger(HttpServletRequest request, HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        String name = request.getParameter("name").trim();
        String sex = request.getParameter("sex").trim();
        String pic = request.getParameter("pic").trim();
        String birth = request.getParameter("birth").trim();
        String location = request.getParameter("location").trim();
        String introduction = request.getParameter("introduction").trim();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = new Date();
        try {
            birthDate = dateFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Singer singer = new Singer();

        singer.setName(name);
        singer.setBirth(birthDate);
        singer.setIntroduction(introduction);
        singer.setLocation(location);
        singer.setSex(new Byte(sex));
        singer.setPic(pic);
        Boolean flag = singerService.insertSinger(singer);
        if (flag) {
            jsonObject.put(Const.code, 1);
            jsonObject.put(Const.msg, "添加成功");

        } else {
            jsonObject.put(Const.code, 0);
            jsonObject.put(Const.msg, "添加失败");
        }
        return jsonObject;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object updateSinger(HttpServletRequest request, HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id").trim();
        String name = request.getParameter("name").trim();
        String sex = request.getParameter("sex").trim();
        String pic = request.getParameter("pic").trim();
        String birth = request.getParameter("birth").trim();
        String location = request.getParameter("location").trim();
        String introduction = request.getParameter("introduction").trim();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = new Date();
        try {
            birthDate = dateFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Singer singer = new Singer();
        singer.setId(Integer.parseInt(id));
        singer.setName(name);
        singer.setBirth(birthDate);
        singer.setIntroduction(introduction);
        singer.setLocation(location);
        singer.setSex(new Byte(sex));
        singer.setPic(pic);
        Boolean flag = singerService.update(singer);
        if (flag) {
            jsonObject.put(Const.code, 1);
            jsonObject.put(Const.msg, "更新成功");

        } else {
            jsonObject.put(Const.code, 0);
            jsonObject.put(Const.msg, "更新失败");
        }
        return jsonObject;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Object deleteSinger(HttpServletRequest request, HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id").trim();
        Boolean flag = singerService.delete(Integer.parseInt(id));
        return flag;
    }

    @RequestMapping(value = "/selectById", method = RequestMethod.GET)
    public Object selectById(HttpServletRequest request) {
        String id = request.getParameter("id").trim();
        return singerService.selectById(Integer.parseInt(id));
    }

    @RequestMapping(value = "/selectAllSinger", method = RequestMethod.GET)
    public Object select(HttpServletRequest request) {
        return singerService.allSinger();
    }
//    模糊查询
   @RequestMapping(value = "/selectOfName", method = RequestMethod.GET)
    public Object selectOfName(HttpServletRequest request) {
        String name=request.getParameter("name").trim();
        return singerService.singerOfName("%"+name+"%");
    }
    @RequestMapping(value = "/selectOfSex", method = RequestMethod.GET)
    public Object selectOfSex(HttpServletRequest request) {
        String sex=request.getParameter("sex").trim();
        return singerService.singerOfSex(Integer.parseInt(sex));
    }
}
