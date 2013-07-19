<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html >
<title></title>
<head>
<authz:authorize ifAllGranted="ROLE_USER">
    <script type='text/javascript'>
      function pictureDisplay(json) {
        for (var i = 0; i < json.photos.length; i++) {
          var photo = json.photos[i];
          document.write('<img src="photos/photos/' + photo.id + '" alt="' + photo.name + '">');
        }
      }
    </script>
  </authz:authorize>
</head>
<body>
<h2>Hello World!</h2>


<a href="login/loginPage.do">Login</a>


<a href="test/testPage.do">Test</a>

<br>
<authz:authorize ifAllGranted="ROLE_USER">
      <div style="text-align: center"><form action="<c:url value="/logout"/>"><input type="submit" value="Logout"></form></div>
      
      <h2>Your Photos</h2>

      <p>
        <script type='text/javascript' src='photos?callback=pictureDisplay&format=json'></script>
      </p>
    </authz:authorize>
</body>
</html>
