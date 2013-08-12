<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
		      <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </a>
		      <a class="brand" href="<%=request.getContextPath()%>/index.jsp">Oauth Test</a>
		      <div class="nav-collapse">
		        <ul class="nav nav-pills">
		          <li class="active"><a href="<%=request.getContextPath()%>/index.jsp">Home</a></li>
		          <li><a href="#">menu1</a></li>
		          <li><a href="#">menu2</a></li>
		          <li><a href="#">menu6</a></li>
		          <li><a href="#">menu7</a></li>
		          <li class="dropdown">
		          	<a class="dropdown-toggle" data-toggle="dropdown" href="#">
				      Dropdown <span class="caret"></span>
				    </a>
				   <ul class="dropdown-menu">
		            <li><a href="#">Action</a></li>
		            <li><a href="#">Another action</a></li>
		            <li><a href="#">Something else here</a></li>
		            <li class="divider"></li>
		            <li><a href="#">Separated link</a></li>
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
		        
		      </div><!--/.nav-collapse -->
		    </div>
	    </div>
	</div>
</div>
</body>
</html>