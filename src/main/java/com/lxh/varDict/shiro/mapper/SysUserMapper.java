package com.lxh.varDict.shiro.mapper;

import com.lxh.varDict.shiro.entity.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SysUserMapper {

  @Insert("INSERT INTO sys_user("
          + "id, account, password) VALUES ("
          + "#{sysUser.id}, #{sysUser.account}, #{sysUser.password})")
  void insertVarUser(SysUser sysUser);

  @Select("SELECT * FROM sys_user WHERE account = #{account}")
  SysUser getSysUserByAccount(String account);

  @Select("SELECT * FROM sys_role WHERE id = #{id}")
  SysRole getSysRoleById(Integer id);

  @Select("SELECT * FROM sys_permission WHERE id = #{id}")
  SysPermission getSysPermissionById(Integer id);

  @Select("SELECT * FROM sys_user_role WHERE uid = #{uid}")
  List<SysUserRole> getSysUserRoleByUid(Integer uid);

  @Select("SELECT * FROM sys_role_permission WHERE rid = #{rid}")
  List<SysRolePermission> getSysRolePermission(Integer rid);

}
