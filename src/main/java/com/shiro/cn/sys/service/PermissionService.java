package com.shiro.cn.sys.service;

import com.shiro.cn.sys.entity.Permission;

import java.util.List;

/**
 * Created by Administrator on 2019/1/27 0027.
 */
public interface PermissionService {
    List<Permission> getPermissionsByRid(String rid);
}
