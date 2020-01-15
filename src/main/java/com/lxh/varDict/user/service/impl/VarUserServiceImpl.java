package com.lxh.varDict.user.service.impl;

import com.lxh.varDict.user.entity.VarUser;
import com.lxh.varDict.user.mapper.VarUserMapper;
import com.lxh.varDict.user.service.VarUserService;
import com.lxh.varDict.user.vo.VarUserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @ClassName: VarUserServiceImpl
 * @Description:
 * @Author: hexli
 * @Date: 2020-01-15 
 **/
@Service
public class VarUserServiceImpl implements VarUserService {

  @Autowired
  private VarUserMapper varUserMapper;

  @Override
  public void insertVarUser(VarUserVO varUserVO) {
    VarUser varUser = new VarUser();
    varUser.setId(UUID.randomUUID().toString());
    BeanUtils.copyProperties(varUserVO, varUser);
    varUserMapper.insertVarUser(varUser);
  }

  @Override
  public VarUser getVarUser(String id) {
    return varUserMapper.getVarUser(id);
  }

}
