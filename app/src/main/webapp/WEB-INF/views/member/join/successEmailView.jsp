<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		email : ${email }
	</div>
	<input type="hidden" id="email" value="${email  }">
</body>
<script>let cp = "${pageContext.request.contextPath}"</script>
<script type="text/javascript" src="${cp}/resources/assets/js/successEmail.js"></script>
</html>