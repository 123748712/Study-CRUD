<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<spring:message code="board.title"/>
<h1>스프링 form태그 게시판</h1>									 <!-- Controller에서 ModelAttribute("vo")로 담아주었기 때문에 vo로 작성 -->
<form:form action="${pageContext.request.contextPath}/board/write" method="post" modelAttribute="vo">
제목 <form:input path="boardTitle"/> <br> <!-- path에 name 작성 -->
<form:errors path="boardTitle"/> <!-- vo의 필드값으로 작성 -->
작성자 <form:input path="boardWriter"/> <br>
<form:errors path="boardWriter"/>
내용 <br>
<form:textarea path="boardContent" cols="60" rows="10"/> <br>
<form:errors path="boardContent"/>
<form:button>글등록</form:button>
</form:form>
<!-- 
	Controller에서는 return으로 write2를 다시 주어, 작성된 글이 초기화되었지만
	작성된 것들은 vo에 담겨있고, 담겨있는 데이터를 다시 input value에 담아주기 때문에
	작성된 글들은 초기화되지 않는다. (작성값이 그대로 Controller로 넘어가고 다시 넘어옴)
-->
<script>
</script>
</body>
</html>