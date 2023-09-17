


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>로그인</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<c:set var="cp" value = "${pageContext.request.contextPath}"/>
		<c:if test="${ result == false}">
			<script>
				alert("로그인 후 이용하세요");
				location.replace("/member/login/loginView");
			</script>
		</c:if>
		
		<link rel="stylesheet" href="${cp}/resources/assets/css/main3.css" />
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
							<nav id="nav">
								<ul>
									<li class="current">
										<a href="${cp}/recipe/recipeList?page=1">전체 레시피</a>
									</li>
									
									<li><a href="${cp}/member/login/loginView">로그인/회원가입</a></li>
									<li><a href="${cp}/customerManage/customerService">고객센터</a></li>
								</ul>
							</nav>
						
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
						
						<h1 style="align-content: center; margin-top: 50px; margin-bottom: 50px;">회원 로그인</h1>
					<form action="/member/login/loginView" method="post">
						<div>
							<input style="width: 40%; margin: 0 0 10px 0;" type="text" name="user_id" placeholder="아이디 입력">
						</div>
						<div>
							<input style="width: 40%; margin: 0 0 10px 0;" type="password" name="user_pw" placeholder="비번입력">
						</div>
						<div>
							<input  type="submit" value="로그인" style="margin: 20px 0px 25px 0px; width: 40%;">
						</div>
						<c:if test="${ login_fail =='id'}">
							<div >
								<p style="color: red">아이디가 틀렷습니다</p>
							</div>
						</c:if>
						<c:if test="${ login_fail =='pw'}">
							<div>
								<p style="color: red">비밀번호가 틀렷습니다</p>
							</div>
						</c:if>
						
						<div style="margin-top: 15px;">
							<a href="#" style="margin-left: 15px;" onclick="openFindId();">아이디 찾기</a> | 
							<a href="#" style="margin-left: 15px;" onclick="openFindPw();">비번찾기</a> | 
							<a href="/member/joinView" style="margin-left: 15px;">회원가입</a>
						</div>
					</form>
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
<script type="text/javascript" src="${cp}/resources/assets/js/login.js"></script>
</html>