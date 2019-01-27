package com.shiro.cn.sys.service;

import com.shiro.cn.sys.entity.Role;

import java.util.List;

/**
 * Created by Administrator on 2019/1/27 0027.
 */
public interface RoleService {
    List<Role> getRolesByUid(String uid);
}
