package com.shiro.cn.sys.mapper;

import com.shiro.cn.sys.entity.Role;
import com.shiro.cn.sys.entity.RoleExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
@Mapper
public interface RoleMapper1 extends RoleMapper{
    List<Role> selectByExample(RoleExample example, RowBounds rowBounds);
}