
<%
	String login = (String) session.getAttribute("login");
	if (login == null) {
		response.sendRedirect("adminlogin.jsp");
	}
%>
<%@page import="com.model.ProjectPojo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.ReadDaoImp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <%@include file="MessageBox/message.jsp" %>
	<%
		ReadDaoImp read = new ReadDaoImp();
		ArrayList<ProjectPojo> al = read.readProject();
		for (ProjectPojo p : al) {
	%>
	<img style="height: 120px;" src="myproject/<%=p.getFilename()%>" alt="project image">
	<form action="Project" method="post">
	   <input type="hidden" name="check" value="deleteproject">
	   <input type="hidden" name="filename" value="<%=p.getFilename()%>">
	  <button>delete</button>
	</form>
	
    <br>

	<%
		}
	%>

</body>
</html>