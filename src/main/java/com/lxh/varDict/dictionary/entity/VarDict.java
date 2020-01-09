package com.lxh.varDict.dictionary.entity;

import lombok.Data;

import java.util.UUID;

/**
 * @ClassName: VarDict
 * @Description:
 * @Author: hexli
 * @Date: 2020-01-05 
 **/
@Data
public class VarDict {

  private String id;

  private String origin;

  private String translation;

  private String groupId;

}
