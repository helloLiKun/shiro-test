package com.shiro.cn.sys.service.impl;

import com.shiro.cn.sys.entity.User;
import com.shiro.cn.sys.entity.UserExample;
import com.shiro.cn.sys.mapper.UserMapper1;
import com.shiro.cn.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/1/27 0027.
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void add(User user) {

    }

    @Override
    public void edit(User user) {

    }

    @Override
    public User detail(String id) {
        return null;
    }

    @Override
    public List<User> list(User user, int pi, int ps) {
        return null;
    }

    @Override
    public User getUserByUserName(String username) {
        UserExample example=new UserExample();
        UserExample.Criteria c=example.createCriteria();
        c.andNameEqualTo(username);
        List<User> list=userMapper1.selectByExample(example);
        if(list!=null && list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Autowired
    UserMapper1 userMapper1;
}
