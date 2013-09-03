package com.bluedigm.funnylab.oauth.provider.model;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import com.bluedigm.funnylab.oauth.common.util.ConstantResource;

public class ServiceList {

	private int firstRecordIndex;
	
	private int lastRecordIndex=ConstantResource.RECODEPERPAGE;
	
	private int pageSize=ConstantResource.PAGESIZE;
	
	private int allCount;
	
	private int currentPage = 1;
	
	private int totalPage;
	
	private List<Service> service;

	public int getPageSize() {
		return pageSize;
	}

	public int getFirstRecordIndex() {
		return firstRecordIndex;
	}

	public void setFirstRecordIndex(int firstRecordIndex) {
		this.firstRecordIndex = firstRecordIndex;
	}

	public int getLastRecordIndex() {
		return lastRecordIndex;
	}

	//public void setLastRecordIndex(int lastRecordIndex) {
	//	this.lastRecordIndex = lastRecordIndex;
	//}

	public int getAllCount() {
		return allCount;
	}

	public void setAllCount(int allCount) {
		//총 페이지 갯수
		setTotalPage(((int)Math.ceil(allCount / ConstantResource.PAGESIZE))+1);
		//시작 레코드 번호
		//setFirstRecordIndex((getCurrentPage()-1)*ConstantResource.PAGESIZE);
		//마지막 레코드 번호
		//setLastRecordIndex(getFirstRecordIndex() + ConstantResource.PAGESIZE-1);
		
		this.allCount = allCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		//시작 레코드 번호
		setFirstRecordIndex((currentPage-1)*ConstantResource.PAGESIZE);
		//마지막 레코드 번호
		//setLastRecordIndex(getFirstRecordIndex() + ConstantResource.PAGESIZE-1);
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<Service> getService() {
		return service;
	}

	public void setService(List<Service> service) {
		this.service = service;
	}
}
