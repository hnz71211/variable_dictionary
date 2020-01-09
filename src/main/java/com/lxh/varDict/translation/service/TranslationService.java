package com.lxh.varDict.translation.service;

import com.lxh.varDict.translation.entity.VariableResult;
import com.lxh.varDict.translation.utils.Result;
import com.lxh.varDict.translation.vo.QueryParameterVO;

import java.util.List;

/**
 * @ClassName: TranslationService
 * @Description:
 * @Author: hexli
 * @Date: 2019-12-31 
 **/
public interface TranslationService {

  /**
   * @Title: getTranslationResults
   * @Description: 获得变量名
   * @Param: [origin]
   * @Return: java.util.List<com.lxh.varDict.translation.utils.Result>
   * @Author: hexli
   * @Date: 2020-01-03 09:38
   **/
  List<VariableResult> getVariableResults(String origin);

  /**
   * @Title: getVariableResults
   * @Description: 获得变量名
   * @Param: [queryParameterVO]
   * @Return: java.util.List<com.lxh.varDict.translation.entity.VariableResult>
   * @Author: hexli
   * @Date: 2020-01-04 09:51
   **/
  List<VariableResult> getVariableResults(QueryParameterVO queryParameterVO);

}
