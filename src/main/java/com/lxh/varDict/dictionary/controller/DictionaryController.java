package com.lxh.varDict.dictionary.controller;

import com.lxh.varDict.constant.Status;
import com.lxh.varDict.dictionary.service.DictionaryService;
import com.lxh.varDict.dictionary.service.GroupService;
import com.lxh.varDict.dictionary.vo.VarGroupVO;
import com.lxh.varDict.exception.VarException;
import com.lxh.varDict.utils.FailVarResponse;
import com.lxh.varDict.utils.VarResponse;
import com.lxh.varDict.utils.SuccessVarResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
  private GroupService groupService;
  @Autowired
  private DictionaryService dictionaryService;

  @RequestMapping(value = "/insert", method = RequestMethod.POST)
  public void insertVarGroup(@RequestBody VarGroupVO varGroupVO) {
    groupService.insertVarGroup(varGroupVO);
  }

  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public VarResponse updateVarGroup(@RequestBody VarGroupVO varGroupVO) {
    try {
      groupService.updateVarGroup(varGroupVO);
      return new SuccessVarResponse().setStatus(Status.update_success).setMsg("success ...");
    }catch (VarException e) {
      return new FailVarResponse().setStatus(Status.update_fail).setMsg(e.getMessage());
    }catch (Exception e) {
      return new FailVarResponse().setStatus(Status.update_fail);
    }
  }

  @RequestMapping(value = "/varGroupFocus", method = RequestMethod.GET)
  public VarResponse addVarGroupFocus() {
    String groupId = UUID.randomUUID().toString();
    List<String> focusList = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      focusList.add(UUID.randomUUID().toString());
    }
    try {
      groupService.insertVarGroupFocus(groupId, focusList);
      return new SuccessVarResponse().setStatus(Status.save_success);
    }catch (VarException e) {
      return new FailVarResponse().setStatus(Status.save_fail).setMsg(e.getMessage());
    }catch (Exception e) {
      return new FailVarResponse().setStatus(Status.save_fail);
    }
  }


}
