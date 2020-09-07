<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
    <%@ page import="java.sql.Connection" %>  
    <%@ page import="java.sql.ResultSet" %>
    <%@page import="javax.servlet.http.HttpSession"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete contact</title>
<link rel="stylesheet" type="text/css" href="mainstyle.css">	
<%session.setAttribute("add","delete"); %>		
<form  action="PlayerServlet" method="post">
<header id="header">
			<div id="logo">
				<h1>Contact</h1>
			</div>
</header>
	<nav id="nav">
			<div class="innertube">
				<h2>User</h2>
				<ul>
					<li><a href="Home.jsp">Home</a></li>
					
				</ul>
			</div>
</nav>
<main>

<div class="tube">
<div class="form-style-2">
<div class="form-style-2-heading">Delete Contact</h2></div>
<label><span>Player ID: <font color="red"></font></span>
<input type="text" class="input-field" name="name" id="number"></label>
 <div class="button"><input type="submit"   value="Delete" />
<input type="button" onclick="window.location.href='Home.jsp'" value="Cancel"/></label></div>
</div>
</main>
</body>
</html>
 
 

