
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

    <%@include file="MessageBox/message.jsp" %><br>
    
    FILEtype: PDF,DOC<BR>
    FILEsize: 500KB<BR>
    <form action="Resume" method="POST" enctype="multipart/form-data">
       <input type="file" name="resume" ><br>
       <input type="hidden" name="check" value="uploadresume">
       <button>upload</button>
    </form>


</body>
</html>