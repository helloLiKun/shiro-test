package com.shiro.cn.sys.controller;

import com.shiro.cn.sys.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Administrator on 2019/1/27 0027.
 */
@Controller
public class LoginController {
    @RequestMapping("/sys/login")
    public String login(){
        return "sys/login";
    }

    @RequestMapping("/sys/login-submit")
    public String loginSubmit(User user){
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                user.getName(),
                user.getPwd());
        //进行验证，这里可以捕获异常，然后返回对应信息
        subject.login(usernamePasswordToken);
        return "sys/login";
    }

    @RequestMapping("/sys/index")
    public String index(){
        return "sys/index";
    }

    @RequestMapping("/sys/logout")
    public String logout(){
        return "sys/logout";
    }

}
