<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>home</title>
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
								<h1><a href="${cp}/">recipe</a></h1>
								<span>요리를 재밋고 즐겁게~☆</span>
							</div>
							
							<c:if test="${sessionScope.login !=null }">
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
							</c:if>
					</header>
				</div>

			<!-- Banner -->
				<div id="banner-wrapper">
					<div id="banner" class="box container">
						<div class="row">
							<div class="col-7 col-12-medium">
								<h2>카레 두부부침</h2>
								<p>간단한 레시피, 맛은 최고!</p>
							</div>
							<div class="col-5 col-12-medium">
								<a href="/recipe/recipeInfo/${recipe.recipe_no}">
									<img width="200px;" height="200px;" alt="" onerror="this.src='${cp}/resources/images/recipe/image_unknown.png'" src="${cp}/resources/images/userRecipeImage/${recipe.recipe_image}">
								</a>
							</div>
						</div>
					</div>
				</div>

			<!-- Features -->
				<div id="features-wrapper">
					<div class="container">
						<div class="row">
							<div class="col-4 col-12-medium">

								<!-- Box -->
									<section class="box feature">
										<a href="#" class="image featured"><img src="${cp}/images/pic01.jpg" alt="" /></a>
										<div class="inner">
											<header>
												<h2>만두 어묵국</h2>
												<p>면/만두 · 일상 · 끓이기 · 가공식품류</p>
											</header>
											<c:if test="${fishCake!=null }">
												<a href="/recipe/recipeInfo/${fishCake.recipe_no}">
													<img width="200px;" height="200px;" alt="" onerror="this.src='${cp}/resources/images/recipe/image_unknown.png'" src="${cp}/resources/images/userRecipeImage/${fishCake.recipe_image}">
												</a>
											</c:if>
										</div>
									</section>

							</div>
							<div class="col-4 col-12-medium">

								<!-- Box -->
									<section class="box feature">
										<a href="#" class="image featured"><img src="${cp}/images/pic02.jpg" alt="" /></a>
										<div class="inner">
											<header>
												<h2>닭날개 간장조림</h2>
												<p>요리시간: 60분 이내</p>
											</header>
											<c:if test="${chicken!=null }">
												<a href="/recipe/recipeInfo/${chicken.recipe_no}">
													<img width="200px;" height="200px;" alt="" onerror="this.src='${cp}/resources/images/recipe/image_unknown.png'" src="${cp}/resources/images/userRecipeImage/${chicken.recipe_image}">
												</a>
											</c:if>
										</div>
									</section>

							</div>
							<div class="col-4 col-12-medium">

								<!-- Box -->
									<section class="box feature">
										<a href="#" class="image featured"><img src="${cp}/images/pic03.jpg" alt="" /></a>
										<div class="inner">
											<header>
												<h2>돼지고기 김치찌개</h2>
												<p>메인반찬 · 일상 · 볶음 · 돼지고기</p>
											</header>
											<c:if test="${kimchPork!=null }">
												<a href="/recipe/recipeInfo/${kimchPork.recipe_no}">
													<img width="200px;" height="200px;" alt="" onerror="this.src='${cp}/resources/images/recipe/image_unknown.png'" src="${cp}/resources/images/userRecipeImage/${kimchPork.recipe_image}">
												</a>
											</c:if>
										</div>
									</section>

							</div>
						</div>
					</div>
				</div>

			<!-- Main -->
				<div id="main-wrapper">
					<div class="container">
						<div class="row gtr-200">
							<div class="col-4 col-12-medium">

								<!-- Sidebar -->
									<div id="sidebar">
										<section class="widget thumbnails">
											<h3>고객센터</h3>
											<div class="grid">
												<div class="row gtr-50">
													<div class="col-6"><a href="#" class="image fit"><img src="${cp}/images/pic04.jpg" alt="" /></a></div>
													<div class="col-6"><a href="#" class="image fit"><img src="${cp}/images/pic05.jpg" alt="" /></a></div>
													<div class="col-6"><a href="#" class="image fit"><img src="${cp}/images/pic06.jpg" alt="" /></a></div>
													<div class="col-6"><a href="#" class="image fit"><img src="${cp}/images/pic07.jpg" alt="" /></a></div>
												</div>
											</div>
											<a href="/customerManage/customerService" class="button icon fa-file-alt">More</a>
										</section>
									</div>

							</div>
							<div class="col-8 col-12-medium imp-medium">

								<!-- Content -->
									<div id="content">
										<section class="last">
											<h2>안녕하세요 recipe에 오신걸 환영합니다</h2>
											<p>recipe는 이용자 중심의 마인드로 구인-구직이 좀더 쉽고 빠르게 매칭될 수 있게 하며, 외식산업에 필요한 다양한 컨텐츠 정보를 고객에게
											PC, 모바일, 테블릿, SNS, 웹 등을 통하여 실시간으로 간편하고 편리하게 제공하고 있습니다.</p>
										</section>
									</div>
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
</html>