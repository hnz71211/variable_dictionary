package com.lxh.varDict.translation.transCase_plugin;

import com.lxh.varDict.translation.constant.Cons;
import com.lxh.varDict.translation.vo.QueryParameterVO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: TransCaseManager
 * @Description: 转换成指定命名规则管理类
 * @Author: hexli
 * @Date: 2020-01-04 
 **/
public class TransCaseManager {

  public static String getVariable(String translation, QueryParameterVO queryParameterVO) {

    translation = new StringBuffer().append(queryParameterVO.getPrefix()) //前缀
            .append(Cons.SPACE)
            .append(translation)
            .append(Cons.SPACE)
            .append(queryParameterVO.getSuffix()).toString()  // 后缀
            .trim()
            .toLowerCase()
            .replaceAll(Cons.DASH, Cons.SPACE); // 去-

    switch (queryParameterVO.getVarCase()) {
    case CAMELCASE:
      return camelCase(translation);
    case UPPERCASE:
      return upperCase(translation);
    case UNDERLINECASE:
      return underlineCase(translation);
    case UPPERUNDERLINECASE:
      return upperUnderlineCase(translation);
    }

    return translation;
  }

  private static String upperCase(String translation) {
    return translation.toUpperCase()
            .replaceAll(Cons.SPACE, Cons.NULLSPACE);
  }

  private static String upperUnderlineCase(String translation) {
    return translation.toUpperCase().replaceAll(Cons.SPACE, Cons.UNDERLINE);
  }

  private static String camelCase(String translation) {
    translation = wordToUpperCase(translation)
            .replaceAll(Cons.SPACE, Cons.NULLSPACE);
    return translation.substring(0, 1).toLowerCase() + translation.substring(1);
  }

  private static String underlineCase(String translation) {
    return translation.replaceAll(Cons.SPACE, Cons.UNDERLINE);
  }

  /**
   * 完成单词首字母大写功能
   * @param str 原始字符串集合
   * @return	处理后的字符串结果
   */
  private static String wordToUpperCase(String str) {
    StringBuffer stringbf = new StringBuffer();
    Matcher m = Pattern.compile("([a-z])([a-z]*)", Pattern.CASE_INSENSITIVE).matcher(str);
    while (m.find()) {
      m.appendReplacement(stringbf, m.group(1).toUpperCase() + m.group(2).toLowerCase());
    }
    return m.appendTail(stringbf).toString();
  }

}
