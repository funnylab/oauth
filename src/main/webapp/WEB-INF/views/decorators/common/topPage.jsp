<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/common.jsp"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>

<script type="text/javascript">
$(document).ready(function() {
	$('.dropdown-toggle').dropdown();
});
</script>
</head>
<body>
<div class="container">
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
			Funney Lab Oauth Test
			</div>
		    <div class="container">
		      <a class="navbar-brand" href="<%=request.getContextPath()%>/index.jsp">Oauth Test</a>
		        <ul class="nav navbar-nav">
		          <li><a href="#">API 소개</a></li>
		          <li><a href="#">개발</a></li>
		          <li><a href="#">커뮤니티</a></li>
		          <authz:authorize ifAnyGranted="ROLE_USER">
		          <li class="dropdown">
		          	<a class="dropdown-toggle" data-toggle="dropdown" href="#">
				      마이 앱 <span class="caret"></span>
				    </a>
				   <ul class="dropdown-menu">
				   	<authz:authorize ifAllGranted="ROLE_USER">
			            <li><a href="#">앱 관리</a></li>
				   	</authz:authorize>
		            <authz:authorize ifAnyGranted="ROLE_PROVIDER,ROLE_ADMIN">
			            <li><a href="<%=request.getContextPath()%>/provider/getProviderList.do">서비스 관리</a></li>
		            </authz:authorize>
		            <authz:authorize ifAnyGranted="ROLE_USER">
		            <li class="divider"></li>
		            <li><a href="#">사용자 정보 관리</a></li>
		            </authz:authorize>
		          </ul>
		          </li>
		          </authz:authorize>
		          <authz:authorize ifNotGranted="ROLE_USER">
			          <li><a href="<%=request.getContextPath()%>/login/loginPage.do">Login</a></li>
		          </authz:authorize>
		          <authz:authorize ifAnyGranted="ROLE_USER">
		          	<li><a href="<%=request.getContextPath()%><c:url value="/logout"/>">Logout</a></li>
		          </authz:authorize>
			      <%-- <li><div style="text-align: right;">
			      <form action="<c:url value="/logout"/>">
			      	<input type="submit" value="Logout" class="btn btn-small btn-primary">
			      </form>
			      </div></li> --%>
		        </ul>
		        
		    </div>
	    </div>
	</div>
</div>