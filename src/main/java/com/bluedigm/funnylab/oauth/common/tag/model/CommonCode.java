package com.bluedigm.funnylab.oauth.common.tag.model;

public class CommonCode {

	private String name;
	private String id;
	private String inputType;
	private String groupId;
	private String firstValue;
	private String styleClass;
	private String style;
	private String firstSelectValue;
	private String orderBy;
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
	@Override
	public String toString() {
		return "CommonCode [name=" + name + ", id=" + id + ", inputType="
				+ inputType + ", groupId=" + groupId + ", firstValue="
				+ firstValue + ", styleClass=" + styleClass + ", style="
				+ style + ", firstSelectValue=" + firstSelectValue
				+ ", orderBy=" + orderBy + "]";
	}
	
	
}
