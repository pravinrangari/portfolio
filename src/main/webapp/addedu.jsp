<%
	String login = (String) session.getAttribute("login");
	if (login == null) {
		response.sendRedirect("adminlogin.jsp");
	}
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	 <%@include file="MessageBox/message.jsp" %>
    
    <form action="Education" method="post">
      <input type="number" name="year" placeholder="year"><br>
      <input type="text" name="title" placeholder="title"><br>
      <input type="text" name="subtitle" placeholder="subtitle"><br>
      <input type="text" name="description" placeholder="description"><br>
      <input type="hidden" name="check" value="addedu" placeholder="description"><br>
      <button>add</button>
    </form>
</body>
</html>