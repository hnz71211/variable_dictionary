package com.lxh.varDict.dictionary.entity;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName: VarGroup
 * @Description: 分组类
 * @Author: hexli
 * @Date: 2020-01-05 
 **/
@Data
public class VarGroup {

  private String id;

  private String name;

  private String createUser;

  private Date createDate;

  private Integer visible;

}
