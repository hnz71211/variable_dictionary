package com.lxh.varDict.shiro.entity;

import lombok.Data;

import java.util.List;

/**
 * @ClassName: SysPermission
 * @Description:
 * @Author: hexli
 * @Date: 2020-01-15 
 **/
@Data
public class SysPermission {

  private int id;

  private String permission;

  private String url;

  //角色权限关系   多对多
  private List<SysRole> sysRoles;

}
