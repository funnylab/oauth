<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html >
<head>
<title></title>
<script type="text/javascript">
	$(document).ready(function() {
		
		$("#list").click(function() {
			$("#listForm").attr({
				action : "<%=request.getContextPath()%>/my-center/board/contact-us/",
				method : "post"
			}).submit();
		});
		
		
	});
	
	function goDetailPage(serviceId) {
		$("#serviceId").val(serviceId);
		
		$("#detailPage-form").attr({
			action : "<%=request.getContextPath()%>/provider/getProvider.do",
			method : "post"
		}).submit();
	}
</script>
</head>
<body>
<p class="text-right">aaaa  >  bbb  >   asdf</p>
<div class="page-header">
  <h3 id="tables">ProviderList</h3>
</div>
<table class="table table-hover">
  <thead>
    <tr>
      <th>No.</th>
      <th>Service Name</th>
      <th>Service Desc</th>
      <th>Create Date</th>
    </tr>
  </thead>
  <tbody>
    <c:if test="${providers.service != null}">
  	<c:forEach var="provider" items="${providers.service }" varStatus="status">
    <tr onclick="javascript:goDetailPage(${provider.serviceId});">
      <td><div class="text-oversize1">${((providers.currentPage*providers.pageSize)-providers.pageSize)+ status.count}</div></td>
      <td><div class="text-oversize3">${provider.serviceName }</div></td>
      <td><div class="text-oversize7">${provider.serviceDesc }</div></td>
      <td><div class="text-oversize2"><fmt:formatDate value="${provider.createDateTime }" pattern="yyyy-MM-dd" var="date"/>${date }</div></td>
    </tr>
  	</c:forEach>
  	</c:if>
  </tbody>
</table>
<tag:pagination currentPage="${providers.currentPage }" totalPage="${providers.totalPage }" pageCnt="${providers.pageSize }" uri="/provider/getProviderList.do"/>
<p class="text-right">
<a href="<%=request.getContextPath()%>/provider/createProvider.do" class="btn btn-primary">등록</a>
</p>
<form id="detailPage-form">
<input id="serviceId" type="hidden" name="serviceId"/>
</form>
</body>
</html>
