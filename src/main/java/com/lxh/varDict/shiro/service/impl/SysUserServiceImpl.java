package com.lxh.varDict.shiro.service.impl;

import com.lxh.varDict.shiro.entity.*;
import com.lxh.varDict.shiro.service.SysUserService;
import com.lxh.varDict.shiro.mapper.SysUserMapper;
import com.lxh.varDict.shiro.vo.SysUserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName: SysUserServiceImpl
 * @Description:
 * @Author: hexli
 * @Date: 2020-01-15 
 **/
@Service
public class SysUserServiceImpl implements SysUserService {

  @Autowired
  private SysUserMapper sysUserMapper;

  @Override
  public void insertSysUser(SysUserVO sysUserVO) {
    SysUser sysUser = new SysUser();
    BeanUtils.copyProperties(sysUserVO, sysUser);
    sysUserMapper.insertVarUser(sysUser);
  }

  @Override
  public SysUser findByAccount(String account) {

    SysUser user = sysUserMapper.getSysUserByAccount(account);
    if (user == null) {
      return null;
    }

    List<SysUserRole> sysUserRoles = sysUserMapper.getSysUserRoleByUid(user.getId());
    if (CollectionUtils.isEmpty(sysUserRoles)) {
      return user;
    }

    List<SysRole> sysRoles = new ArrayList<>();
    for (SysUserRole userRole : sysUserRoles) {
      SysRole sysRole = sysUserMapper.getSysRoleById(userRole.getId());
      if (sysRole == null) continue;

      sysRoles.add(sysRole);

      List<SysRolePermission> sysRolePermissions = sysUserMapper.getSysRolePermission(sysRole.getId());
      if (CollectionUtils.isEmpty(sysRolePermissions)) continue;

      List<SysPermission> sysPermissions = new ArrayList<>();
      for (SysRolePermission rolePermission : sysRolePermissions) {
        SysPermission sysPermission = sysUserMapper.getSysPermissionById(rolePermission.getPid());
        if (sysPermission == null) continue;

        sysPermissions.add(sysPermission);
      }
      sysRole.setSysPermissions(sysPermissions);
    }
    user.setSysRoles(sysRoles);

    return user;
  }

}
