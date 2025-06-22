
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
   
   <%
    String sn=request.getParameter("sn");
	String year = request.getParameter("year");
	String title = request.getParameter("title");
	String subtitle = request.getParameter("subtitle");
	String description = request.getParameter("description");
      
   %>
   <form action="Education" method="post">
   <fieldset>
      <legend>Update Form</legend>
      <input type="text" value="<%=year%>" name="year" placeholder="year"><br>
      <input type="text" value="<%=title%>" name="title" placeholder="title"><br>
      <input type="text" value="<%=subtitle%>" name="subtitle" placeholder="subtitle"><br>
      <textarea name="description" rows="10" cols="50"><%=description%></textarea>
      <input type="hidden" name="check" value="updateedu" placeholder="description"><br>
      <input type="hidden" name="sn" value="<%=sn%>" placeholder="description"><br>
      <button>update</button>
   </fieldset>
   </form>

</body>
</html>