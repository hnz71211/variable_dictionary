package com.lxh.varDict.dictionary.controller;

import com.lxh.varDict.constant.Status;
import com.lxh.varDict.dictionary.service.DictionaryService;
import com.lxh.varDict.dictionary.service.GroupService;
import com.lxh.varDict.dictionary.vo.VarGroupFocusVO;
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
  private GroupService groupService;
  @Autowired
  private DictionaryService dictionaryService;

  @RequestMapping(value = "/varGroup", method = RequestMethod.POST)
  public void insertVarGroup(@RequestBody VarGroupVO varGroupVO) {
    groupService.insertVarGroup(varGroupVO);
  }

  @RequestMapping(value = "/varGroup", method = RequestMethod.PUT)
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

  @RequestMapping(value = "/varGroupFocus", method = RequestMethod.POST)
  public VarResponse addVarGroupFocus(@RequestBody VarGroupFocusVO varGroupFocusVO) {
    String follower = "";
    try {
      groupService.insertVarGroupFocus(follower, varGroupFocusVO.getGroupIds());
      return new SuccessVarResponse().setStatus(Status.save_success);
    }catch (VarException e) {
      return new FailVarResponse().setStatus(Status.save_fail).setMsg(e.getMessage());
    }catch (Exception e) {
      return new FailVarResponse().setStatus(Status.save_fail);
    }
  }

  @RequestMapping(value = "/varGroupFocus/{varGroupId}/focus/{focusId}", method = RequestMethod.DELETE)
  public VarResponse removeGroupFocus(@PathVariable String varGroupId, @PathVariable String focusId) {
    groupService.deleteVarGroupFocus(varGroupId, focusId);
    return null;
  }


}
