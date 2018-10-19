<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Data</title>
<style>
table#nat{
	width: 50%;
	background-color: #c48ec5;
}
</style>
</head>
<body>  
<% String id =  request.getParameter("id");
	String fname = request.getParameter("firstname");
	String lname = request.getParameter("lastname");
	String email = request.getParameter("email"); %>
<table id ="nat">
<tr>
	<td>Student ID</td>
	<td><%= id %></td>
</tr>
<tr>
	<td>First Name</td>
	<td><%= fname %></td>
</tr>
<tr>
	<td>Last Name</td>
	<td><%= lname %></td>
</tr>
<tr>
	<td>Email</td>
	<td><%= email %></td>
</tr>
</table>
</body>
</html>
