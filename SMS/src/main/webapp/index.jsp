<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
<link rel='stylesheet' href='style.css'>
</head>
<body>
	<nav class="nav-bar">
		<div class="logo">the american college</div>
		<ul class="nav-links">
			<li><a href="#">Home</a></li>
			<li><a href="welcome.jsp">About</a></li>
			<li><a href="#">Services</a></li>
			<%if(session.getAttribute("Email")==null){%>
				<li><a href="login.jsp">Login</a></li>
			<%} else {%>
				<li><a href="logout.jsp">Logout</a></li>
				
			<%}%>
		</ul>
	</nav>
</body>
</html>