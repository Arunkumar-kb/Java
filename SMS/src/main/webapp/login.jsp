<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel='stylesheet' href='style.css'>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class='container'>
<div class='sign-in'>
student login form
<form action="signin" method="get">
rollno : <input type="text" name="rollno"><br>
password : <input type="password" name="pwd"><br>
<input type="submit" value="login">

<%-- Retrieve the error parameter from the URL --%>
<% String errorMessage = request.getParameter("error"); %>

<%-- If there is an error message, display it --%>
<% if (errorMessage != null) { %>
    <p style="color: red;"><%= errorMessage %></p>
<% } %>

<a href="signup.jsp">Register now....</a>
</form>
</div>
</div>
</body>
</html>