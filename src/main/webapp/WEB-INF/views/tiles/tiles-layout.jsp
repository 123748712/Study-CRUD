<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<script type="text/javascript">
		var CONTEXT_PATH = "${CONTEXT_PATH}";
		var RESOURCES_PATH = "${RESOURCES_PATH}";
	</script>
	<link rel="stylesheet" href="${RESOURCES_PATH}/css/common.css">
    <title><tiles:insertAttribute name="title" /></title>
</head>
 <body>
  	<div class='wrap'> <!-- tiles.defind.xml에 지정해놓은 name의 value에 따라 지정한 jsp파일 지정 -->
  		<tiles:insertAttribute name="header" />
		  <div class='content'>  	
  			<tiles:insertAttribute name="left"/>
	  		<div class="page_content">
	  			<tiles:insertAttribute name="body"/> <!-- body는 */* 에 패턴에 맞춰 실행되는 jsp를 지정 -->
	  		</div>
  		</div>
  		<tiles:insertAttribute name="foot" />
  	</div>
</body>
</html>