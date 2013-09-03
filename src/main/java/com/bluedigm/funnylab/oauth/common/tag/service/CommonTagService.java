package com.bluedigm.funnylab.oauth.common.tag.service;

import java.util.List;

import com.bluedigm.funnylab.oauth.common.tag.model.CommonCode;

public interface CommonTagService {
	List<CommonCode> getCommonCodeList(CommonCode commonCode);
}
