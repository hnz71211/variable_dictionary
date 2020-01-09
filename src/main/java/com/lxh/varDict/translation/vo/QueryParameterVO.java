package com.lxh.varDict.translation.vo;

import com.lxh.varDict.translation.constant.VarCase;
import lombok.Data;

/**
 * @ClassName: QueryParameterVO
 * @Description:
 * @Author: hexli
 * @Date: 2020-01-03 
 **/
@Data
public class QueryParameterVO {

  private String origin;

  private VarCase varCase;

  private String prefix;

  private String suffix;


}
