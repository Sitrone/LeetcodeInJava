<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World JSP</title>
</head>
<body>
	<h2>Welcome to JSP tutorial</h2>
	<p>
		It is
		<%=new Date().toString() %>
	</p>
	  <h2>JSP Built-in Objects</h2>

  User Agent: <%=request.getHeader("User-Agent") %> <br/><br/>

  User Language: <%=request.getLocale() %> <br/><br/>
  
    <%
  out.println("User Agent: " + request.getHeader("User-Agent") + "<br/><br/>");
  out.println("User Language: " + request.getLocale() + "<br/><br/>");
  %>

</body>
</html>
