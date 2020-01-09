package com.lxh.varDict.dictionary.entity;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

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

  private String parent;

  private String createPerson;

  private Date createDate;

}
