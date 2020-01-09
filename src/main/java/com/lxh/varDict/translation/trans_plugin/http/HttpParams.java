package com.lxh.varDict.translation.trans_plugin.http;

public interface HttpParams {

	String send2String(String baseUrl) throws Exception;

	HttpParams put(String key, String value);
}
