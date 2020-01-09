package com.lxh.varDict.translation.service.impl;

import com.lxh.varDict.translation.entity.VariableResult;
import com.lxh.varDict.translation.service.TranslationService;
import com.lxh.varDict.translation.transCase_plugin.TransCaseManager;
import com.lxh.varDict.translation.trans_plugin.TranslationManager;
import com.lxh.varDict.translation.utils.Result;
import com.lxh.varDict.translation.vo.QueryParameterVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: TranslationServiceImpl
 * @Description:
 * @Author: hexli
 * @Date: 2019-12-31 
 **/
@Service
public class TranslationServiceImpl implements TranslationService {

  @Override
  public List<VariableResult> getVariableResults(String origin) {
    List<Result> translatorResults = TranslationManager.translate(origin);

    List<VariableResult> variableResults = new ArrayList<>();

    translatorResults.stream().forEach(translatorResult -> {
      if (translatorResult.getStatus() != -1) {
        variableResults.add(new VariableResult(translatorResult.getQuery(), translatorResult.getTarget()));
      }
    });

    return variableResults;
  }

  @Override
  public List<VariableResult> getVariableResults(QueryParameterVO queryParameterVO) {
    List<Result> translatorResults = TranslationManager.translate(queryParameterVO.getOrigin());

    List<VariableResult> variableResults = new ArrayList<>();

    translatorResults.forEach(translatorResult -> {
      String variable = TransCaseManager.getVariable(translatorResult.getTarget(), queryParameterVO);
      variableResults.add(new VariableResult(translatorResult.getQuery(), variable));
    });

    return variableResults;
  }

}
