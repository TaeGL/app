


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>이메일 체크</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<c:set var="cp" value = "${pageContext.request.contextPath}"/>
		
		<link rel="stylesheet" href="${cp}/resources/assets/css/main3.css" />
	
		<script type="text/javascript" src="https://code.jquery.com/jquery-1.10.2.min.js" /></script>
	</head>
	<body class="is-preload homepage">
		<div id="page-wrapper">

			<!-- Header -->
			<div id="header-wrapper">
					<header id="header" class="container">
						
						<!-- Logo -->
							<div id="logo">
								<h1><a href="${cp}/">recipe</a></h1>
								<span>요리를 재밋고 즐겁게~☆</span>
							</div>

						<!-- Nav -->
						<c:if test="${sessionScope.login ==null }">
							<nav id="nav">
								<ul>
									<li class="current">
										<a href="/recipe/recipeList?page=1">전체 레시피</a>
									</li>
									
									<li><a href="/member/login/loginView">로그인/회원가입</a></li>
									<li><a href="/customerManage/customerService">고객센터</a></li>
								</ul>
							</nav>
						</c:if>
					</header>
				</div>

			<!-- Banner -->

	

			<!-- Main -->
				<div id="main-wrapper">
				
				<!-- Features -->
				<div class="loginMain" align="center" style="margin-top: 100px;">
						<div id="logo" >
							<h1><a href="${cp}/index">recipe</a></h1>
						</div>
						
						
						<h1 style="align-content: center; margin-top: 50px; margin-bottom: 50px;">이메일 인증</h1>
<!-- 						<form action="/member/login/loginView" method="post"> -->
							<div>
								<input style="width: 40%; margin: 0 0 10px 0;" type="text" id="input_email" name="input_email" placeholder="이메일 입력">
							</div>
							<div>
								<input  type="button" id="checkEmailButton" value="이메일 인증" onclick="check_email();" style="margin: 20px 0px 25px 0px; width: 40%;">
							</div>
							<div>
								<p class="emailCheck-result" id="emailCheck-result" ></p>
							</div>
							
				</div>
				</div>

				<!-- Footer -->
				<div id="footer-wrapper">
					<footer id="footer" class="container">
						<div class="row">
							<div class="col-12">
								<div id="copyright">
									<ul class="menu">
										<li >&copy;㈜ 레시피 대표이사 : 홍길동 ｜ 사업자등록번호 : 333-11-22222 사업자정보확인 서울특별시 용산구 원효로 00길 0 <br>
											호스팅 제공자 : (주)레시피 ｜ 개인정보책임관리자 : 김길동 ｜ 통신판매업신고 : 용산 제 00000호 <br>

											[방문상담·구매·A/S] 용산점: 서울시 용산구 원효로 00길 ｜ [택배A/S접수] 서울시 용산구 원효로0가 00번지  <br>
											[고객센터] 0000-0000 (팩스번호 02-000-0000)1:1문의하기문자상담 ｜ E-mail : recipe_help@recipe.co.kr</li>
									</ul>
								</div>
							</div>
						</div>
					</footer>
				</div>

			</div>

		<!-- Scripts -->

</body>
<script>let cp = "${pageContext.request.contextPath}"</script>
<script type="text/javascript" src="${cp}/resources/assets/js/join.js"></script>
</html>