package com.bluedigm.funnylab.oauth.common.tag;

import javax.annotation.Resource;
import javax.servlet.jsp.tagext.TagSupport;
import javax.sql.DataSource;

import com.bluedigm.funnylab.oauth.common.tag.dao.CommonTagDao;
import com.bluedigm.funnylab.oauth.common.tag.dao.impl.CommonTagDaoImpl;
import com.bluedigm.funnylab.oauth.common.tag.model.CommonCode;

public class CommonTag extends TagSupport{

	@Resource
	private CommonTagDao commonTagDao;
	
	private String id;
	private String name;
	private String inputType;
	private String groupId;
	private String firstValue;
	private String styleClass;
	private String style;
	private String firstSelectValue;
	private String orderBy;
    private CommonCode commonCode;
    
	/*public CommonTag() {
		commonTagDao = new CommonTagDaoImpl();
		
	}*/

	public int doStartTag(){
		try{
			setCommonCode();
			commonTagDao.getCommonCodeList(commonCode);
			pageContext.getOut().println("Tag Test Sample");
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return SKIP_BODY;
	}
	
	public void setCommonCode(){
		commonCode = new CommonCode();
		commonCode.setId(getId());
		commonCode.setName(getName());
		commonCode.setInputType(getInputType());
		commonCode.setGroupId(getGroupId());
		commonCode.setFirstValue(getFirstValue());
		commonCode.setStyleClass(getStyleClass());
		commonCode.setStyle(getStyle());
		commonCode.setFirstSelectValue(getFirstSelectValue());
		commonCode.setOrderBy(getOrderBy());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInputType() {
		return inputType;
	}

	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getFirstValue() {
		return firstValue;
	}

	public void setFirstValue(String firstValue) {
		this.firstValue = firstValue;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getFirstSelectValue() {
		return firstSelectValue;
	}

	public void setFirstSelectValue(String firstSelectValue) {
		this.firstSelectValue = firstSelectValue;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	
}
