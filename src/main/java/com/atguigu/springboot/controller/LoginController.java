package com.atguigu.springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    //指定重定向的页面
    //login页面中已经定义<form class="form-signin" action="dashboard.html"  th:action="@{/user/login}" method="post">
    @PostMapping(value="/user/login")

    //表单登录的验证方法
    //@RequestParam用于指定对应的参数，map用于提示错误信息，session用于保存用户的登录信息，便于拦截器判断
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            //登录成功，防止表单重复提交，使用重定向到主页，不使用跳转
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else{
            //登陆失败，提示错误信息
            map.put("msg","用户名或密码错误");
            return "login";
        }

    }
}
