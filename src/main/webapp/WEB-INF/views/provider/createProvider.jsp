<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html >
<title></title>
<head>
<script type="text/javascript">
$(document).ready(function(){

	$('#provider-form').validate({
	  rules: {
		  serviceName: {
	      minlength: 5,
	      required: true,
	      lettersonly : true
	    },
	    serviceDesc: {
	    	required: true
	    },
	    scope: {
	    	required: true,
	    	dashunderline: true,
	    	commaseparted : true
	    }
	    ,
	    grantTypes: {
	    	requireleastone: true
	    }
	  },
	  highlight: function(element) {
	    $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
	  },
	  success: function(element) {
	    element.closest('.form-group').removeClass('has-error').addClass('has-success');
	    //.text('OK!').addClass('valid')
	  }
	 });
	
});
</script>
</head>
<body>
<h2>Provider Service 등록</h2>
<form id="provider-form" class="form-horizontal" role="form" method="post" action="<%=request.getContextPath()%>/provider/createProvider.do">
  <div class="form-group">
    <label for="serviceName" class="col-lg-2 control-label">Service Name</label>
    <div class="col-lg-6">
      <input type="text" class="form-control" id="serviceName" name="serviceName" placeholder="Service Name">
      <input type="text" style="display: none;" />
    </div>
  </div>
  <div class="form-group">
    <label for="serviceDesc" class="col-lg-2 control-label">Service Desc</label>
    <div class="col-lg-6">
      <textarea  type="text" class="form-control" id="serviceDesc" name="serviceDesc" rows="3" placeholder="Service Desc"></textarea>
    </div>
  </div>
  <div class="form-group">
  	<label for="scope" class="col-lg-2 control-label">Scope</label>
    <div class="col-lg-6">
      <textarea  type="text" class="form-control" id="scope" name="scope" rows="3" placeholder="Scope List(Comma-separted)"></textarea>
      <p class="help-block">Comma-separted list of string. ex>read_article,update_profile</p>
    </div>
  </div>
  <div class="form-group">
  	<label for="authGrantType" class="col-lg-2 control-label">Grant Types</label>
	<div class="col-lg-5">
		<tag:granttype />
	</div>
  </div>
  <div class="form-group">
  	<label for="refreshToken" class="col-lg-2 control-label">Refresh Token</label>
	<div class="col-lg-6">
	<div class="checkbox">
		<label class="checkbox-inline">
			<input id="refreshTokenUseYn" type="checkbox" name="refreshTokenUseYn" value="Y"> Use the Refresh Token 
		</label>
	</div>
	</div>
  </div>
  <div class="form-group">
    <div class="col-lg-offset-2 col-lg-10">
      <p class="text-right"><button type="submit" class="btn btn-primary">저장</button>
      <a href="<%=request.getContextPath()%>/provider/getProviderList.do" class="btn btn-primary">취소</a>
      </p>
    </div>
  </div>
</form>
</body>
</html>
