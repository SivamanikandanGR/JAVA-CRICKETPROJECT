<%@page import="java.awt.Window"%>
<%@ page import="java.sql.*" %>
   <%@ page import="com.cricket.util.DBconnection" %>  
    <%@ page import="java.sql.Connection" %>  
    <%@ page import="java.sql.ResultSet" %>
    <%@page import="javax.servlet.http.HttpSession"%>
    <%@page import="java.text.SimpleDateFormat" %>
    <%@page import=" java.text.ParseException" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DisplayPage</title>
<link rel="stylesheet" type="text/css" href="UserProfile.css">
<body>
<form action="DisplayProfile.jsp" method="post" name='form'>
<header id="header">
			<div id="logo">
				<h1>Contact</h1>	
			</div>
</header>
<main>
<% Connection con=DBconnection.getDBConnection(); %>
<%String name="";
String pid="";
String role="";
String nickname="";
String age="";
String birthplace="";
String battingstyle="";
String bowlingstyle="";
String wicketkeeper="";
String rating="";
String teamname="";

name=(String) session.getAttribute("name");
pid=(String) session.getAttribute("id");
role=(String) session.getAttribute("role");
System.out.println("role-"+role);
System.out.println("name-"+name);
System.out.println("pid-"+pid);
if(con!=null)
{
	try
	{
		
		Statement st = con.createStatement();
	    ResultSet rs=st.executeQuery("select name,nickname,age,birthplace,role,battingstyle,bowlingstyle,wicketkeeper,rating,ppid,TeamName from player where name='"+name+"' and role='"+role+"' ");
	    while(rs.next()) 
	    { 
	    	name=rs.getString(1);
	    	nickname=rs.getString(2);
	    	age=rs.getString(3);
	    	birthplace=rs.getString(4);
	    	role=rs.getString(5);
	    	battingstyle=rs.getString(6);
	    	bowlingstyle=rs.getString(7);
	    	wicketkeeper=rs.getString(8);
	    	rating=rs.getString(9);
	    	pid=rs.getString(10);
	    	teamname=rs.getString(11);
	    	

	        System.out.println(name+" "+nickname+" "+age+" "+birthplace+" "+role+" "+battingstyle+" "+bowlingstyle+" "+wicketkeeper+" "+rating+" "+pid+" "+teamname); 
	  	    
	   
	}
	}
		catch(Exception e)
	 	{
		System.out.println(e.toString()); 
		 }
} %>

<div class="tube">
<div class="container">
      <div class="cover-photo">
        <img src="display.png" class="profile">
      </div>
      <h1>
      <div class="profile-name">
       <span style="font-size:120%; color:#ffff80;"> <%=name%> </div></h1>
       <div class="container1">
       <h3 class="about">
       <span style="font-size:120%; color:#ffffff;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Player Id -</span>
       <span style="font-size:120%; color:#99ffff;">  <%=pid%>
       </span>
       </h3>
       <h3 class="about">
      <span style="font-size:120%; color:#ffffff;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Nick Name-</span>
      <span style="font-size:120%; color:#99ffff;"> <%=nickname%>
      </span> 
       </h3>
       <h3 class="about">
      <span style="font-size:120%; color:#ffffff;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Age -</span>
       <span style="font-size:120%; color:#99ffff;"> <%=age%>
      </span>
       </h3>
       <h3 class="about">
      <span style="font-size:120%; color:#ffffff;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Birthplace -</span>
     <span style="font-size:120%; color:#99ffff;"> <%=birthplace%>
      </span>
       </h3>
       <h3 class="about">
     <span style="font-size:120%; color:#ffffff;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Role -</span>
      <span style="font-size:120%; color:#99ffff;"> <%=role%>
      </span> 
       </h3>
       <h3 class="about">
     <span style="font-size:120%; color:#ffffff;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Battingstyle -</span>
      <span style="font-size:120%; color:#99ffff;"> <%=battingstyle%>
      </span> 
       </h3>
       <h3 class="about">
     <span style="font-size:120%; color:#ffffff;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Bowlingstyle -</span>
      <span style="font-size:120%; color:#99ffff;"> <%=bowlingstyle%>
      </span> 
       </h3>
       <h3 class="about">
     <span style="font-size:120%; color:#ffffff;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Wicketkeeper -</span>
      <span style="font-size:120%; color:#99ffff;"> <%=wicketkeeper%>
      </span> 
       </h3>
       <h3 class="about">
     <span style="font-size:120%; color:#ffffff;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Rating -</span>
      <span style="font-size:120%; color:#99ffff;"> <%=rating%>
      </span> 
       </h3>
       <h3 class="about">
     <span style="font-size:120%; color:#ffffff;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  TeamName -</span>
      <span style="font-size:120%; color:#99ffff;"> <%=teamname%>
      </span> 
       </h3>
 </div>
  </div> 
  </div>
  </main>
    </form>
    <nav id="nav">
			<div class="innertube">
				<h2>User</h2>
				<ul>
				    <li><a href="Home.jsp">Home</a></li>
					<li><a href="DisplayProfile.jsp">Player Profile</a></li>
					
				</ul>
			</div>
		</nav>
		
</body>
</html>
