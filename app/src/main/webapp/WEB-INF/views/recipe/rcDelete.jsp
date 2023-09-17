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
<title>댓글 삭제</title>

		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<c:set var="cp" value = "${pageContext.request.contextPath}"/>
		
		<link rel="stylesheet" href="${cp}/resources/assets/css/main3.css" />
		<script type="text/javascript" src="https://code.jquery.com/jquery-1.10.2.min.js" /></script>
		<c:if test="${cNo ==null } ">
			<script>
				window.location.assign("/redirect:/member/login/loginView?result="+false);
			</script>
		</c:if>
</head>
<body>
	<div class="body-checkId-content">
		<div class="body-checkId-section-main">
			
			<form action="/member/join/checkIdLogic" method="post" id="checkIdForm" name="checkIdForm">
				<div class="checkId-main">
				<div class="button-align-center">
					<h1>댓글을 삭제하시겟습니까?</h1>
					
							<input type="button" value="YES" readonly="readonly" onclick="deleteRc(${cNo});">
							<input type="button" value="NO" onclick="deleteCancel();">
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
<script>let cp = "${pageContext.request.contextPath}"</script>
<script type="text/javascript" src="${cp}/resources/assets/js/recipeManage.js"></script>
</html>