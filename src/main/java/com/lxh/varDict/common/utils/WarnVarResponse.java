package com.lxh.varDict.common.utils;

import java.util.Map;

/**
 * 返回前台警告对象
 */
public class WarnVarResponse extends VarResponse {

  private static final long serialVersionUID = -3435256799895340269L;

  public WarnVarResponse() {
    super();
    setWarnFlag();
  }

  public WarnVarResponse(Map<Object, Object> map) {
    super(map);
    setWarnFlag();
  }

}
