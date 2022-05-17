<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시판</h1>
<form action="${pageContext.request.contextPath}/board/write" method="post">
	제목 <input type="text" name="boardTitle" required> <br> <!-- 클라이언트쪽에서 유효성검사를 해야한다. 서버쪽에서 하면 자원이 굉장히 낭비됨 -->
	작성자 <input type="text" name="boardWriter" required> <br>
	내용 <br>
	<textarea rows="10" cols="80" name="boardContent" required></textarea> <br>
	<input type="submit" value="글등록">
</form>
</body>
</html>