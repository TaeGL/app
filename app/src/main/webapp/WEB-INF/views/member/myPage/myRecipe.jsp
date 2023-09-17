<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>레시피 리스트</title>
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
				
										<!-- Features -->
				<div id="features-wrapper">
					<div class="container">
						<div class="row">
							<div class="col-3 col-12-medium" style="text-align: center;">

								<!-- Box -->
								<section class="myPageBox feature" >
									<div class="inner">
										<header>
										<ul>
										<li class="active">
											<a href="/member/myPage/myRecipe">레시피</a>
										</li>
										</ul>
										</header>
									</div>
								</section>
							</div>

							<div class="col-3 col-12-small" style="text-align: center;">
								<!-- Box -->
								<section class="myPageBox feature">
									<div class="inner">
										<header>
										<ul>
										<li>
										<a href="/member/myPage/myComments">댓글관리</a>
										</li>
										</ul>
										</header>
									</div>
								</section>
							</div>
							
							<div class="col-3 col-12-small" style="text-align: center;">
								<!-- Box -->
								<section class="myPageBox feature">
									<div class="inner" >
										<header>
										<ul>
										<li>
											<a href="/member/myPage/myInfoEdit">회원 정보 수정</a>
										</li>
										</ul>
										</header>
									</div>
								</section>

							</div>
							<div class="col-3 col-12-small" style="text-align: center;">
								<!-- Box -->
								<section class="myPageBox feature">
									<div class="inner" >
										<header>
										<ul>
										<li>
											<a href="/member/myPage/myAccDeleteView">회원 탈퇴</a>
										</li>
										</ul>
										</header>
									</div>
								</section>

							</div>
						</div>
					</div>
				</div>
				
					<div class="container">
						<div class="row gtr-200">
							<c:forEach var="dto" items="${recipes}">
								
									<div class="col-4 col-12-medium">
									<a class="myRecipe-link" href="/recipe/recipeInfo/${dto.recipe_no }">	
									<!-- Sidebar -->
										<div id="sidebar">
											<section class="widget thumbnails">
												<img width="300px" height="300px" alt="이미지를 불러올 수 없습니다" src="${cp}/resources/images/userRecipeImage/${dto.recipe_image}">
											</section>
										</div>
									</a>
									</div>
									<div class="col-8 col-12-medium imp-medium">
									<a class="myRecipe-link" href="/recipe/recipeInfo/${dto.recipe_no }">
									<!-- Content -->
										<div id="content">
											<section class="last">
												<h2>${dto.recipe_name }</h2>
												<p>
													${dto.recipe_category }
												</p>
												<p>${dto.user_id }</p>
											</section>
										</div>
									</a>
									</div>
							</c:forEach>
								<!--페이징처리 -->
							<div class="page">
								<c:if test="${page>1}">
									<a href="/member/myPage/myRecipe?page=${page-1}">&lt;</a>
								</c:if>
								<c:forEach begin="${firstPage}" end="${lastPage}" step="1" var="i">
									<c:choose>
										<c:when test="${page==i}">
											<span>${i}</span>
										</c:when>
										<c:otherwise>
											<a href="/member/myPage/myRecipe?page=${i}">${i}</a>
										</c:otherwise>
									</c:choose>								
								</c:forEach>
								<c:if test="${page<totalPage}">
									<a href="/member/myPage/myRecipe?page=${page+1}">&gt;</a>						
								</c:if>
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