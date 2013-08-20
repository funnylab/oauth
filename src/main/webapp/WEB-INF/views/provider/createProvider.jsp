<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html >
<title></title>
<head>
<script type="text/javascript">
$(document).ready(function(){
	 $('#provider-form').validate({
	  rules: {
		  serviceName: {
	      minlength: 3,
	      required: true
	    },
	    serviceDesc: {
	      required: true
	    }
	  },
	  highlight: function(element) {
	    $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
	  },
	  success: function(element) {
	    element
	    .closest('.form-group').removeClass('has-error').addClass('has-success');
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
    <label for="serviceName" class="col-lg-2 control-label">서비스 명</label>
    <div class="col-lg-10">
      <input type="text" class="form-control" id="serviceName" name="serviceName" placeholder="서비스 이름을 입력합니다.">
      <input type="text" style="display: none;" />
    </div>
  </div>
  <div class="form-group">
    <label for="serviceDesc" class="col-lg-2 control-label">서비스 설명</label>
    <div class="col-lg-10">
      <textarea  type="text" class="form-control" id="serviceDesc" name="serviceDesc" rows="3" placeholder="서비스 설명을 입력합니다."></textarea>
    </div>
  </div>
  <!-- <div class="form-group">
    <label for="resourceId" class="col-lg-2 control-label">리소스 ID</label>
    <div class="col-lg-10">
      <input type="text" class="form-control" id=""serviceName"" placeholder="리소스 ID를 입력합니다.">
    </div>
  </div> -->
  <div class="form-group">
  	<label for="resourceId" class="col-lg-2 control-label">Scope</label>
    <div class="col-lg-10">
		<label class="checkbox-inline">
			<input type="checkbox" id="scopeRead" value="Y" checked="checked"> Read
		</label>
		<label class="checkbox-inline">
			<input type="checkbox" id="scopeWrite" value="Y"  checked="checked"> Wirte
		</label>
    </div>
  </div>
  <div class="form-group">
  	<label for="authGrantType" class="col-lg-2 control-label">Grant Types</label>
	<div class="col-lg-10">
		<label class="checkbox-inline">
			<input id="implicit" type="checkbox" value="Y"> implicit
		</label>
		<label class="checkbox-inline">
			<input id="authorization_code" type="checkbox" value="Y"> authorization_code
		</label>
	</div>
  </div>
  <div class="form-group">
  	<label for="refreshToken" class="col-lg-2 control-label">Refresh Token</label>
	<div class="col-lg-10">
		<label class="checkbox-inline">
			<input id="refreshToken" type="checkbox" value="Y"> Use the Refresh Token 
		</label>
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
