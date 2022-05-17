<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${boardVO.boardNo}번 상세내용</h1>
<form id="id_form" action="${pageContext.request.contextPath}/board/modify" method="post" >
	제목 <input type="text" name="boardTitle" value="${boardVO.boardTitle}" readonly> <br>
	작성자 <input type="text" name="boardWriter" value="${boardVO.boardWriter}" readonly> <br>
	내용 <br>
	<textarea rows="10" cols="80" name="boardContent" readonly>${boardVO.boardContent}</textarea> <br>
	<!-- hidden으로 view에선 숨기고, form으로 데이터는 전송 -->
	<input type="hidden" name="boardNo" value="${boardVO.boardNo}">
	<input type="button" id="id_mod" value="수정">
	<input type="submit" value="수정내용 전송" disabled>
	<input type="submit" value="삭제" id="id_del">
</form>
<script>
	const c_mod = document.querySelector("#id_mod");
	const f_modClick = () => {
		/* form태그는 html에 여러번 올 수 있어 기본 제공 키워드인 forms[] 배열로 가져올 수 있다. */
		/* form 태그 안 요소(element)들을 가져온다. */
		let l_elements = document.forms[0].elements;
		for(i = 0; i < l_elements.length; i++) {
			/* form태그 안 요소들의 속성인 readOnly, disabled를 전부 false한다. */
			l_elements[i].readOnly = false;
			l_elements[i].disabled = false;
		}
	}
	c_mod.onclick = f_modClick;
	
// 	const c_del = document.querySelector("#id_del");
// 	const f_delClick = () => {
// 		event.preventDefault();
		
// 		let l_form = document.forms[0];
// 		l_form.action = "${pageContext.request.contextPath}/board/delete";
		
// 		l_form.submit();
// 	}
	
// 	c_del.onclick = f_delClick;

	const c_form = document.querySelector("#id_form");
	const f_submit = () => {
		event.preventDefault();
		c_form.action = "${pageContext.request.contextPath}/board/delete";
		c_form.submit();
	}
	c_form.addEventListener("submit", f_submit);
</script>
</body>
</html>