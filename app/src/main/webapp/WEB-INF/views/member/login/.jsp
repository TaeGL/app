


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Verti by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<c:set var="cp" value = "${pageContext.request.contextPath}"/>
		
		<link rel="stylesheet" href="${cp}/resources/assets/css/main3.css" />
	</head>
	<body class="is-preload homepage">
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header-wrapper">
					<header id="header" class="container">
						
						<!-- Logo -->
							<div id="logo">
								<h1><a href="${cp}/index">recipe</a></h1>
								<span>요리를 재밋고 즐겁게~☆</span>
							</div>

						<!-- Nav -->
							<nav id="nav">
								<ul>
									<li class="current"><a href="${cp}/WEB-INF/index.html">Top 10 레시피</a></li>
									<li>
										<a href="#">전체 레시피</a>
										<ul>
											<li><a href="#">전체 레시피</a>
												<ul>
													<li><a href="#">조립 컴퓨터</a></li>
													<li><a href="#">삼성</a></li>
													<li><a href="#">LG</a></li>
													<li><a href="#">애플</a></li>
													<li><a href="#">마이크로소프트</a></li>
													<li><a href="#">ibm</a></li>
													<li><a href="#">asus</a></li>
													<li><a href="#">msi</a></li>
													<li><a href="#">기가바이트</a></li>
												</ul>
											</li>
										</ul>
									</li>
									<li>
										<a href="${cp}/WEB-INF/left-sidebar.html">오늘의 레시피</a>
										<ul>
											<li><a href="#">컴퓨터 부품</a>
												<ul>
													<li><a href="#">CPU</a></li>
													<li><a href="#">메인보드</a></li>
													<li><a href="#">메모리</a></li>
													<li><a href="#">그래픽카드</a></li>
													<li><a href="#">SSD</a></li>
													<li><a href="#">HDD</a></li>
													<li><a href="#">ODD</a></li>
													<li><a href="#">케이스</a></li>
													<li><a href="#">파워</a></li>
													<li><a href="#">쿨러/튜닝용품</a></li>
												</ul>
											</li>
										</ul>
									</li>
									
									<li><a href="${cp}/member/loginView">로그인/회원가입</a></li>
									<li><a href="${cp}/WEB-INF/no-sidebar.html">고객센터</a></li>
								</ul>
							</nav>
						
					</header>
				</div>

			<!-- Banner -->

	

			<!-- Main -->
				<div id="main-wrapper">
				
				<!-- Features -->
					<div class="joinOk">
						<div align="center">
							<h2>회원가입 완료</h2>
						</div>
						<div align="center">
							<input class="" type="button" onclick="location.href='/member/loginView'" value="로그인하러가기">
						</div>
					</div>
							

				
				</div>

			<!-- Footer -->
				<div id="footer-wrapper">
					<footer id="footer" class="container">
						<div class="row">
							<div class="col-3 col-6-medium col-12-small">

								<!-- Links -->
									<section class="widget links">
										<h3>Random Stuff</h3>
										<ul class="style2">
											<li><a href="#">Etiam feugiat condimentum</a></li>
											<li><a href="#">Aliquam imperdiet suscipit odio</a></li>
											<li><a href="#">Sed porttitor cras in erat nec</a></li>
											<li><a href="#">Felis varius pellentesque potenti</a></li>
											<li><a href="#">Nullam scelerisque blandit leo</a></li>
										</ul>
									</section>

							</div>
						</div>
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