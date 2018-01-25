<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <%@ page import="java.util.Enumeration" %> <!-- 백터값을 이용한 순환자. 인터페이스로 구성되어있으며 getPatameterName() 쓰기 위해 받는다. -->
   <%@ page import="java.util.Map" %>
   
   <% 
      request.setCharacterEncoding("utf-8");
   %>


<!DOCTYPE html>
<html>
   <head>
      <title>Insert title here</title>
   </head>
   <body>
      <hr color="red">
         name 파라메터 : <%= request.getParameter("name") %><br>
         address 파라메터 : <%= request.getParameter("address") %><br>
         
            
      
      <hr color="red">
      
      <br><br>
      
      <b>request.getParameterValuse(); 사용하여 처리</b>
      <br>
      
      <% 
      
         String [] values = request.getParameterValues("sport");
      
      
         if(values != null){
            for(int i = 0; i< values.length ; i++){
      %>
         <br>
         <%= values[i] %>   
      <%          
            }
         }
      %>
      
      
      <b>request.getParameterNames(); 사용하여 처리</b>
      <br><br><br>
      <%
      	//웹 브라우저에서 전송한 파라미터
         Enumeration enumData = request.getParameterNames();
     
         while(enumData.hasMoreElements()){
            
            String name = (String) enumData.nextElement();
      %>
            <%= name %>
      <% 
         }
      %>
      
      <br>
      <b>request.getParameterMap() 사용하여 처리</b>
      <br>
           
      <%
      Map paramMap = request.getParameterMap();
      
      String[] nameParam = (String[])paramMap.get("name");
      
      if(nameParam != null){
    	%>
    	
    	name = <%= nameParam[0] %>
    	 
    	<% 
      }
      %>
      
      
   </body>
</html>