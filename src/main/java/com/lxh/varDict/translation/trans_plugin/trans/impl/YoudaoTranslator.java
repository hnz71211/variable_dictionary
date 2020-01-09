package com.lxh.varDict.translation.trans_plugin.trans.impl;

import com.lxh.varDict.translation.trans_plugin.constant.Parameters;
import com.lxh.varDict.translation.trans_plugin.http.HttpParams;
import com.lxh.varDict.translation.trans_plugin.http.HttpPostParams;
import com.lxh.varDict.translation.trans_plugin.trans.AbstractOnlineTranslator;
import com.lxh.varDict.translation.trans_plugin.trans.LANG;

import com.lxh.varDict.translation.utils.Result;
import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.UUID;

final public class YoudaoTranslator extends AbstractOnlineTranslator {

	public YoudaoTranslator(){
		langMap.put(LANG.EN, "EN");
		langMap.put(LANG.ZH, "ZH_CN");
	}
	
	@Override
	protected String getResponse(LANG from, LANG targ, String query) throws Exception{

		String appKey = Parameters.YOUDAO_APPKEY;
		String salt = UUID.randomUUID().toString();
		int queryLength = query.length();
		String input = queryLength <= 20 ?
						query : query.substring(0, 10) + queryLength + query.substring(queryLength - 10, queryLength);
		String timeStamp = String.valueOf(System.currentTimeMillis() / 1000);
		String sign = DigestUtils.sha256Hex(appKey + input + salt + timeStamp + Parameters.YOUDAO_KEY);

		HttpParams params = new HttpPostParams()
						.put("q", query)
						.put("from", langMap.get(from))
						.put("to", langMap.get(targ))
						.put("appKey", appKey)
						.put("salt", salt)
						.put("sign", sign)
						.put("signType", "v3")
						.put("curtime", timeStamp);

		return params.send2String("https://openapi.youdao.com/api");
	}
	
	@Override
	protected Result parseString(String jsonString){

		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		String errorCode = (String)jsonObject.get("errorCode");
		if (!"0".equals(errorCode)) {
			return Result.getFaildResult(errorCode, getTranslatorName());
		}

		String query = (String)jsonObject.get("query");
		String target = (String) jsonObject.getJSONArray("translation").get(0);
		return Result.getSuccessfulResult(query, target, getTranslatorName());
	}

	@Override
	protected String getTranslatorName() {
		return Parameters.YOUDAO_NAME;
	}
}
