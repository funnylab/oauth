package com.bluedigm.funnylab.oauth.common.tag.dao;

import java.util.List;

import com.bluedigm.funnylab.oauth.common.tag.model.CommonCode;


public interface CommonTagDao {

	List<CommonCode> getCommonCodeList(CommonCode commonCode);
}
