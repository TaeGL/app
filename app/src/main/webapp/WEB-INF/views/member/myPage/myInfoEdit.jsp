<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>회원정보 수정</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<c:set var="cp" value = "${pageContext.request.contextPath}"/>
		
		<link rel="stylesheet" href="${cp}/resources/assets/css/main3.css" />
		
			<c:if test="${result=='true'}">
				<script>alert('수정완료!');</script>		
			</c:if>
			<c:if test="${result=='false'}">
				<script>alert('수정실패..');</script>
			</c:if>

		
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
										<li>
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
										<li class="active">
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

							<!-- Sidebar -->

							<div class="col-8 col-12-medium imp-medium">

							<!-- Content -->
								<div id="content">
									<section class="myInfoEdit-main">
										<div>
											<form action="/member/myPage/myInfoEdit" id="editUserForm" name="editUserForm" method="post">
											<div class="joinId">
												<h1>아이디</h1>
												<p>${user.user_id}</p>
												<input class = "inputId" type="hidden" id="user_id" name="user_id" value="${user.user_id}">
												<span class="error_next_box"></span>
											</div>
											<div>
												<input class="check_inputId" id="check_user_id" type="hidden" name="check_user_id">
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
												<input style="width: 100%; margin: 0 0 10px 0;" type="text" id="user_nick" name="user_nick" value="${user.user_nick }">
												<span class="error_next_box"></span>
											</div>
											<div>	
												<h1>이름</h1>
												<input style="width: 100%; margin: 0 0 10px 0;" type="text" id="user_name" name="user_name" placeholder="이름" value="${user.user_name}">
												<span class="error_next_box"></span>
											</div>
											
											<div>	
												<h1>이메일</h1>
												<p >${user.user_email }</p> 
												<input class = "inputId" type="hidden" id="user_email" name="user_email" value="${user.user_email}">
												<span class="error_next_box"></span>
											</div>
											
											<div>	
												<h1>주소</h1>
												<input style="width: 100%; margin: 0 0 10px 0;" type="text" name="user_addr" id="user_addr" placeholder="주소" value="${user.user_addr }">
												<span class="error_next_box"></span>
											</div>
											<div>
												<input type="hidden" id="user_grade" name="user_grade" value="${ user.user_grade}"> 
											</div>
											
											<div>
												<input  type="button" onclick="editUser();" value="정보수정" style="margin: 20px 0px 25px 0px; width: 100%;">
											</div>
											
											</form>								
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