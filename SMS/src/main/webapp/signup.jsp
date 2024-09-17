<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<jsp:include page="index.jsp"></jsp:include>
<form action="Register" method="get">
<div class="container">
<div class="signup">
<div class="title">
<h3>Register</h3>
</div>

<div class="i-filed">
<label>user name :</label> 
<input type="text" name="uname">
</div>
<div class="i-filed">
<label>email : </label>
<input type="email" name="email">
</div>
<div class="i-filed">
<label>password :</label>
<input type="password" name="pwd">
</div>
<div class="btn">
<input type="submit" value="Sign-up">
</div>
<div class="msg">
<% String errorMessage = request.getParameter("error"); %>
<% if (errorMessage != null) { %>
    <p style="color: red;"><%= errorMessage %></p>
<% } %>

<a href = "login.jsp">Already have an account ?</a>
</div>
</div>
</div>
</form>
</body>
</html>