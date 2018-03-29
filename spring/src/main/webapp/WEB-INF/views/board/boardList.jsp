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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>



<script type="text/javascript">

	var list = ${list};		
	var curPage = parseInt(${curPage});
	var totalCount = Object.keys(list).length;
	var pagepageCount = 5; //한페이지에 보이는 페이징 수
	var pageboardCount = 10; //한 페이지에 보이는 게시글 수
	
	 $("#pageSection").empty();
	
	
	$(function(){
		pageDivider(totalCount,pageboardCount,pagepageCount,curPage);
		listSection(curPage);
	});
	
	
	function pageDivider(totalCount,pageboardCount,pagepageCount,curPage){
		
		/* 
		totalCount = 게시글 전체 개수
		pageboardCount = 한 페이지안에 출력되는 '게시글' 수
		pagepageCount = 화면상에 표시되는 '페이지' 개수
		curPage = 현재 페이지 수
		 */
		
		
		
		var pageStr = "";
		var temp = 0;
		
		// 총 글 수를 단위로 나누었을때 맞아떨어지지 않으면 +1을 한다.
		// 글 수에 따른 총 페이지 수 계산
		var totalPage = totalCount % pageboardCount == 0 ? totalCount / pageboardCount : totalCount / pageboardCount + 1;
		totalPage = parseInt(totalPage);
		
		//한 페이지에 나오는 수 중 가장 마지막수.
	  	var pageEnd = parseInt((curPage / pagepageCount))+1;
		//내가 지금 있는 수가 가장 마지막 수일때, 그 단위 안에 포함시키기 위한 계산식
		// ex) 1,2,3,4,[5]
         if (curPage % pagepageCount == 0){
        	 pageEnd--;
         }
         var lastNum = pageEnd * pagepageCount;
         var startNum = lastNum - pagepageCount+1;
         var formal = 0; //이전 화살표의 목표번호 값이 얼마인가 나중에 대입해줄때 필요한 변수
         pageStr += "<p id='down'>";
           
         if (curPage > pagepageCount) {
            pageStr += "<a href='javascript:goPage("+(startNum-1)+")'> << &nbsp &nbsp</a>";
         }
         
         //--------------------시작 숫자부터 마지막 숫자까지 순환----------------------
         for (var i = startNum; i <= totalPage; i++) {
        	 
         //지금 페이지 표시
            if (i <= pagepageCount * pageEnd) {
               curPage
            	if (curPage == i) {
                  pageStr += "[" + i + "]&nbsp &nbsp";
               } else {
                  pageStr += "<a href='javascript:goPage("+i+")'>"+i+"&nbsp &nbsp</a>";
               }
            } else {
               pageStr += "<a href='javascript:goPage("+(i)+")'> >> &nbsp &nbsp</a>";
               break;
            }
         }
         
         pageStr += "</p>";
	
         $("#pageSection").empty(pageStr);
         $("#pageSection").append(pageStr);
		
	}
	

	
	function listSection(curPage){
		var listEnd = curPage * pageboardCount ; 
		var listBegin = listEnd - pageboardCount+1;
		var str = "";
		
		$("#listBody").empty();
		
		
		for(var j = listBegin; j <= listEnd; j++){
			
			if(j <= totalCount){
			
			str += "<tr>";
			str += "<td>"+j+"</td>";
			str += "<td><a href='/boardDetail.do?boardNum="+list[j-1].BOARDNUM+"&curPage="+ curPage + "'>"+list[j-1].BOARDTITLE+"</a></td>";
			str += "<td>"+list[j-1].CREATEWRITER+"</td>";
			str += "<td>"+list[j-1].CREATEDATE+"</td>";
			str += "<td>"+list[j-1].BOARDCLICK+"</td>";
			str += "</tr>";
			
			} else {
				break;
			}
			
		}
		
		$("#listBody").append(str);
		
	}
	

	function goPage(curPageNum){
		
		curPage = curPageNum;
		listSection(curPage);
		pageDivider(totalCount,pageboardCount,pagepageCount,curPage)
		
	}


	function optionCheck(){
		
		if( $("#searchScope").val() == "" ){
			alert("검색 영역을 선택해주세요.");
			$("#searchScope").focus();
			return false;
		} else {
			$("#searchForm").submit();
		}
	}
</script>

<div class="container">

	<div class="panel panel-default">
	
		<div class="panel-heading">
			<br>
				<form id=searchForm action="/boardSearch.do" method="post" align="right">
					<select name="searchScope" id="searchScope" >
						<option value="">선택</option>
						<option value="title" >제목</option>
						<option value="writer">작성자</option>
					</select>
				
					<input type="text" name="searchInput"/>
					<input type="button" class="btn btn-sm" value="검색" onclick="javascript:optionCheck()"/>
				</form>
		</div>
	
		 <div class="panel-body">
			<table class="table table-striped table-hover">
				
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록일자</th>
						<th>조회수</th>
					</tr>
				</thead>
			
				<tbody id="listBody">
				</tbody>
				
			</table>
			
			<!-- 페이징 처리 부분-->
			<div id="pageSection">
			</div>
			
			<br>
			<a href="/boardInsert" >글 추가</a>
			<a href="/boardList.do" >글 전체목록</a>
			<a href="resources/board/boardMain.jsp" >메인으로</a>
		</div>

	</div>

</div>

</body>
</html>