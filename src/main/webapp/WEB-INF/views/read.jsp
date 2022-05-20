<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.reply {
		border: 2px solid pink;
		background-color: black;
		color: yellow;
	}
</style>
</head>
<body>
<c:set var="replyPath" value="${pageContext.request.contextPath}/reply/list"></c:set>
<h1>${boardVO.boardNo}번 상세내용</h1>
<form id="id_form" action="${pageContext.request.contextPath}/board/modify" method="post" >
	제목 <input type="text" name="boardTitle" value="${boardVO.boardTitle}" readonly> <br>
	작성자 <input type="text" name="boardWriter" value="${boardVO.boardWriter}" readonly> <br>
	내용 <br>
	<textarea rows="10" cols="80" name="boardContent" readonly>${boardVO.boardContent}</textarea> <br>
	<!-- hidden으로 view에선 숨기고, form으로 데이터는 전송 -->
	<input type="hidden" name="boardNo" value="${boardVO.boardNo}">
	<input type="button" id="id_mod" value="수정">
	<input type="button" id="id_modify" value="수정내용 전송" disabled>
	<input type="submit" value="삭제" id="id_del">
</form>
<!-- 댓글 리스트 -->
<div id="replylist">
</div>
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
	
	const c_modify = document.querySelector("#id_modify");
	const f_modifyClick = () => {
		console.log(c_form.action);
		c_form.submit();
	}
	c_modify.onclick = f_modifyClick;
	
	const c_replylist = document.querySelector("#replylist");
	
	// AJAX로 replyList 불러오기
	const xhr = new XMLHttpRequest();
	xhr.open("get", "${replyPath}?boardNo=${boardVO.boardNo}", true);
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 & xhr.status == 200) {
// 			console.log(JSON.parse(xhr.responseText));
			let replyArr = JSON.parse(xhr.responseText); // json 배열로 변환후 담아주기
			
			if(!replyArr.length) { // 댓글의 길이가 0 이라면
				let replyDiv = document.createElement("div");
				replyDiv.setAttribute("class", "reply");
				replyDiv.innerHTML = "댓글 없음";
				c_replylist.appendChild(replyDiv);
			}
			for(let i = 0; i < replyArr.length; i++) {
				let replyDiv = document.createElement("div"); // div에 innerHTML로 내용 넣어주기  jQuery : $("<div></div>")
				replyDiv.setAttribute("class", "reply");
				replyDiv.innerHTML = replyArr[i].replyTitle + "&nbsp;&nbsp;" +
									 replyArr[i].replyWriter + "&nbsp;&nbsp;" +
									 replyArr[i].replyContent;
				c_replylist.appendChild(replyDiv); // 댓글 div를 div자식으로 넣어준다.
			}
		}
	}
	xhr.send();
	
</script>
</body>
</html>