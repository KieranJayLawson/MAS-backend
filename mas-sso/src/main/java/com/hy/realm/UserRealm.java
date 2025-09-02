package com.hy.realm;

import com.hy.pojo.TbUser;
import com.hy.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;//权限认证
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //登录认证
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = String.valueOf(token.getPassword());
        TbUser tbUser=userService.getUserByUsername(username);
        if(tbUser==null){
            return null;
        }
        //SimpleAuthenticationInfo sim = new SimpleAuthenticationInfo(tbUser, tbUser.getPassword(), "userRealm");
        SimpleAuthenticationInfo sim = new SimpleAuthenticationInfo(tbUser, tbUser.getPassword(), ByteSource.Util.bytes(tbUser.getSalt()), "userRealm");
        return sim;
    }
}
