<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.active {
		color: red;
		font-size: 2em;
	}
</style>
<script>
const f_over = function(p_tr) {
	p_tr.style.backgroundColor = "black";
	p_tr.style.color = "yellow";
}

const f_out = function(p_tr) {
	p_tr.style.backgroundColor = "white";
	p_tr.style.color = "black";
}

let resultMsg = "${onetimemsg}";

if(resultMsg) {
	alert(resultMsg);
}
</script>
</head>
<body>
<h1>리스트</h1>
<p>${pageDTO.toString()}</p>
<table border="1">
<tr><th>순번</th><th>번호</th><th>제목</th><th>작성자</th><th>날짜</th></tr>
<c:forEach var="board" items="${boardList}" varStatus="status">
	<tr onmouseover="f_over(this)" onmouseout="f_out(this)">
		<td>${status.index}</td>
		<td>${board.boardNo}</td>
		<td><a href="${pageContext.request.contextPath}/board/read?boardNo=${board.boardNo}">${board.boardTitle}</a></td>
		<td>${board.boardWriter}</td>
		<td><fmt:formatDate value="${board.boardRegdate}" pattern="yyyy-MM-dd"/></td>
	</tr>
</c:forEach>
</table>
<!-- 페이지 바운더리 출력 -->
<c:set var="curPage" value="${pageDTO.pageCondDTO.pageNum}" />
<c:set var="pageSize" value="${pageDTO.pageCondDTO.pageSize}" />
<c:set var="contextPath" value="${pageContext.request.contextPath}/board"></c:set>
<p>현재페이지 : ${curPage}</p>
<c:forEach var="pageNum" begin="${pageDTO.startPage}" end="${pageDTO.endPage}" step="1">
	<c:if test="${pageNum == curPage}"> <!-- 사용자가 선택한 페이지와 현재페이지가 같을때 -->
	<a href="${contextPath}/list?pageNum=${pageNum}&pageSize=${pageSize}" class="active">${pageNum}</a>&nbsp;&nbsp;
	</c:if>
	<c:if test="${pageNum != curPage}"> <!-- 사용자가 선택한 페이지와 현재페이지가 다를때 -->
	<a href="${contextPath}/list?pageNum=${pageNum}&pageSize=${pageSize}">${pageNum}</a>&nbsp;&nbsp;
	</c:if>
</c:forEach>
<a href="${pageContext.request.contextPath}/board/write">글쓰기</a>
</body>
</html>