package com.fx.realm;

import com.fx.entity.Role;
import com.fx.entity.UserInfo;
import com.fx.service.RoleService;
import com.fx.service.UserInfoService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class LoginRealm extends AuthorizingRealm {


    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private RoleService roleService;

    //获取角色权限信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) getAvailablePrincipal(principalCollection);
        UserInfo userInfo = userInfoService.findByName(username);
        Role role = roleService.findById(userInfo.getRoleId());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> roleNameSet = new HashSet<>();
        if (role != null) {
            roleNameSet.add(role.getRoleName());
            info.setRoles(roleNameSet);
        }
        return info;
    }

    //登录身份验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        UserInfo userInfo = userInfoService.findByName(username);
        if (userInfo == null) {
            throw new UnknownAccountException();
        } else if (!password.equals(userInfo.getPassword())) {
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
