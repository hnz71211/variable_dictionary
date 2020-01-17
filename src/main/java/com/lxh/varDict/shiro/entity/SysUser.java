package com.lxh.varDict.shiro.entity;

import lombok.Data;

import java.util.List;

/**
 * @ClassName: SysUser
 * @Description: 用户实体类
 * @Author: hexli
 * @Date: 2020-01-15 
 **/
@Data
public class SysUser {

  private int id;

  private String account;

  private String password;

  //用户的角色   一对多关系
  private List<SysRole> sysRoles;

}
