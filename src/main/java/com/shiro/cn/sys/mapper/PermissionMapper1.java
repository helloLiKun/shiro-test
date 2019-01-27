package com.shiro.cn.sys.mapper;

import com.shiro.cn.sys.entity.Permission;
import com.shiro.cn.sys.entity.PermissionExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
@Mapper
public interface PermissionMapper1 extends PermissionMapper{
    List<Permission> selectByExample(PermissionExample example, RowBounds rowBounds);
}