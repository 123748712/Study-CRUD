<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<form id="id_form" action="${pageContext.request.contextPath}/rest/put" method="post">
	<input type="text" name="name" value="123748712"><br>
	<input type="text" name="age" value="age"><br>
	<input type="text" name="alias" value="alias"><br>
	<input type="hidden" name="_method" value="PUT">
	<input type="submit" value="put"><br>
	<input id="id_del" type="button" value="delete">
</form>
<script>
	const c_del = document.querySelector("#id_del");
	c_del.onclick = () => {
// 		id_form.submit(); // id로 접근하는 방식도 가능
	id_form.action = "${pageContext.request.contextPath}/rest/delete";
	id_form._method.value = "delete";
	id_form.submit();
	}
</script>
</body>
</html>
m