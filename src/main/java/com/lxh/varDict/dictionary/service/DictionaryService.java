package com.lxh.varDict.dictionary.service;

import com.lxh.varDict.dictionary.entity.VarGroup;
import com.lxh.varDict.dictionary.vo.VarGroupVO;
import com.lxh.varDict.exception.VarException;

import java.util.UUID;

/**
 * @ClassName: DictionaryService
 * @Description:
 * @Author: hexli
 * @Date: 2019-12-31 
 **/
public interface DictionaryService {

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

}
