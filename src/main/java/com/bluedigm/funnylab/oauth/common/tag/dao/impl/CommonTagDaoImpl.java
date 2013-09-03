package com.bluedigm.funnylab.oauth.common.tag.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bluedigm.funnylab.oauth.common.dao.impl.GenericDaoImpl;
import com.bluedigm.funnylab.oauth.common.tag.dao.CommonTagDao;
import com.bluedigm.funnylab.oauth.common.tag.model.CommonCode;

@Repository
public class CommonTagDaoImpl extends GenericDaoImpl< CommonCode, Integer> implements CommonTagDao{

	public List<CommonCode> getCommonCodeList(CommonCode commonCode){
		System.out.println("CommonTagDaoImpl aaaaa");
		return selectList("com.bliedigm.funnylab.oauth.commonTag.selectCommonCodeList", commonCode);
	}
}
