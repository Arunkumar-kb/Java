<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>welcome</title>
</head>
<body>
<%
if(session.getAttribute("Email")==null){
	response.sendRedirect("login.jsp");
}
%>
<jsp:include page="index.jsp"></jsp:include>
<h1>Login successfully</h1>
</body>
</html>