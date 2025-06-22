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