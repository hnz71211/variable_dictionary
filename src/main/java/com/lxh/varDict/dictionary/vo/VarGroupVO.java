package com.lxh.varDict.dictionary.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName: VarGroupVO
 * @Description: VarGroup vo类
 * @Author: hexli
 * @Date: 2020-01-06 
 **/
@Data
public class VarGroupVO {

  private String id;

  private String name;

  private List<String> parent;

  private String createPerson;

}
