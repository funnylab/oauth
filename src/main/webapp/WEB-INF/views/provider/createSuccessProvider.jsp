<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html >
<title></title>
<head>
<script>
  $(function() {
	  $('#myModal').on('hidden.bs.modal', function () {
			location.href="<%=request.getContextPath()%>/provider/getProviderList.do";
		});
	  $('#myModal').modal({
		  keyboard: false
		})
  });
  </script>
</head>
<body>
<!-- Modal -->
  <div class="modal" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <c:if test="${empty type || type !='modify' }">
          <h4 class="modal-title">프로바이더 서비스 등록 성공</h4>
          </c:if>
          <c:if test="${type =='modify' }">
          <h4 class="modal-title">프로바이더 서비스 변경 성공</h4>
          </c:if>
        </div>
        <div class="modal-body">
          <c:if test="${empty type || type !='modify' }">
          	프로바이더 서비스 등록 성공 하엿습니다.
          </c:if>
          <c:if test="${type =='modify' }">
          	프로바이더 서비스 변경 성공 하엿습니다.
          </c:if>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
  </div><!-- /.modal -->
</body>
</html>
