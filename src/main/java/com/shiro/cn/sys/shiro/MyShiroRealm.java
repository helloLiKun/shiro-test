package com.shiro.cn.sys.shiro;

import com.shiro.cn.sys.entity.Permission;
import com.shiro.cn.sys.entity.Role;
import com.shiro.cn.sys.entity.User;
import com.shiro.cn.sys.service.PermissionService;
import com.shiro.cn.sys.service.RoleService;
import com.shiro.cn.sys.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/1/27 0027.
 */
public class MyShiroRealm extends AuthorizingRealm {


    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user  = (User) principals.getPrimaryPrincipal();
        List<Role> roleList=roleService.getRolesByUid(user.getId());
        for(Role role:roleList){
            authorizationInfo.addRole(role.getId());
            List<Permission> permissionList=permissionService.getPermissionsByRid(role.getId());
            for(Permission p:permissionList){
                authorizationInfo.addStringPermission(p.getId());
            }
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        System.out.println(token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        User user = userService.getUserByUserName(username);
        System.out.println("----->>userInfo="+user);
        if(user == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user, //用户名
                user.getPwd(), //密码
                ByteSource.Util.bytes("abc"),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }
}
