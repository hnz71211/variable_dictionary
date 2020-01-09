package com.lxh.varDict.translation.entity;

import lombok.Data;

/**
 * @ClassName: VariableResult
 * @Description:
 * @Author: hexli
 * @Date: 2020-01-03 
 **/
@Data
public class VariableResult {

  private String origin;

  private String variableName;

  public VariableResult(String origin, String variableName) {
    this.origin = origin;
    this.variableName = variableName;
  }
}
