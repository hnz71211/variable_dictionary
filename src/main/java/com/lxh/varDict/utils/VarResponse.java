package com.lxh.varDict.utils;

import com.lxh.varDict.constant.Status;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;


public abstract class VarResponse extends HashMap<Object, Object> {

  private static final long serialVersionUID = 47067542629985123L;

  public VarResponse() {
    super();
  }

  public VarResponse(Map<Object, Object> map) {
    super(map);
  }

  /**
   * 返回前台成功标识
   */
  private static final String FLAG_SUCCESS = "success";

  /**
   * 返回前台警告标识
   */
  private static final String FLAG_WARN = "warn";

  /**
   * 返回前台失败标识
   */
  private static final String FLAG_FAIL = "fail";

  /**
   * 返回前台数据
   */
  protected static final String KEY_DATA = "data";

  /**
   * 返回前台成功失败标志
   */
  protected static final String KEY_FLAG = "flag";

  /**
   * 返回消息
   */
  protected static final String KEY_MSG = "msg";

  /**
   * 返回状态码
   */
  protected static final String KEY_CODE = "code";

  /**
   * 返回状态位
   */
  protected static final String KEY_STATUS = "status";

  /**
   * 设置成功标志
   * */
  protected void setSuccessFlag() {
    put(KEY_FLAG, FLAG_SUCCESS);
  }

  /**
   * 设置警告标志
   * */
  protected void setWarnFlag() {
    put(KEY_FLAG, FLAG_WARN);
  }

  /**
   * 设置失败标志
   * */
  protected void setFailFlag() {
    put(KEY_FLAG, FLAG_FAIL);
  }

  /**
   * 设置返回前台消息
   * */
  public VarResponse setMsg(String msg) {
    put(KEY_MSG, msg);
    return this;
  }

  /**
   * 获取返回前台消息
   * */
  public String getMsg() {
    if (StringUtils.isEmpty(get(KEY_MSG))) {
      return null;
    }
    return get(KEY_MSG).toString();
  }

  /**
   * 设置返回前台数据对象
   * */
  public VarResponse setData(Object dataObject) {
    put(KEY_DATA, dataObject);
    return this;
  }

  /**
   * 设置返回前台数据对象
   * */
  public Object getData() {
    return get(KEY_DATA);
  }

  /**
   * 判断是否成功
   * */
  public boolean isSuccessFlag() {
    if (StringUtils.isEmpty(get(KEY_FLAG))) {
      return false;
    }
    return FLAG_SUCCESS.equals(get(KEY_FLAG).toString());
  }

  /**
   * 状态码
   */
  public VarResponse setStatus(Status status) {
    put(KEY_CODE, status.getCode());
    put(KEY_STATUS, status.getMsg());
    return this;
  }
}
