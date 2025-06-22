<%
     String login=(String)session.getAttribute("login");
     if(login==null)
     {
    	 response.sendRedirect("adminlogin.jsp");
     }
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.model.EducationPojo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.ReadDaoImp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    
      <%@include file="MessageBox/message.jsp" %>

                   <%
                        ReadDaoImp read=  new ReadDaoImp();
                        ArrayList<EducationPojo> al1=read.readEducation();
                        for(EducationPojo edu:al1)
                        {
                    %>
                        <div class="timeline-wrapper">
                             <div class="timeline-yr">
                              SN:     <span><%=edu.getSn()%></span><br>
                              Year:    <span><%=edu.getYear()%></span>
                             </div>
                             <div class="timeline-info">
                                  <h3><span><%=edu.getTitle()%>&nbsp;&nbsp;&nbsp;&nbsp;</span><small><%=edu.getSubtitle()%></small></h3>
                                  <p><%=edu.getDescription()%></p>
                             </div>
                        </div>
                        <form action="Education" method="post">
                           <input type="hidden" name="sn" value="<%=edu.getSn()%>">
                           <input type="hidden" name="check" value="deleteedu">
                           <button>delete</button>
                        </form><br>
                         <form action="updateedu.jsp" method="post">
                           <input type="hidden" name="sn" value="<%=edu.getSn()%>">
                           <input type="hidden" name="year" value="<%=edu.getYear()%>">
                           <input type="hidden" name="title" value="<%=edu.getTitle()%>">
                           <input type="hidden" name="subtitle" value="<%=edu.getSubtitle()%>">
                           <input type="hidden" name="description" value="<%=edu.getDescription()%>">
                           <button>Update</button>
                        </form><br>
                        
                        ========================================
                        
                        <%} %>
</body>
</html>