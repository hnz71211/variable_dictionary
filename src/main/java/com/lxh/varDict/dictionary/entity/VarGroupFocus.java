package com.lxh.varDict.dictionary.entity;

import lombok.Data;

import java.util.List;

/**
 * @ClassName: VarGroupFocus
 * @Description:
 * @Author: hexli
 * @Date: 2020-01-14 
 **/
@Data
public class VarGroupFocus {

  private String follower;

  private List<String> groupId;

  private Integer state;

  public VarGroupFocus(String follower, List<String> groupId, Integer state) {
    this.follower = follower;
    this.groupId = groupId;
    this.state = state;
  }
}
