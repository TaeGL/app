<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>계정 삭제</title>
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
								<nav id="nav">
									<ul>
										<li class="current">
											<a href="${cp}/recipe/recipeList?page=1">전체 레시피</a>
										</li>
										<li><a href="${cp}/recipe/makeRecipe">레시피 등록</a></li>
										<li><a href="${cp}/member/myPage/myRecipe">마이페이지</a>
										</li>
										<li><a href="${cp}/member/logout">로그아웃</a></li>
										<li><a href="${cp}/customerManage/customerService">고객센터</a></li>
										
									</ul>
								</nav>
						
					</header>
				</div>
			<!-- Banner -->

	

			<!-- Main -->
				<div id="main-wrapper">
					<div class="container">

							<!-- Sidebar -->

							<div class="col-8 col-12-medium imp-medium">

							<!-- Content -->
								<div id="content">
									<section class="myInfoEdit-main">
										<div>
											<div class="joinId">
												
												<h1>${email } 해당 이메일로</h1> 
												<h1>인증코드가 전송되엇습니다</h1>
												<h1>메일을 확인하시고 인증코드를 입력하여주세요</h1>
												<span class="error_next_box"></span>
											</div>
											<div>
												<input type="hidden" id="email" value="${email }">
											</div>
											<div>	
												<h1>인증번호</h1>
												<input style="width: 100%; margin: 0 0 10px 0;" type="text" id="input_code" name="input_code"  placeholder="코드 입력">
												<button onclick="myAccDelete();" >확인</button>
												<span class="error_next_box"></span>
											</div>
										</div>
									</section>
								</div>
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



</body>
<script>let cp = "${pageContext.request.contextPath}"</script>
<script type="text/javascript" src="${cp}/resources/assets/js/myPage.js"></script>
</html>