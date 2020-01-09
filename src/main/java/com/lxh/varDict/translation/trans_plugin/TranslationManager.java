package com.lxh.varDict.translation.trans_plugin;

import com.lxh.varDict.translation.trans_plugin.trans.LANG;
import com.lxh.varDict.translation.trans_plugin.trans.Translator;
import com.lxh.varDict.translation.trans_plugin.trans.impl.BaiduTranslator;
import com.lxh.varDict.translation.trans_plugin.trans.impl.YoudaoTranslator;
import com.lxh.varDict.translation.utils.Result;

import java.util.*;

/**
 * @ClassName: TranslationManager
 * @Description: 翻译管理类
 * @Author: hexli
 * @Date: 2020-01-02 
 **/
public class TranslationManager {

  /**
   * @Title: getTranslationResults
   * @Description: 各词典翻译结果
   * @Param: [origin]
   * @Return: java.util.List<com.lxh.varDict.translation.utils.Result>
   * @Author: hexli
   * @Date: 2020-01-03 09:38
   **/
  public static List<Result> translate(String origin) {
    List<Result> list = new ArrayList<>();

    Translator translatorBaidu = new BaiduTranslator();
    Translator translatorYoudao = new YoudaoTranslator();
    Result resultBaidu = translatorBaidu.trans(LANG.ZH, LANG.EN, origin);
    Result resultYoudao = translatorYoudao.trans(LANG.ZH, LANG.EN, origin);

    list.add(resultBaidu);
    list.add(resultYoudao);

    return list;
  }
}
