
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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
      <%@include file="MessageBox/message.jsp" %>

     <form action="Project" method="post" enctype="multipart/form-data">
        <input type="file" name="file"><br>
        <input type="hidden" name="check" value="addproject">
        <button>upload</button>
     </form>
</body>
</html>