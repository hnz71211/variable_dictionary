/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @Package: com.ufgov.ga.api.constant
 * @author: lvxr
 * @date: 2018年10月10日 下午3:11:30 
 */

package com.lxh.varDict.common.constant;

/**
 * @ClassName: ResultFlagStr
 * @Description: TODO
 * @author: hexli
 * @date: 2020年1月6日 下午7:25:30
 */
public enum ResultFlagStr {

  SUCCESS("SUCCESS"),
  ERROR("ERROR"),
  WARNING("WARNING");

  private String name;

  private ResultFlagStr(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public String toString() {
    return this.name;
  }

}
