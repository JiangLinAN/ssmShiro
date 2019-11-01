package com.jla.realm;


import com.jla.pojo.User;
import com.jla.service.PermService;
import com.jla.service.RoleService;
import com.jla.service.UserService;
import lombok.Setter;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.Set;

/**
 * 为shiro框架的功能实现数据支持
 * @Author:蒋林安
 */
@Setter
public class MyRealm extends AuthorizingRealm {
    private UserService userService;
    private RoleService roleService;
    private PermService permService;
    /**
     * 角色和权限查询
     * @param principals 用户凭证
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        Set<String> role =roleService.queryAllRolenameByUsername(username);
        Set<String> perm = permService.queryAllPermByUsername(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo(role);
        simpleAuthorizationInfo.setStringPermissions(perm);
        return simpleAuthorizationInfo;
    }

    /**
     *身份验证
     * @param token UserPassword对象
     * @return 从数据库查询出来的真实数据
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        User user = userService.queryUserByUsername(username);
        return new SimpleAuthenticationInfo(
                user.getUsername(),
                user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),
                this.getName()
        );
    }
}
