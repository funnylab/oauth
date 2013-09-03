package com.bluedigm.funnylab.oauth.common.tag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedigm.funnylab.oauth.common.tag.dao.CommonTagDao;
import com.bluedigm.funnylab.oauth.common.tag.dao.impl.CommonTagDaoImpl;
import com.bluedigm.funnylab.oauth.common.tag.model.CommonCode;
import com.bluedigm.funnylab.oauth.common.tag.service.CommonTagService;

@Service
public class CommonTagServiceImpl implements CommonTagService{

	@Resource
	private CommonTagDao commonTagDao;
	
	public List<CommonCode> getCommonCodeList(CommonCode commonCode){
	    System.out.println("CommonTagServiceImpl aaaa");
		return commonTagDao.getCommonCodeList(commonCode);
	}
}
