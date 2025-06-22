<%
     String login=(String)session.getAttribute("login");
     if(login==null)
     {
    	 response.sendRedirect("adminlogin.jsp");
     }
%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css"> 
.button{
background-color:red;
color:white;
padding: 15px 32px;
font-size:50spx;


}


</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: olive;">

    <h1><a href="readmessage.jsp" >Read Message</a></h1>
    
        <h1><a href="addproject.jsp" >add-project</a></h1>
    <h1><a href="deleteproject.jsp" >delete-project</a></h1>
         <h1>
		<a href="addedu.jsp">Add-Education</a>
	</h1>
	
	<h1>
		<a href="readedu.jsp">Read-Education</a>
	</h1>
	<h1>
		<a href="uploadresume.jsp">Upload-Resume</a>
	</h1><br>
	
       
       <form action="Logout" method="post">
       <button class=button>LOGOUT</button>
      
    </form>
</body>
</html>