package com.lxh.varDict.shiro.controller;

import com.lxh.varDict.shiro.entity.SysPermission;
import com.lxh.varDict.shiro.entity.SysRole;
import com.lxh.varDict.shiro.entity.SysUser;
import com.lxh.varDict.shiro.service.SysUserService;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ClassName: SysUserController
 * @Description:
 * @Author: hexli
 * @Date: 2020-01-15 
 **/
@RestController
@RequestMapping()
public class SysUserController {

  @Autowired
  private SysUserService userService;

  @RequestMapping({"/","/index"})
  public String root(){
    return "index";
  }

  @RequestMapping("/login")
  public String login(HttpServletRequest request, Map<String ,String> map){
    System.out.println("user login .....");
    String exception = (String) request.getAttribute("shiroLoginFailure");
    System.out.println("exception=" + exception);
    String msg = "";
    if (exception != null) {
      if (UnknownAccountException.class.getName().equals(exception)) {
        System.out.println("UnknownAccountException -- > 账号不存在：");
        msg = "UnknownAccountException -- > 账号不存在：";
      } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
        System.out.println("IncorrectCredentialsException -- > 密码不正确：");
        msg = "IncorrectCredentialsException -- > 密码不正确：";
      } else if ("kaptchaValidateFailed".equals(exception)) {
        System.out.println("kaptchaValidateFailed -- > 验证码错误");
        msg = "kaptchaValidateFailed -- > 验证码错误";
      } else {
        msg = "else >> "+exception;
        System.out.println("else -- >" + exception);
      }
    }
    map.put("msg", msg);
    return "login.html";
  }

  @RequestMapping("/permission")
  @ResponseBody
  public String findPermission(){
    String account = "admin";
    SysUser user = userService.findByAccount(account);
    for (SysRole r : user.getSysRoles()){
      System.out.println(r.getRoleName());
      for (SysPermission p : r.getSysPermissions()){
        System.out.println(p.getPermission());
      }
    }
    return "successful";
  }

}
