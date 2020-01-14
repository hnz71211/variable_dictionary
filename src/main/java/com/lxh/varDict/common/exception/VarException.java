package com.lxh.varDict.common.exception;

/**
 * @ClassName: VarException
 * @Description: 自定义异常类
 * @Author: hexli
 * @Date: 2020-01-06 
 **/
public class VarException extends Exception {

  private static final long serialVersionUID = 5163133108708260135L;

  protected String message = null;

  protected String msgDetail = null;

  public VarException() {
    super();
  }

  public VarException(String message, Throwable cause) {
    super(message, cause);
    this.message = message;
  }

  public VarException(String message) {
    super(message);
    this.message = message;
  }

  public VarException(Throwable cause) {
    super(cause);
  }

  /**
   * 获取异常提示信息
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * 设置异常提示信息
   * @param message the message
   */
  public void setMessage(String message) {
    this.message = message;
  }

  public String getMsgDetail() {
    return msgDetail;
  }

  public VarException setMsgDetail(String msgDetail) {
    this.msgDetail = msgDetail;
    return this;
  }
}
