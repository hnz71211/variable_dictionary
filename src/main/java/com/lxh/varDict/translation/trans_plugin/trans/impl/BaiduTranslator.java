package com.lxh.varDict.translation.trans_plugin.trans.impl;

import com.lxh.varDict.translation.trans_plugin.constant.Parameters;
import com.lxh.varDict.translation.trans_plugin.http.HttpParams;
import com.lxh.varDict.translation.trans_plugin.http.HttpPostParams;
import com.lxh.varDict.translation.trans_plugin.trans.AbstractOnlineTranslator;
import com.lxh.varDict.translation.trans_plugin.trans.LANG;

import com.lxh.varDict.translation.utils.Result;
import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.UUID;

final public class BaiduTranslator extends AbstractOnlineTranslator {

	public BaiduTranslator(){
		langMap.put(LANG.EN, "en");
		langMap.put(LANG.ZH, "zh");
	}
	
	@Override
	public String getResponse(LANG from, LANG targ, String query) throws Exception{

		String appid = Parameters.BAIDU_APPID;
		String salt = UUID.randomUUID().toString();
		String sign = DigestUtils.md5Hex(appid + query + salt + Parameters.BAIDU_KEY);

		HttpParams params = new HttpPostParams()
						.put("from", langMap.get(from))
						.put("to", langMap.get(targ))
						.put("q", query)
						.put("appid", appid)
						.put("salt", salt)
						.put("sign", sign);

		return params.send2String("http://api.fanyi.baidu.com/api/trans/vip/translate");
	}
	
	@Override
	protected Result parseString(String jsonString){

		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		String errorCode = (String)jsonObject.get("error_code");
		if (!StringUtils.isEmpty(errorCode)) {
			return Result.getFaildResult(errorCode, getTranslatorName());
		}

		String query = (String)((JSONObject)jsonObject.getJSONArray("trans_result").get(0)).get("src");
		String target = (String)((JSONObject)jsonObject.getJSONArray("trans_result").get(0)).get("dst");
		return Result.getSuccessfulResult(query, target, getTranslatorName());
	}

	@Override
	protected String getTranslatorName() {
		return Parameters.BAIDU_NAME;
	}
}
