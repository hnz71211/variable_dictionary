package com.lxh.varDict.translation.trans_plugin.trans;

import com.lxh.varDict.translation.utils.Result;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractOnlineTranslator implements Translator {
	protected Map<LANG, String> langMap = new HashMap<>();					//语言映射，由子类完成
	
	@Override
	final public Result trans(LANG from, LANG targ, String query) {
		try {
			String response = getResponse(from, targ, query);
			return parseString(response);
		}catch (Exception e) {
			return Result.getFaildResult(e.getMessage(), getTranslatorName());
		}
	}
	
	abstract protected String getResponse(LANG from, LANG targ, String query) throws Exception;
	abstract protected Result parseString(String jsonString);
	abstract protected String getTranslatorName();
}
