<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 체크</title>

		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<c:set var="cp" value = "${pageContext.request.contextPath}"/>
		
		<link rel="stylesheet" href="${cp}/resources/assets/css/main3.css" />
		<script type="text/javascript" src="https://code.jquery.com/jquery-1.10.2.min.js" /></script>
</head>
<body>
	<div class="body-checkId-content">
		<div class="body-checkId-section-main">
			
			<form action="/member/join/checkIdLogic" method="post" id="checkIdForm" name="checkIdForm">
				<div class="checkId-main">
					<input type="text" class="inputId2" id="inputId2" name="inputId2" value="${inputId} ">
					<input type="button" class="checkId2" value="아이디 체크" onclick="checkId();">
					<div>
						<c:if test="${result=='true'}">
							<h1>사용가능한 아이디 입니다.</h1>
							<h1>사용하시겟습니까?</h1>
							<div class="checkIdChoose">
								<input type="button" value="YES" readonly="readonly" onclick="checkIdYes('${inputId}');">
								<input type="button" value="NO" onclick="checkIdNo();">
							</div>
						</c:if>
						<c:if test="${result=='false'}">
							<h1>사용불가능한 아이디 입니다.</h1>
						</c:if>
						
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
<script>let cp = "${pageContext.request.contextPath}"</script>
<script type="text/javascript" src ="${cp}/resources/assets/js/checkId.js"></script>
</html>