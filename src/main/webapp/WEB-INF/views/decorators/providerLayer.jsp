<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<!DOCTYPE html>
<!--
  - 작성자: Hyunseock Kim, Bluedigm
  - 작성일자: 2012. 03. 30
  - 설명: noleft Sitemesh Layout
  -->
<html >
<head>
<title><decorator:title default="FunneyLab Oauth" /></title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" >
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Twitter Bootstrap CSS-->
	<link href="<%=request.getContextPath()%>/resources/css/bootstrap/bootstrap.css" rel="stylesheet" media="screen">
	<style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>
	<link href="<%=request.getContextPath()%>/resources/css/bootstrap/bootstrap-responsive.css" rel="stylesheet">
	
    <!-- Jquery JS -->
    <script src="<%=request.getContextPath()%>/resources/js/jquery/jquery-2.0.3.js"></script>

    <!-- Jquery validate JS -->
    <script src="<%=request.getContextPath()%>/resources/js/jquery/additional-methods.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/jquery/jquery.validate.js"></script>

	<!-- Twitter Bootstrap JS-->
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
    
    
<decorator:head />
<!-- page script -->
</head>
<body onload="<decorator:getProperty property="body.onload" />">
<!-- [s]웹접근성 바로가기 영역06/24 -->
<%-- <div id="skip_nav">
	<a href="#wrapcont"><spring:message code="common.link.content" /></a>
	<a href="#totalmenu"><spring:message code="common.link.totalmenu" /></a>
</div> --%>
<!-- [e]웹접근성 바로가기 영역06/24 -->
	<!-- <div id="wrapbox">
		<header id="wraptop"> -->
			<!-- START:TOP Area -->
			<page:applyDecorator name="commonTop" />
			<!-- END:TOP Area -->
		<!-- </header> -->
		<div class="container" style="height: 500px;">
			<!-- START:LEFT Area -->
			<div class="row">
			<div class="col-md-2" style="margin-top: 25px;">
			<page:applyDecorator name="commonLeft" />
			</div>
			<!-- END:LEFT Area -->
			<!-- START:MAIN Area -->
			<div class="col-md-8">
			<decorator:body />
			</div>
			</div>
			<!-- END:MAIN Area -->
		</div>
		
		<!-- START:BOTTOM Area-->
			<!-- START:TOTALMENU Area -->
			<%-- <page:applyDecorator name="commonBottom" /> --%>
			<!-- END:TOTALMENU Area -->
		
			<!-- START:FOOTER Area -->
			<page:applyDecorator name="commonFooter" />
			<!-- END:FOOTER Area -->
		<!-- END:BOTTOM Area -->   
	<!-- </div> -->
</body>
</html>