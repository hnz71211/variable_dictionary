package com.lxh.varDict.dictionary.service.impl;

import com.lxh.varDict.dictionary.mapper.DictionaryMapper;
import com.lxh.varDict.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: DictionaryServiceImpl
 * @Description:
 * @Author: hexli
 * @Date: 2019-12-31 
 **/
@Service
public class DictionaryServiceImpl implements DictionaryService {

  @Autowired
  private DictionaryMapper dictionaryMapper;


}
