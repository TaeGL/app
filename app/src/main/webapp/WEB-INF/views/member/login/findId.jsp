<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>

		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<c:set var="cp" value = "${pageContext.request.contextPath}"/>
		<link rel="stylesheet" href="${cp}/resources/assets/css/main3.css" />
		
		<script type="text/javascript" src="https://code.jquery.com/jquery-1.10.2.min.js" /></script>
</head>
<body>
	
	<div class="">
		<div class="findId-seciont-main">
			<input class="findId-inputId" id="input_email" type="text" placeholder="이메일을 입력하세요">
			<input class="findId-button" type="button" onclick="findId();" value="아이디 찾기">
		</div>
		<div>
			<p class="findId-result"> </p>
		</div>		
	</div>
	
</body>
<script>let cp = "${pageContext.request.contextPath}"</script>
<script type="text/javascript" src="${cp}/resources/assets/js/login.js"></script>
</html>