package com.lxh.varDict.translation.trans_plugin.trans;

import com.lxh.varDict.translation.utils.Result;

public interface Translator {

	Result trans(LANG from, LANG targ, String query);

}
