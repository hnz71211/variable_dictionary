package com.lxh.varDict.utils;

import java.util.Map;

/**
 * 返回前台成功对象
 */
public class SuccessVarResponse extends VarResponse {

  private static final long serialVersionUID = -2395996558104816956L;

  public SuccessVarResponse() {
    super();
    setSuccessFlag();
  }

  public SuccessVarResponse(Map<Object, Object> map) {
    super(map);
    setSuccessFlag();
  }

}
