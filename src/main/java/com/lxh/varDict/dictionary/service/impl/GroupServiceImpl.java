package com.lxh.varDict.dictionary.service.impl;

import com.lxh.varDict.dictionary.entity.VarGroup;
import com.lxh.varDict.dictionary.mapper.GroupMapper;
import com.lxh.varDict.dictionary.service.GroupService;
import com.lxh.varDict.dictionary.vo.VarGroupVO;
import com.lxh.varDict.exception.VarAssert;
import com.lxh.varDict.exception.VarException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @ClassName: GroupServiceImpl
 * @Description:
 * @Author: hexli
 * @Date: 2020-01-14 
 **/
@Service
public class GroupServiceImpl implements GroupService {

  @Autowired
  private GroupMapper groupMapper;

  @Override
  public VarGroup queryById(String id) {
    return groupMapper.queryVarGroupsById(id);
  }

  @Override
  public void insertVarGroup(VarGroupVO varGroupVO) {
    VarGroup varGroup = new VarGroup();
    BeanUtils.copyProperties(varGroupVO, varGroup);
    varGroup.setId(UUID.randomUUID().toString());
    groupMapper.insertVarGroup(varGroup);
  }

  @Override
  public void updateVarGroup(VarGroupVO varGroupVO) throws VarException {
    VarAssert.notNull(varGroupVO.getId(), "varGroup Id is null");
    VarGroup varGroup = queryById(varGroupVO.getId());
    VarAssert.notNull(varGroup, "cannot find varGroup, id: " +varGroupVO.getId());
    BeanUtils.copyProperties(varGroupVO, varGroup);
    groupMapper.updateVarGroup(varGroup);
  }

  @Override
  public void insertVarGroupFocus(String groupId, List<String> focusList) throws VarException {
    try {
      groupMapper.insertVarGroupFocus(groupId, focusList);
    }catch (DataAccessException e) {
      throw new VarException(e.getMessage());
    }
  }

  /**
   * @Title:
   * @Description: 查询关注组
   * @Param:
   * @Return:
   * @Author: hexli
   * @Date: 2020-01-05 21:10
   **/
  private List<String> queryVarGroupFocus(String id) {
    return groupMapper.queryVarGroupFocus(id);
  }

}
