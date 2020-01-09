package com.lxh.varDict.translation.utils;

import com.lxh.varDict.translation.trans_plugin.constant.Parameters;
import lombok.Data;

/**
 * @ClassName: Result
 * @Description:
 * @Author: hexli
 * @Date: 2020-01-02 
 **/
@Data
public class Result {

  private String query;

  private String target;

  private String translator;

  /**
   * 状态 失败：-1
   */
  private int status;

  private String message;

  private Result(){

  }

  public static Result getFaildResult(String message, String translator) {
    Result result = new Result();
    result.setStatus(Parameters.QUERY_RESULT_STATUS_FAILD);
    result.setMessage(message);
    result.setTranslator(translator);
    return result;
  }

  public static Result getSuccessfulResult(String query, String target, String translator) {
    Result result = new Result();
    result.setQuery(query);
    result.setTarget(target);
    result.setTranslator(translator);
    return result;
  }

}
