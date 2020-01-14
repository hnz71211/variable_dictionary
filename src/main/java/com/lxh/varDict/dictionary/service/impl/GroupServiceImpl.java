package com.lxh.varDict.dictionary.service.impl;

import com.lxh.varDict.dictionary.entity.VarGroup;
import com.lxh.varDict.dictionary.entity.VarGroupFocus;
import com.lxh.varDict.dictionary.mapper.GroupMapper;
import com.lxh.varDict.dictionary.service.GroupService;
import com.lxh.varDict.dictionary.vo.VarGroupVO;
import com.lxh.varDict.exception.VarAssert;
import com.lxh.varDict.exception.VarException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
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
  @Transactional(rollbackFor = { Exception.class })
  public void insertVarGroup(VarGroupVO varGroupVO) {
    VarGroup varGroup = new VarGroup();
    String groupId = UUID.randomUUID().toString();
    BeanUtils.copyProperties(varGroupVO, varGroup);
    varGroup.setId(groupId);
    groupMapper.insertVarGroup(varGroup);

    VarGroupFocus varGroupFocus =
            new VarGroupFocus("",
                    Arrays.asList(new String[]{groupId}),
                    1);
    groupMapper.insertVarGroupFocus(varGroupFocus);
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
  public void insertVarGroupFocus(String follower, List<String> groupIds) throws VarException {
    VarGroupFocus varGroupFocus =
            new VarGroupFocus("",
                    groupIds,
                    null);
    try {
      groupMapper.insertVarGroupFocus(varGroupFocus);
    }catch (DataAccessException e) {
      throw new VarException(e.getMessage());
    }
  }

  @Override
  public void deleteVarGroupFocus(String follower, String groupId) {
    groupMapper.deleteVarGroupFocus(follower, groupId);
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
