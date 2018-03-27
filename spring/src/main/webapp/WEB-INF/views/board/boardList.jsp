<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html>
<html>
<head>
<title></title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>

<script type="text/javascript">


	function ajaxSearchForm(formId){
		
		var f = document.searchForm;
		if(f.searchScope.value==''){
			alert("검색 영역을 선택해주세요.");
			f.searchScope.focus();
			return false;
		}
		
		
		$('#'+formId).ajaxForm({
			
			type: "post",
			url : "/boardSearch.do",
			datatype : "json",
			success : function(result){
				
				$("#listBody").empty();
				
				
				$.each(result,function(){
					
					var str ="";
					str += "<tr>";
					str += "<td>"+"번호"+"</td>";
					str += "<td><a href='/boardDetail.do?boardNum="+this.BOARDNUM+"'>"+this.BOARDTITLE+"</a></td>";
					str += "<td>"+this.CREATEWRITER+"</td>";
					str += "<td>"+this.CREATEDATE+"</td>";
					str += "<td>"+this.BOARDCLICK+"</td>";
					str += "</tr>";
					
					$("#listBody").append(str);
					
				})
					
				
			},
			
			error : function(){}
			
		}).submit();
	}

</script>

</head>

<body>


<form id="searchForm" name="searchForm">
<select name="searchScope">
	<option value="">선택</option>
	<option value="title">제목</option>
	<option value="writer">작성자</option>
</select>

<input type="text" name="searchInput"/>
<input type="button" value="검색" onclick="javascript:ajaxSearchForm('searchForm')" />
</form>


<div>
<table border="1">
	
	<thead>
		<tr>
			<th>순서</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일자</th>
			<th>조회수</th>
		</tr>
	</thead>

	<tbody id="listBody">
		<c:forEach var="data" items="${list}" varStatus="status">
			<tr>
			<td>${status.count}</td>
			<td><a href="/boardDetail.do?boardNum=${data.BOARDNUM}">${data.BOARDTITLE}</a></td>
			<td>${data.UPDATEWRITER}</td>
			<fmt:parseDate var="dateString" pattern="yyyyMMddHHmmss" value="${data.CREATEDATE}" /> 
			<td><fmt:formatDate value="${dateString}" pattern="yyyy-MM-dd" /></td>
			<td>${data.BOARDCLICK}</td>
			</tr>
		</c:forEach>
	
	</tbody>
</table>
</div>

<br>
[페이징처리]
<br>
<a href="resources/board/boardInsert.jsp" >글 추가</a>
<a href="/boardList.do" >글 전체목록</a>

</body>
</html>