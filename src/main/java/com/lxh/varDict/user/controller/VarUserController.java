package com.lxh.varDict.user.controller;

import com.lxh.varDict.common.constant.Status;
import com.lxh.varDict.common.utils.SuccessVarResponse;
import com.lxh.varDict.common.utils.VarResponse;
import com.lxh.varDict.user.entity.VarUser;
import com.lxh.varDict.user.service.VarUserService;
import com.lxh.varDict.user.vo.VarUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: VarUserController
 * @Description:
 * @Author: hexli
 * @Date: 2020-01-15 
 **/
@RestController
@RequestMapping(value = "/user")
public class VarUserController {

  @Autowired
  private VarUserService varUserService;

  @RequestMapping(value = "", method = RequestMethod.POST)
  public VarResponse insertVarUser(@RequestBody VarUserVO varUserVO) {
    varUserService.insertVarUser(varUserVO);
    return null;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public VarResponse getVarUser(@PathVariable String id) {
    VarUser varUser = varUserService.getVarUser(id);
    return new SuccessVarResponse().setStatus(Status.success).setData(varUser);
  }

}
