package com.shiro.cn.sys.controller;

import com.shiro.cn.sys.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ConcurrentAccessException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String loginSubmit(User user, ModelMap map){
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                user.getName(),
                user.getPwd());
        //进行验证，这里可以捕获异常，然后返回对应信息
        try {
            subject.login(usernamePasswordToken);
            //异常类型https://blog.csdn.net/qq_28637575/article/details/78590319
            //账号、密码不匹配
        }catch (IncorrectCredentialsException e){
            map.put("msg","账号、密码不匹配");
            //重复登录
        }catch (ConcurrentAccessException e){
            map.put("msg","重复登录");
            //认证次数超限
        }catch (ExcessiveAttemptsException e){
            map.put("msg","认证次数超限");
        }finally {
            if(subject.isAuthenticated()){
                return "sys/index";
            }else{
                return "sys/login";
            }
        }
    }

    @RequestMapping("/index")
    public String index(){
        return "sys/index";
    }

    @RequestMapping("/sys/logout")
    public String logout(){
        Subject subject=SecurityUtils.getSubject();
        subject.logout();
        return "sys/logout";
    }



}
