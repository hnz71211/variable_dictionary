package com.lxh.varDict.dictionary.service;

import com.lxh.varDict.dictionary.entity.VarGroup;
import com.lxh.varDict.dictionary.vo.VarGroupVO;
import com.lxh.varDict.exception.VarException;

import java.util.List;

public interface GroupService {
  /**
   * @Title: queryById
   * @Description:
   * @Param: [id]
   * @Return: com.lxh.varDict.dictionary.entity.VarGroup
   * @Author: hexli
   * @Date: 2020-01-05 21:09
   **/
  VarGroup queryById(String id);

  /**
   * @Title: insertVarGroup
   * @Description: 新增分组数据
   * @Param: [varGroup]
   * @Return: void
   * @Author: hexli
   * @Date: 2020-01-05 21:08
   **/
  void insertVarGroup(VarGroupVO varGroupVO);

  /**
   * @Title: updateVarGroupParent
   * @Description:
   * @Param: [varGroup]
   * @Return: void
   * @Author: hexli
   * @Date: 2020-01-05 21:50
   **/
  void updateVarGroup(VarGroupVO varGroupVO) throws VarException;

  /**
   * @Title: insertVarGroupFocus
   * @Description: 添加关注
   * @Param: [groupId, focusList]
   * @Return: void
   * @Author: hexli
   * @Date: 2020-01-14 11:14
   **/
  void insertVarGroupFocus(String groupId, List<String> focusList) throws VarException;
}