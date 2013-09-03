<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="currentPage"%>
<%@attribute name="totalPage"%>
<%@attribute name="pageCnt"%>
<%@attribute name="uri"%>
<div class="row">
<div class="col-md-12" style="text-align: center;">
<ul id="paging" class="pagination">
</ul>
</div>
</div>
<script type="text/javascript">
var currentPage = ${currentPage };
var totalPage = ${totalPage };
var pageCnt = ${pageCnt };
var uri = "${uri }";

$('#paging').paging({
	current:currentPage,max : totalPage ,length : pageCnt,
	onclick:function(e,page){
		$('#currentPage').val(page);
		goPage("<%=request.getContextPath()%>"+uri);
	}
});
</script>
<form id="pagination-form" method="post" action="<%=request.getContextPath()%>/provider/getProviderList.do">
<input type="hidden" id="currentPage" name="currentPage" value="${currentPage }"/>
</form>
<script type="text/javascript">
function goPage(uri){
	$("#pagination-form").attr({
		action : uri,
		method : "post"
	}).submit();
}
</script>