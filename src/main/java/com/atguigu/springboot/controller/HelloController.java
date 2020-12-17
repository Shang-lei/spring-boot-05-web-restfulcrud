package com.atguigu.springboot.controller;

import com.atguigu.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    /*public String Hello(){

        return "hello 你好";
    }*/
    public  String hello(@RequestParam("user") String user){
        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "Hello World";
    }

    /**
     * 设置模板引擎的前后端分别显示信息
     * 查出一些数据，在页面展示
     * */
    @RequestMapping("/success")
    public String Success(Map<String,Object>map){
        map.put("hello","你好，后端显示信息");
        return "success";
    }
}
