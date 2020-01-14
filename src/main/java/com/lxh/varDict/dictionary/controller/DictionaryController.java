package com.lxh.varDict.dictionary.controller;

import com.lxh.varDict.constant.Status;
import com.lxh.varDict.dictionary.service.DictionaryService;
import com.lxh.varDict.dictionary.vo.VarGroupVO;
import com.lxh.varDict.exception.VarException;
import com.lxh.varDict.utils.FailVarResponse;
import com.lxh.varDict.utils.VarResponse;
import com.lxh.varDict.utils.SuccessVarResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: DictionaryController
 * @Description:
 * @Author: hexli
 * @Date: 2019-12-31 
 **/
@RestController
@RequestMapping(value = "/dictionary")
public class DictionaryController {

  @Autowired
  private DictionaryService dictionaryService;

  @RequestMapping(value = "/insert", method = RequestMethod.POST)
  public void insertVarGroup(@RequestBody VarGroupVO varGroupVO) {
    dictionaryService.insertVarGroup(varGroupVO);
  }

  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public VarResponse updateVarGroup(@RequestBody VarGroupVO varGroupVO) {
    try {
      dictionaryService.updateVarGroup(varGroupVO);
      return new SuccessVarResponse().setStatus(Status.update_success).setMsg("success ...");
    }catch (VarException e) {
      return new FailVarResponse().setStatus(Status.update_fail).setMsg(e.getMessage());
    }catch (Exception e) {
      return new FailVarResponse().setStatus(Status.update_fail);
    }
  }


}
