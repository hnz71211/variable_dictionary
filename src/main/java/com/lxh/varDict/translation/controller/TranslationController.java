package com.lxh.varDict.translation.controller;

import com.lxh.varDict.translation.entity.VariableResult;
import com.lxh.varDict.translation.service.TranslationService;
import com.lxh.varDict.translation.vo.QueryParameterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: TranslationController
 * @Description:
 * @Author: hexli
 * @Date: 2019-12-31 
 **/
@RestController
@RequestMapping(value = "/translation")
public class TranslationController {

  @Autowired
  private TranslationService translationService;

  @RequestMapping(value = "/query/{origin}", method = RequestMethod.GET)
  public List<VariableResult> query(@PathVariable(value = "origin") String origin) {
    return translationService.getVariableResults(origin);
  }

  @RequestMapping(value = "/query", method = RequestMethod.POST)
  public List<VariableResult> queryPost(@RequestParam(value = "origin") String origin) {
    return translationService.getVariableResults(origin);
  }

  @RequestMapping(value = "/getVariable", method = RequestMethod.POST)
  public List<VariableResult> getVariable(@RequestBody QueryParameterVO queryParameterVO) {
    return translationService.getVariableResults(queryParameterVO);
  }

}
