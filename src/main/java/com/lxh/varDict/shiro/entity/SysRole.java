package com.lxh.varDict.shiro.entity;

import lombok.Data;

import java.util.List;

/**
 * @ClassName: SysRole
 * @Description:
 * @Author: hexli
 * @Date: 2020-01-15 
 **/
@Data
public class SysRole {

  private int id;

  private String roleName;

  private String roleDesc;

  //角色权限关系  多对多  一个角色对应多个权限
  private List<SysPermission> sysPermissions;

}
