package com.lxh.varDict.shiro.config;

import com.lxh.varDict.shiro.entity.SysPermission;
import com.lxh.varDict.shiro.entity.SysRole;
import com.lxh.varDict.shiro.entity.SysUser;
import com.lxh.varDict.shiro.service.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


public class SysRealm extends AuthorizingRealm {

  @Autowired
  private SysUserService userService;

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    System.out.println("用户权限配置。。。。。。。。。。");
    SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
    SysUser user  = (SysUser)principals.getPrimaryPrincipal();
    for(SysRole role : user.getSysRoles()){
      authorizationInfo.addRole(role.getRoleName());
      for(SysPermission p : role.getSysPermissions()){
        authorizationInfo.addStringPermission(p.getPermission());
      }
    }
    return authorizationInfo;
  }

  //验证用户登录信息
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    System.out.println("验证用户登录信息");
    String account = (String)token.getPrincipal();
    System.out.println("登录用户名： " + account);
    System.out.println(token.getCredentials());
    SysUser user = userService.findByAccount(account);
    System.out.println("username: " + user.getAccount()+" ; password : " + user.getPassword());
    if(null == user) return null;
    SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
            user, //用户名
            user.getPassword(), //密码
            getName()  //realm name
    );
    return authenticationInfo;
  }

}