

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>

		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<c:set var="cp" value = "${pageContext.request.contextPath}"/>
		<link rel="stylesheet" href="${cp}/resources/assets/css/main3.css" />
		
		<script type="text/javascript" src="https://code.jquery.com/jquery-1.10.2.min.js" /></script>
</head>
<body>
	
	<div class="">
		<div class="findPw-seciont-main">
			<input class="findPw-inputEmail" id="findPw_inputEmail" type="text" placeholder="이메일을 입력하세요">
			<input class="findPw-inputId" id="findPw_inputId" type="text" placeholder="아이디를 입력하세요">
			<input class="findPw-button" type="button" onclick="findPw();" value="비밀번호 찾기">
		</div>
		<div>
			<p class="findPw-result"> </p>
		</div>		
	</div>
	
</body>
<script>let cp = "${pageContext.request.contextPath}"</script>
<script type="text/javascript" src="${cp}/resources/assets/js/login.js"></script>
</html>