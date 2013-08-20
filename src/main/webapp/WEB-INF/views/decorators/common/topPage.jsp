<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/common.jsp"%>
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
		          <li class="dropdown">
		          	<a class="dropdown-toggle" data-toggle="dropdown" href="#">
				      마이 앱 <span class="caret"></span>
				    </a>
				   <ul class="dropdown-menu">
		            <li><a href="#">앱 관리</a></li>
		            <li><a href="<%=request.getContextPath()%>/provider/getProviderList.do">프로바이더 관리</a></li>
		            <li class="divider"></li>
		            <li><a href="#">사용자 정보 관리</a></li>
		          </ul>
		          </li>
		          <li><a href="<%=request.getContextPath()%>/login/loginPage.do">Login</a></li>
		          <li><a href="<%=request.getContextPath()%><c:url value="/logout"/>">Logout</a></li>
			      <%-- <li><div style="text-align: right;">
			      <form action="<c:url value="/logout"/>">
			      	<input type="submit" value="Logout" class="btn btn-small btn-primary">
			      </form>
			      </div></li> --%>
		          <li class="dropdown"> 
		        </ul>
		        
		    </div>
	    </div>
	</div>
</div>