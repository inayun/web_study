<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, memberone.*" %>    
    
    <!-- 데이터베이스에서 데이터 가져올 코드 -->
    
<jsp:useBean id="dao" class="memberone.StudentDAO" />

<%

	request.setCharacterEncoding("utf-8");
	String check = request.getParameter("check");
	String dong = request.getParameter("dong");
	
	Vector<ZipcodeVO> zipcodeList = dao.zipcodeRead(dong);
	int totalList = zipcodeList.size();
%>    
    
<!DOCTYPE html>
<html>
<head>
<title> 우편번호 검색 </title>
<link href="stylesheet.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="script.js"></script>
</head>
<body bgcolor="#FFFFCC">
<center>

	<b>우편번호 찾기</b>
	
	<form name="zipForm" method="post" action="zipCheck.jsp">
		<table>
			<tr>
				<td>동 이름 입력 : <input name="dong" type="text">
					<input type="button" value="검색" onclick="dongCheck()">
				 </td>
			</tr>		
		</table>
		
		<input type="hidden" name="check" value="n">
	</form>

	<table>
	
	<%
		if(check.equals("n")){
	%>		
		<%
			if(zipcodeList.isEmpty()){
		%>
		<tr>
			<td align="center">검색된 결과가 없습니다.</td>
		</tr>
		
		<% 
			} else {
		%>		
		
		<tr>
			<td align="center">검색 후 아래 우편번호를 클릭하면 자동으로 입력됩니다.</td>
		</tr>
		
		
		<%
		
			for(int i = 0; i<totalList; i++){
				
				ZipcodeVO vo = zipcodeList.elementAt(i);
				String tempZipcode = vo.getZipcode();
				String tempSido = vo.getSido();
				String tempGugun = vo.getGugun();
				String tempDong = vo.getDong();
				String tempRi = vo.getRi();
				String tempBunji = vo.getBunji();
				
				if(tempRi == null) tempRi="";
				if(tempBunji == null) tempBunji ="";
		
		%>
		
		<tr>
			<td>
			
				<a href="javascript:sendAddress(
				'<%= tempZipcode %>','<%= tempSido %>','<%= tempGugun %>', 
				'<%= tempDong %>', '<%= tempRi %>', '<%= tempBunji %>')">
					
					
				<%= tempZipcode %> &nbsp; <%= tempSido %> &nbsp;
				<%= tempGugun %> &nbsp; <%= tempDong %> &nbsp;
				<%= tempRi %> &nbsp; <%= tempBunji %> &nbsp;
					
				
				</a><br>
			
			
			
			
			
			
			
			
			
				<%
					} //end for
			} // else
		} //end if	
				%>
			
			</td>
		</tr>
		
		

		
		

	
		<tr>
			<td align="center">
				<a href="javascript:this.close()">닫기</a>
			
			</td>
			
		</tr>
		
	
	</table>



</center>

</body>
</html>