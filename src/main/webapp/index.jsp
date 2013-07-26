<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<authz:authorize ifAllGranted="ROLE_USER">
    <script type='text/javascript'>
      function pictureDisplay(json) {
        for (var i = 0; i < json.photos.length; i++) {
          var photo = json.photos[i];
          document.write('<img src="photos/photos/' + photo.id + '" alt="' + photo.name + '">');
        }
      }
      $('.dropdown-toggle').dropdown();
    </script>
  </authz:authorize>
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
          <authz:authorize ifNotGranted="ROLE_USER" >
          <li><a href="login/loginPage.do">Login</a></li>
          </authz:authorize>
        </ul>
      </div><!--/.nav-collapse -->
    </div>
  </div>
</div>
<div class="container"">

<br>
<authz:authorize ifAllGranted="ROLE_USER">
      <div style="text-align: right;">
      <form action="<c:url value="/logout"/>">
      	<input type="submit" value="Logout" class="btn btn-small btn-primary">
      </form>
      </div>
</authz:authorize>
<h2>Your Photos</h2>
<authz:authorize ifAllGranted="ROLE_USER">
      <p>
        <script type='text/javascript' src='photos?callback=pictureDisplay&format=json'></script>
      </p>
</authz:authorize>
    
    
<br><br><br><br><br>
<!-- bootStrap Test -->
<h3>Twitter bootStrap Test Sample</h3>
<a href="http://twitter.github.io/bootstrap/index.html" target="new">http://twitter.github.io/bootstrap/index.html</a>
<p>
  <button class="btn btn-large btn-primary" type="button">Large button</button>
  <button class="btn btn-large" type="button">Large button</button>
</p>
<p>
  <button class="btn btn-primary" type="button">Default button</button>
  <button class="btn" type="button" v>Default button</button>
</p>
<p>
  <button class="btn btn-small btn-primary" type="button">Small button</button>
  <button class="btn btn-small" type="button">Small button</button>
</p>
<p>
  <button class="btn btn-mini btn-primary" type="button">Mini button</button>
  <button class="btn btn-mini" type="button">Mini button</button>
</p>

<img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIwAAACMCAYAAACuwEE+AAADgUlEQVR4Xu3XbU4bARAD0HI3js2ZuEIrkJAilI81VpUEv/4sM9qM/boNL+/v73//+COBgwm8AHMwKWOfCQADQpQAMFFchoFhIEoAmCguw8AwECUATBSXYWAYiBIAJorLMDAMRAkAE8VlGBgGogSAieIyDAwDUQLARHEZBoaBKAFgorgMA8NAlAAwUVyGgWEgSgCYKC7DwDAQJQBMFJdhYBiIEgAmisswMAxECQATxWUYGAaiBICJ4jIMDANRAsBEcRkGhoEoAWCiuAwDw0CUADBRXIaBYSBKAJgoLsPAMBAlAEwUl2FgGIgSACaKyzAwDEQJABPFZRgYBqIEgIniMgwMA1ECwERxGQaGgSgBYKK4DAPDQJQAMFFchoFhIEoAmCguw8AwECUATBSXYWAYiBIAJorLMDAMRAkAE8VlGBgGogSAieIyDAwDUQLARHEZfnowb29vny2+vr6ebfPcz7/+7mvh0u4lHvd45qNQfWowp8WfK/3cz7+Xfav870Xd45mPguXjczw1mI8DrhX+P8Dc65mPgubXgrn03861N8zRt88lpD955qNAOPo5gDn5DgTMbTa/Esxp8bcQXPr5tS/E175If3yXSp95u6bHmQDmzG9Zt74IA/M4gONPcuTX5tO3xdF//T99w3w/4MgbJz76jgu/8g1zmudRIEmx6Rvo1me4Y//xo+fAnP5a/P0tcrTYFMy1Z8aN3Xnh6cHcOb+5xwMzV3l3MDBdfnPbwMxV3h0MTJff3DYwc5V3BwPT5Te3Dcxc5d3BwHT5zW0DM1d5dzAwXX5z28DMVd4dDEyX39w2MHOVdwcD0+U3tw3MXOXdwcB0+c1tAzNXeXcwMF1+c9vAzFXeHQxMl9/cNjBzlXcHA9PlN7cNzFzl3cHAdPnNbQMzV3l3MDBdfnPbwMxV3h0MTJff3DYwc5V3BwPT5Te3Dcxc5d3BwHT5zW0DM1d5dzAwXX5z28DMVd4dDEyX39w2MHOVdwcD0+U3tw3MXOXdwcB0+c1tAzNXeXcwMF1+c9vAzFXeHQxMl9/cNjBzlXcHA9PlN7cNzFzl3cHAdPnNbQMzV3l3MDBdfnPbwMxV3h0MTJff3DYwc5V3BwPT5Te3Dcxc5d3BwHT5zW0DM1d5dzAwXX5z28DMVd4dDEyX39w2MHOVdwcD0+U3tw3MXOXdwcB0+c1tAzNXeXfwP3/PI6YsZPANAAAAAElFTkSuQmCC" class="img-rounded">
<img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIwAAACMCAYAAACuwEE+AAADgUlEQVR4Xu3XbU4bARAD0HI3js2ZuEIrkJAilI81VpUEv/4sM9qM/boNL+/v73//+COBgwm8AHMwKWOfCQADQpQAMFFchoFhIEoAmCguw8AwECUATBSXYWAYiBIAJorLMDAMRAkAE8VlGBgGogSAieIyDAwDUQLARHEZBoaBKAFgorgMA8NAlAAwUVyGgWEgSgCYKC7DwDAQJQBMFJdhYBiIEgAmisswMAxECQATxWUYGAaiBICJ4jIMDANRAsBEcRkGhoEoAWCiuAwDw0CUADBRXIaBYSBKAJgoLsPAMBAlAEwUl2FgGIgSACaKyzAwDEQJABPFZRgYBqIEgIniMgwMA1ECwERxGQaGgSgBYKK4DAPDQJQAMFFchoFhIEoAmCguw8AwECUATBSXYWAYiBIAJorLMDAMRAkAE8VlGBgGogSAieIyDAwDUQLARHEZfnowb29vny2+vr6ebfPcz7/+7mvh0u4lHvd45qNQfWowp8WfK/3cz7+Xfav870Xd45mPguXjczw1mI8DrhX+P8Dc65mPgubXgrn03861N8zRt88lpD955qNAOPo5gDn5DgTMbTa/Esxp8bcQXPr5tS/E175If3yXSp95u6bHmQDmzG9Zt74IA/M4gONPcuTX5tO3xdF//T99w3w/4MgbJz76jgu/8g1zmudRIEmx6Rvo1me4Y//xo+fAnP5a/P0tcrTYFMy1Z8aN3Xnh6cHcOb+5xwMzV3l3MDBdfnPbwMxV3h0MTJff3DYwc5V3BwPT5Te3Dcxc5d3BwHT5zW0DM1d5dzAwXX5z28DMVd4dDEyX39w2MHOVdwcD0+U3tw3MXOXdwcB0+c1tAzNXeXcwMF1+c9vAzFXeHQxMl9/cNjBzlXcHA9PlN7cNzFzl3cHAdPnNbQMzV3l3MDBdfnPbwMxV3h0MTJff3DYwc5V3BwPT5Te3Dcxc5d3BwHT5zW0DM1d5dzAwXX5z28DMVd4dDEyX39w2MHOVdwcD0+U3tw3MXOXdwcB0+c1tAzNXeXcwMF1+c9vAzFXeHQxMl9/cNjBzlXcHA9PlN7cNzFzl3cHAdPnNbQMzV3l3MDBdfnPbwMxV3h0MTJff3DYwc5V3BwPT5Te3Dcxc5d3BwHT5zW0DM1d5dzAwXX5z28DMVd4dDEyX39w2MHOVdwcD0+U3tw3MXOXdwcB0+c1tAzNXeXfwP3/PI6YsZPANAAAAAElFTkSuQmCC" class="img-circle">
<img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIwAAACMCAYAAACuwEE+AAADgUlEQVR4Xu3XbU4bARAD0HI3js2ZuEIrkJAilI81VpUEv/4sM9qM/boNL+/v73//+COBgwm8AHMwKWOfCQADQpQAMFFchoFhIEoAmCguw8AwECUATBSXYWAYiBIAJorLMDAMRAkAE8VlGBgGogSAieIyDAwDUQLARHEZBoaBKAFgorgMA8NAlAAwUVyGgWEgSgCYKC7DwDAQJQBMFJdhYBiIEgAmisswMAxECQATxWUYGAaiBICJ4jIMDANRAsBEcRkGhoEoAWCiuAwDw0CUADBRXIaBYSBKAJgoLsPAMBAlAEwUl2FgGIgSACaKyzAwDEQJABPFZRgYBqIEgIniMgwMA1ECwERxGQaGgSgBYKK4DAPDQJQAMFFchoFhIEoAmCguw8AwECUATBSXYWAYiBIAJorLMDAMRAkAE8VlGBgGogSAieIyDAwDUQLARHEZfnowb29vny2+vr6ebfPcz7/+7mvh0u4lHvd45qNQfWowp8WfK/3cz7+Xfav870Xd45mPguXjczw1mI8DrhX+P8Dc65mPgubXgrn03861N8zRt88lpD955qNAOPo5gDn5DgTMbTa/Esxp8bcQXPr5tS/E175If3yXSp95u6bHmQDmzG9Zt74IA/M4gONPcuTX5tO3xdF//T99w3w/4MgbJz76jgu/8g1zmudRIEmx6Rvo1me4Y//xo+fAnP5a/P0tcrTYFMy1Z8aN3Xnh6cHcOb+5xwMzV3l3MDBdfnPbwMxV3h0MTJff3DYwc5V3BwPT5Te3Dcxc5d3BwHT5zW0DM1d5dzAwXX5z28DMVd4dDEyX39w2MHOVdwcD0+U3tw3MXOXdwcB0+c1tAzNXeXcwMF1+c9vAzFXeHQxMl9/cNjBzlXcHA9PlN7cNzFzl3cHAdPnNbQMzV3l3MDBdfnPbwMxV3h0MTJff3DYwc5V3BwPT5Te3Dcxc5d3BwHT5zW0DM1d5dzAwXX5z28DMVd4dDEyX39w2MHOVdwcD0+U3tw3MXOXdwcB0+c1tAzNXeXcwMF1+c9vAzFXeHQxMl9/cNjBzlXcHA9PlN7cNzFzl3cHAdPnNbQMzV3l3MDBdfnPbwMxV3h0MTJff3DYwc5V3BwPT5Te3Dcxc5d3BwHT5zW0DM1d5dzAwXX5z28DMVd4dDEyX39w2MHOVdwcD0+U3tw3MXOXdwcB0+c1tAzNXeXfwP3/PI6YsZPANAAAAAElFTkSuQmCC" class="img-polaroid">

<div id="navbar-example" class="navbar navbar-static">
	<div class="navbar-inner">
		 <div class="container" style="width: auto;">
		      <a class="brand" href="#">Project Name</a>
		      <ul class="nav" role="navigation">
		        <li class="dropdown">
		          <a id="drop1" href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
		          <ul class="dropdown-menu" role="menu" aria-labelledby="drop1">
		            <li role="presentation"><a role="menuitem" tabindex="-1" href="http://google.com">Action</a></li>
		            <li role="presentation"><a role="menuitem" tabindex="-1" href="#anotherAction">Another action</a></li>
		            <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Something else here</a></li>
		            <li role="presentation" class="divider"></li>
		            <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Separated link</a></li>
		          </ul>
		        </li>
		        <li class="dropdown">
		          <a href="#" id="drop2" role="button" class="dropdown-toggle" data-toggle="dropdown">Dropdown 2 <b class="caret"></b></a>
		          <ul class="dropdown-menu" role="menu" aria-labelledby="drop2">
		            <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Action</a></li>
		            <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another action</a></li>
		            <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Something else here</a></li>
		            <li role="presentation" class="divider"></li>
		            <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Separated link</a></li>
		          </ul>
		        </li>
		      </ul>
		      <ul class="nav pull-right">
		        <li id="fat-menu" class="dropdown">
		          <a href="#" id="drop3" role="button" class="dropdown-toggle" data-toggle="dropdown">Dropdown 3 <b class="caret"></b></a>
		          <ul class="dropdown-menu" role="menu" aria-labelledby="drop3">
		            <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Action</a></li>
		            <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another action</a></li>
		            <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Something else here</a></li>
		            <li role="presentation" class="divider"></li>
		            <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Separated link</a></li>
		          </ul>
		        </li>
		      </ul>
		    </div>
		  </div>
	</div>

<div class="pagination">
  <ul>
    <li><a href="#">Prev</a></li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li><a href="#">Next</a></li>
  </ul>
</div>
</div>
</body>
</html>
