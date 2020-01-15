package com.lxh.varDict.user.service;

import com.lxh.varDict.user.entity.VarUser;
import com.lxh.varDict.user.vo.VarUserVO;

public interface VarUserService {

  void insertVarUser(VarUserVO varUserVO);

  VarUser getVarUser(String id);

}
