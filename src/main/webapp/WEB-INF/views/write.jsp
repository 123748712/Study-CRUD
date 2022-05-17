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
	<input type="button" id="id_submit" value="글등록">
<!-- 	<input type="submit" value="글등록"> -->
</form>
<script>
// button으로 submit구현
const c_submit = document.querySelector("#id_submit");
const c_form = document.forms[0]; // 가독성을 떨어트려 좋은 방법이 아님.

// button으로 구현하게 된다면 required 속성이 적용되지 않아 if문을 통해 걸어주어야 한다.
const f_submitClick = () => {
	if(!c_form.boardTitle.value.trim()) {
		alert("제목 미작성");
		c_form.boardTitle.focus();
		return;
	}
	if(!c_form.boardWriter.value.trim()) {
		alert("작성자 미작성");
		c_form.boardWriter.focus();
		return;
	}
	if(!c_form.boardContent.value.trim()) {
		alert("내용 미작성");
		c_form.boardContent.focus();
		return;
	}
	// return을 사용해 submit되지 않게 함수를 강제로 끝내준다.
	document.forms[0].submit();
}
c_submit.onclick = f_submitClick;
</script>
</body>
</html>