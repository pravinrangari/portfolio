%
     String login=(String)session.getAttribute("login");
     if(login==null)
     {
    	 response.sendRedirect("adminlogin.jsp");
     }
%>
<%@page import="com.model.MessagePojo"%>
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
        ReadDaoImp r=new ReadDaoImp();
        ArrayList<MessagePojo> al=r.readMessage();
        for(MessagePojo m:al)
        {
   %>
           <i>SN: <%=m.getSn()%></i><br>
           <i>Name: <%=m.getName()%></i><br>
           <i>Email: <%=m.getEmail()%></i><br>
           <i>Message: <%=m.getMessage()%></i><br>
           
           <form action="DeleteMessage" method="post">
             <input type="hidden" name="sn" value="<%=m.getSn()%>" >
           <button>delete</button>
           </form><br><br>
           
   <%
        }
   %>
</body>
</html>