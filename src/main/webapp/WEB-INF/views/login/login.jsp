<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html >
<title></title>
<head>
</head>
<body>
<div class="container" style="height: 500px;">
<c:url value="/j_spring_security_check" var="jssc"/>
<h1>Please Log In to Your Account</h1>
<p>
	Please use the form below to log in to your account.
</p>
<form action="${jssc}" method="post">
	<label for="j_username" class="control-label">Login</label>
	<div class="controls">
	<input id="j_username" name="j_username" size="20" maxlength="50" type="text" placeholder="User Name" value="admin"/>
	</div>
	<label class="control-label" for="j_password">Password</label>
	<div class="controls">
	<input id="j_password" name="j_password" size="20" maxlength="50" type="password"  placeholder="Password" value="1234"/>
	</div>
	<input type="submit" value="Login"  class="btn btn-small btn-primary"/>
</form>
</div>
</body>
</html>
