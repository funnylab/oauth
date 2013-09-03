<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="grantTypes" type="java.lang.Object"%>
<c:set var="grantYn" value="0"/>
<div class="checkbox">
<label class="checkbox-inline">
	<c:if test="${grantTypes != null }">
	<c:forEach items="${grantTypes }" var="grantType">
		<c:if test="${grantType.grantType == 'implicit' }"	>
		<input id="implicitUseYn" type="checkbox" name="grantTypes" value="implicit" checked="checked" disabled> implicit
		<c:set var="grantYn" value="1"/>
		</c:if>
	</c:forEach>
	</c:if>
	<c:if test="${grantTypes == null }">
	<input id="implicitUseYn" type="checkbox" name="grantTypes" value="implicit"> implicit
	</c:if>
	<c:if test="${grantTypes != null && grantYn == '0' }">
	<input id="implicitUseYn" type="checkbox" name="grantTypes" value="implicit" disabled> implicit
	</c:if>
</label>
</div>
<c:set var="grantYn" value="0"/>
<div class="checkbox">
<label class="checkbox-inline">
	<c:if test="${grantTypes != null }">
	<c:forEach items="${grantTypes }" var="grantType">
		<c:if test="${grantType.grantType == 'authorization_code' }"	>
		<input id="authorizationCodeUseYn" type="checkbox" name="grantTypes" value="authorization_code" checked="checked" disabled> authorization_code
		<c:set var="grantYn" value="1"/>
		</c:if>
	</c:forEach>
	</c:if>
	<c:if test="${grantTypes == null }">
	<input id="authorizationCodeUseYn" type="checkbox" name="grantTypes" value="authorization_code"> authorization_code
	</c:if>
	<c:if test="${grantTypes != null && grantYn == '0' }">
	<input id="authorizationCodeUseYn" type="checkbox" name="grantTypes" value="authorization_code" disabled> authorization_code
	</c:if>
</label>
</div>
<c:set var="grantYn" value="0"/>
<div class="checkbox">
<label class="checkbox-inline">
	<c:if test="${grantTypes != null }">
	<c:forEach items="${grantTypes }" var="grantType">
		<c:if test="${grantType.grantType == 'client_credentials' }"	>
		<input id="clientCredentialsYn" type="checkbox" name="grantTypes" value="client_credentials" checked="checked" disabled> client_credentials
		<c:set var="grantYn" value="1"/>
		</c:if>
	</c:forEach>
	</c:if>
	<c:if test="${grantTypes == null}">
	<input id="clientCredentialsYn" type="checkbox" name="grantTypes" value="client_credentials"> client_credentials
	</c:if>
	<c:if test="${grantTypes != null && grantYn == '0' }">
	<input id="clientCredentialsYn" type="checkbox" name="grantTypes" value="client_credentials" disabled> client_credentials
	</c:if>
</label>
</div>
<label for="grantTypes" class="error"></label>