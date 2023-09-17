
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>회원가입</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<c:set var="cp" value = "${pageContext.request.contextPath}"/>
		
		<link rel="stylesheet" href="${cp}/resources/assets/css/main3.css" />
		
		<c:if test="${ result == 'ready'}">
			<script>
				alert("해당 이메일로 이미 회원가입 하셧습니다");
				location.replace("/member/login/loginView");
			</script>
		</c:if>
		<c:if test="${ result == 'emailExpires'}">
			<script>
				alert("이메일 인증 기한이 만료되엇습니다\n다시 인증을 시도해주세요");
				location.replace("/");
			</script>
		</c:if>
	</head>
	<body class="is-preload homepage">
		<div id="page-wrapper">



			<!-- Main -->
				<div id="main-wrapper">
				
				<!-- Features -->
	
					<div >
						<div>
							<div align="center">
								<div id="logo">
									<h1><a href="/">recipe</a></h1>
								</div>
							</div>
							<h1 style=" margin-top: 50px; margin-bottom: 50px;" align="center">회원 가입</h1>
							
							<div class="joinMain" id="joinMain">
							<form action="/member/joinViewGo" id="joinForm" name="joinForm" method="POST" >
								<div class="joinId">
									<h1>아이디</h1>
										<input class = "inputId" type="text" id="user_id" name="user_id">
										<input class="checkId" id="checkId" type="button" onclick="openCheckId();" value="중복체크">
										<input class="check_inputId" id="check_user_id" type="hidden" name="check_user_id">
										<span class="error_next_box"></span>
									</div>
									<div>	
										<h1>비밀번호</h1>
										<input style="width: 100%; margin: 0 0 10px 0;" type="password" id="user_pw" name="user_pw" value="${user.user_pw }" placeholder="비번 입력">
										<span class="error_next_box"></span>
									</div>
									<div>	
										<h1>비밀번호 재입력</h1>
										<input style="width: 100%; margin: 0 0 10px 0;" type="password" id="user_pw_re" name="user_pw_re" value="${user.user_pw }" placeholder="비번 재입력">
										<span class="error_next_box"></span>
									</div> 
									<div>
										<h1>닉네임</h1>
										<input style="width: 100%; margin: 0 0 10px 0;" type="text" id="user_nick" name="user_nick" >
										<span class="error_next_box"></span>
									</div>
									<div>	
										<h1>이름</h1>
										<input style="width: 100%; margin: 0 0 10px 0;" type="text" id="user_name" name="user_name">
										<span class="error_next_box"></span>
									</div>
									
									<div>	
										<h1>이메일</h1>
										<p >${email }</p> 
										<input class = "inputId" type="hidden" id="user_email" name="user_email" value="${email}">
										<span class="error_next_box"></span>
									</div>
									
									<div>	
										<h1>주소</h1>
										<input style="width: 100%; margin: 0 0 10px 0;" type="text" name="user_addr" id="user_addr" placeholder="주소" >
										<span class="error_next_box"></span>
									</div>
									<div>
										<input type="hidden" id="user_grade" name="user_grade" value="silver"> 
									</div>
									<!--  -->
									
									<div>
										<input  type="button" onclick="join();" value="회원가입" style="margin: 20px 0px 25px 0px; width: 100%;">
									</div>

							</form>
						</div>
					</div>
				</div>

				
				</div>

			<!-- Footer -->

			</div>

		<!-- Scripts -->


</body>
<script>let cp = "${pageContext.request.contextPath}"</script>
<script type="text/javascript" src="${cp}/resources/assets/js/join.js"></script>


</html>