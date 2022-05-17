<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>리스트</h1>
<table border="1">
<tr><th>순번</th><th>번호</th><th>제목</th><th>작성자</th><th>날짜</th></tr>
<c:forEach var="board" items="${boardList}" varStatus="status">
	<tr>
		<td>${status.index}</td>
		<td>${board.boardNo}</td>
		<td>${board.boardTitle}</td>
		<td>${board.boardWriter}</td>
		<td><fmt:formatDate value="${board.boardRegdate}" pattern="yyyy-MM-dd"/></td>
		
	</tr>
</c:forEach>
</table>
</body>
</html>