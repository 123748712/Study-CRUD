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
    #replyModal { /* 화면 전체를 꽉 채우는 레이어 */
       z-index: 99999; /* 맨 앞으로 올 수 있도록 */
       position: fixed;
       left: 0px;
       top: 0px;
       width: 100vw;
       height: 100vh;
       background-color: rgba(100, 100, 100, 0.3);
       display: none; /* 처음엔 보이지 않게 */
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
제목 <input type="text" id="reply_title" name="replyTitle">
작성자 <input type="text" id="reply_writer" name="replyWriter"> <br>
내용 <textarea rows="5" cols="55" id="reply_content" name="replyContent"></textarea>
<input type="button" id="id_btn" value="댓글" onclick="f_submitReply()">
<div id="replylist"></div>
<script>
	printList();
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

	function printList() {
		

	// AJAX로 replyList 불러오기
	const xhr = new XMLHttpRequest();
// 	xhr.open("get", "${replyPath}?boardNo=${boardVO.boardNo}", true);
	xhr.open("post", "${replyPath}", true);
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
				replyDiv.innerHTML = "<input type='text' class=no"+ i +" value=" + replyArr[i].replyNo + " disabled>" + "&nbsp;&nbsp;" + 
									 "<input type='text' class=title"+ i +" value=" + replyArr[i].replyTitle + " disabled>" + "&nbsp;&nbsp;" + 
									 "<input type='text' class=writer"+ i +" value=" + replyArr[i].replyWriter + " disabled>" + "&nbsp;&nbsp;" + 
									 "<textArea type='text' class=content"+ i +" disabled>" + replyArr[i].replyContent + "</textArea>";
				let replyMod = document.createElement("input");
				replyMod.type = "button";
				replyMod.setAttribute("class", "modBtn"+i);
				replyMod.setAttribute("id", "mod1"+i);
				replyMod.value = "수정";
				replyMod.onclick = f_click.bind(this,i, replyArr[i].replyNo, replyArr[i].replyTitle, replyArr[i].replyWriter, replyArr[i].replyContent);
				replyDiv.appendChild(replyMod);
				let replyDel = document.createElement("input");
				replyDel.setAttribute("class", "delBtn" + i)
				replyDel.type = "button";
				replyDel.value = "삭제";
				replyDel.onclick = f_del.bind(this, replyArr[i].replyNo);
				replyDiv.appendChild(replyDel);
				let replyMod2 = document.createElement("input");
				replyMod2.type = "button";
				replyMod2.disabled = true;
				replyMod2.value = "수정확인";
				replyMod2.setAttribute("id", "mod2"+i);
				replyMod2.onclick = f_mod.bind(this, i, replyArr[i].replyNo);
				replyDiv.appendChild(replyMod2);
				c_replylist.appendChild(replyDiv); // 댓글 div를 div자식으로 넣어준다.
			}
		}
	}
// 	xhr.send();
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); // post방식으로 보낼때 requestHeader를 세팅해주어야 한다.
	// jQuery AJAX는 RequestHeader가 default여서 설정해주지 않아도 된다.
	// contentType:false, processData:false 세팅이 추가적으로 필요
	xhr.send("boardNo=${boardVO.boardNo}"); // post방식으로 보낼때 send 안에 보낼 데이터를 넣어준다.
	}
	
	function f_click(i, replyNo, replyTitle, replyWriter, replyContent) {
		console.log("no > " + replyNo);
		console.log("title > " + replyTitle);
		console.log("writer > " + replyWriter);
		console.log("content > " + replyContent);
		
		var iInputNo = document.getElementsByClassName("no" + i);
		var iInputTitle = document.getElementsByClassName("title" + i);
		var iInputWriter = document.getElementsByClassName("writer" + i);
		var iInputContent = document.getElementsByClassName("content" + i);
		var mod2 = document.getElementById("mod2"+i);
		mod2.disabled = false;
		var mod1 = document.getElementById("mod1"+i);
		mod1.disabled = true;
		
		for(var j = 0; j < iInputNo.length; j++) {
			iInputTitle[j].disabled = false;
			iInputWriter[j].disabled = false;
			iInputContent[j].disabled = false;
		}
	}
	
	function f_mod(i, replyNo) {
		const title = document.querySelector(".title"+i).value;
		const writer = document.querySelector(".writer"+i).value;
		const content = document.querySelector(".content"+i).value;
		
		var xhr1 = new XMLHttpRequest();	
		xhr1.open("post", "${pageContext.request.contextPath}/reply/update", true);
		xhr1.onreadystatechange = function() {
			if(xhr1.readyState == 4 & xhr1.status == 200) {
			console.log("수정번호 > " + replyNo);
			c_replylist.innerHTML = "";
			printList();
				}
			}
			const replyVO = {
					'replyNo' : replyNo,
					'replyTitle' : title,
					'replyWriter' : writer,
					'replyContent' : content
			}
			xhr1.setRequestHeader('Content-Type', 'application/json');
			console.log(replyVO);
			xhr1.send(JSON.stringify(replyVO)); // del 버튼 눌렀을대 값 var로 저장해서 넘겨야함
		}
	
	
	
	
	function f_del(replyNo) {
		var xhr1 = new XMLHttpRequest();
		xhr1.open("post", "${pageContext.request.contextPath}/reply/delete", true);
		xhr1.onreadystatechange = function() {
			if(xhr1.readyState == 4 & xhr1.status == 200) {
			console.log("삭제번호 > " + replyNo);
			c_replylist.innerHTML = "";
			printList();
				}
			}
			xhr1.setRequestHeader('Content-Type', 'application/json');
			xhr1.send(replyNo);// del 버튼 눌렀을대 값 var로 저장해서 넘겨야함
		}

	const replyBtn = document.querySelector("#id_btn");
	
	const f_submitReply = () => {
		
		var xhr1 = new XMLHttpRequest();
		xhr1.open("post", "${pageContext.request.contextPath}/reply/write", true);
		xhr1.onreadystatechange = function() {
			if(xhr1.readyState == 4 & xhr1.status == 200) {
				c_replylist.innerHTML = "";
				printList();
				document.querySelector("#reply_title").value = "";
				document.querySelector("#reply_writer").value = "";
				document.querySelector("#reply_content").value = "";
				}
			}
		const replyVO = {
			'boardNo' : ${boardVO.boardNo},
			'replyTitle' : document.querySelector("#reply_title").value,
			'replyWriter' : document.querySelector("#reply_writer").value,
			'replyContent' :  document.querySelector("#reply_content").value
		}
		xhr1.setRequestHeader('Content-Type', 'application/json');
		xhr1.send(JSON.stringify(replyVO));
	}		
</script>
</body>
</html>