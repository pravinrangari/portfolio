<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css"> 
.button{
background-color: green;
color:white;
padding: 15px 32px;
font-size:25px 


}


</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: yellow;">



       <%
        String message=(String)session.getAttribute("msg");
        //out.print(message);//print on browser
        if(message!=null)
        {
       %>
         <h1 style="text-align: center; color: blue;"> <%=message%> </h1> 
       <% 
       session.removeAttribute("msg"); 
       }
       %>

	<form action="AdminLogin" method="post">
		<input type="text" name="username" placeholder="Enter username"><br>
		<input type="text" name="password" placeholder="Enter password"><br>
		 <button class="button">login</button>
	</form>

</body>
</html>