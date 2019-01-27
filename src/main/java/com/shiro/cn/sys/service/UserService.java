package com.shiro.cn.sys.service;

import com.shiro.cn.sys.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2019/1/27 0027.
 */
public interface UserService {
    void add(User user);
    void edit(User user);
    User detail(String id);
    List<User> list(User user,int pi,int ps);
    User getUserByUserName(String username);

}
