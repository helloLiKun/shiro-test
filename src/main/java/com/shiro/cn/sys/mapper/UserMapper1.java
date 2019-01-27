package com.shiro.cn.sys.mapper;

import com.shiro.cn.sys.entity.User;
import com.shiro.cn.sys.entity.UserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
@Mapper
public interface UserMapper1 extends UserMapper{
    List<User> selectByExample(UserExample example, RowBounds rowBounds);
}