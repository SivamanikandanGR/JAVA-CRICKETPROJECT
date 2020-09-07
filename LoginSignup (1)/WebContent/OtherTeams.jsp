<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String s=(String)session.getAttribute("operation1");   
//out.write(s);
%> 
 <div class="container">
      <div>
      <h3 class="about">
      <span style="font-size:120%; color:#Red;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; TeamName -</span>
      <span style="font-size:120%; color:#99ffff;"><a href=OtherTeams.jsp;> <%=s%> </a>
      </span>  
       </h3>
      </div>
      </div>
</body>
</html>