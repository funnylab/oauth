<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html >
<title></title>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Bootstrap -->
	<link href="<%=request.getContextPath()%>/resources/css/bootstrap/bootstrap.css" rel="stylesheet" media="screen">
	<style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>
	<link href="<%=request.getContextPath()%>/resources/css/bootstrap-responsive.css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap/bootstrap.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap/bootstrap-affix.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap/bootstrap-alert.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap/bootstrap-button.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap/bootstrap-carousel.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap/bootstrap-collapse.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap/bootstrap-dropdown.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap/bootstrap-modal.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap/bootstrap-popover.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap/bootstrap-scrollspy.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap/bootstrap-tab.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap/bootstrap-tooltip.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap/bootstrap-transition.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap/bootstrap-typeahead.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/jquery/jquery-2.0.3.js"></script>
</head>
<body>
<div class="navbar navbar-fixed-top">
  <div class="navbar-inner">
    <div class="container">
      <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </a>
      <a class="brand" href="index.jsp">Oauth Test</a>
      <div class="nav-collapse">
        <ul class="nav">
          <li class="active"><a href="index.jsp">Home</a></li>
        </ul>
      </div><!--/.nav-collapse -->
    </div>
  </div>
</div>
<div class="container"">
<c:url value="/j_spring_security_check" var="jssc"/>
<h1>Please Log In to Your Account</h1>
<p>
	Please use the form below to log in to your account.
</p>
<form action="${jssc}" method="post">
	<label for="j_username" class="control-label">Login</label>
	<div class="controls">
	<input id="j_username" name="j_username" size="20" maxlength="50" type="text" placeholder="User Name"/>
	</div>
	<label class="control-label" for="j_password">Password</label>
	<div class="controls">
	<input id="j_password" name="j_password" size="20" maxlength="50" type="password"  placeholder="Password"/>
	</div>
	<input type="submit" value="Login"  class="btn btn-small btn-primary"/>
</form>
</div>
</body>
</html>