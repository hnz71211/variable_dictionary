package com.lxh.varDict.shiro.service;

import com.lxh.varDict.shiro.entity.SysUser;
import com.lxh.varDict.shiro.vo.SysUserVO;

public interface SysUserService {

  void insertSysUser(SysUserVO varUserV);

  SysUser findByAccount(String account);
}
