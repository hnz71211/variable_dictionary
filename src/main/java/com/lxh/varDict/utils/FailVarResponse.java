package com.lxh.varDict.utils;

import java.util.Map;

/**
 * 返回前台失败对象
 * */
public class FailVarResponse extends VarResponse {

  private static final long serialVersionUID = -2485130096025044970L;

  public FailVarResponse() {
    super();
    setFailFlag();
  }

  public FailVarResponse(Map<Object, Object> map) {
    super(map);
    setFailFlag();
  }

}
