package com.lxh.varDict.common.constant;

/**
 * 使用枚举统一定义异常码和异常信息
 * 规则：业务模块编码+错误操作信息
 *
 * @author hexli
 */
public enum Status {

  /* 正常*/
  success(200, "成功"),
  fail(-1, "失败"),

  system_error(1000, "系统内部错误"),

  save_success(111, "保存成功"),
  save_fail(101, "保存成功"),
  update_success(112, "更新成功"),
  update_fail(102, "更新失败"),

  /*系统级错误*/
  base_param_err(10001, "参数错误"),
  base_id_err(10002, "无效id"),
  base_server_exception(10002, "服务端异常"),
  base_get_fail(10003, "获取数据失败"),
  base_save_fail(10004, "保存数据失败"),
  base_del_fail(10005, "删除数据失败"),
  base_upd_fail(10006, "更新数据失败 "),
  base_not_found(10007, "未找到记录"),
  base_method_err(10008, "不存在的方法名"),
  base_service_unavailabe(10009, "不存在的方法名");

  private int code;

  private String msg;

  private Status(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public int getCode() {
    return this.code;
  }

  public String getMsg() {
    return this.msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}