<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 


	<c:if test="${check==1}">
		<meta http-equiv="Refresh" content="0; url=/BoardMVCProject/board/list.do?pageNum=${pageNum}"/>
	</c:if>


	<c:if test="${check==0}">
		비밀번호가 다릅니다.
		<br>
		<a href="javascipt:history(-1)">[글 수정하러 돌아가기]</a>
	</c:if>
