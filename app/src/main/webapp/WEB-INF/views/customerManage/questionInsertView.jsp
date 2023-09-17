<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>문의 등록</title>
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
							<c:if test="${sessionScope.login ==null }">
							<nav id="nav">
								<ul>
									<li class="current">
										<a href="${cp}/recipe/recipeList?page=1">전체 레시피</a>
									</li>
									
									<li><a href="${cp}/member/login/loginView">로그인/회원가입</a></li>
									<li><a href="${cp}/customerManage/customerService">고객센터</a></li>
								</ul>
							</nav>
						</c:if>
					</header>
				</div>


			<!-- Main -->
				<div class="customerService-head">
					
				</div>
				<div id="main-wrapper">
					<div class="container">
						<div class="insert-question">
							<form action="/customerManage/questionInsert" name="questionInsertForm" method="post">
								<div class="insert-question-row">
								<h1>제목</h1>
								<input type="text" id="board_title" name="board_title">
								</div>
								<div class="insert-question-row">
								<h1>문의선택</h1>
								<select name="board_type" id="board_type" size="1">
									<option value="account">계정문의</option>
									<option value="improve">개선문의</option>
									<option value="otherInquiries">기타문의</option>
								</select>
								</div>
								<div class="insert-question-row">
								<input type="hidden" name="user_id" value="${user_id }"> 
								<h1>글 내용</h1>
									<div>
										<textarea name="board_content" id="board_content" rows="20" cols="120" style="resize: none;" ></textarea>
									</div>
								</div>
								<div class="button-align-right">
									<input type="button" onclick="questionInsert();" value="전송">
									<input type="button" onclick="location.href='/customerManage/customerService'" value="취소">
								</div>
							</form> 
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
<script type="text/javascript" src ="${cp}/resources/assets/js/customerServiceBoard.js"></script>
</html>
