<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>문의사항</title>
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
						<div class="row gtr-200">
							<div class="col-4 col-12-medium">

								<!-- Sidebar -->
								<div id="sidebar">
										<section class="widget thumbnails">
											<div class= "menu-cs-head">
												<h3>고객지원</h3>
											</div>
											<div class="menu-cs-main">
												<a href="/customerManage/customerService">
													<h1>공지사항</h1>
												</a>
											</div>
											<c:if test="${sessionScope.login.user_grade=='운영자' }">
												<div class="menu-cs-main">
													<a href="/admin/questionManage"><h1>1:1문의 관리(admin전용)</h1></a>
												</div>
											</c:if>
											<div class="menu-cs-main">
											<img alt="" width="200px;" height="400px;" src="${cp}/resources/images/customerService/customerServicePost.png">
											</div>
											<div class="menu-cs-main-button">
											<a href="/customerManage/questionToAdmin" class="button icon fa-file-alt">1:1 문의하기</a>
											</div>
										</section>
									</div>

							</div>
							<div class="col-8 col-12-medium imp-medium">

								<!-- Content -->
								<div class="customerService-main-right">
										<section>
											<hr>
											<h2>1:1 문의</h2>
											<hr>
											<table>
											<thead>
												<tr>
													<th class="t2-col-type">분류</th>
													<th class="t2-col-id">작성자</th>
													<th class="t2-col-title">제목</th>
													<th class="t2-col-date">작성일</th>
												</tr>
												
											</thead>
											<tbody>
												
											<c:forEach var="dto" items="${list}">
												<tr>
													<td>
														<a href="/customerManage/questionToAdminInfo/${dto.board_no}">
															${dto.board_type}																
														</a>
													</td>
													<td>
														<a href="/customerManage/questionToAdminInfo/${dto.board_no}">
															${dto.user_id}											
														</a>					
													</td>
													<td>
														<a href="/customerManage/questionToAdminInfo/${dto.board_no}">
																											
															${dto.board_title } <c:if test="${ dto.board_state =='ready'}"> [ 답변완료 ] </c:if>
														</a>
													</td>
													<td>
														
														${dto.board_date }
													</td>
												</tr>
											</c:forEach>	
					
												
											</tbody>
											</table>
											
											<button class="button-align-right" onclick="location.href='/customerManage/questionInsert?user_id=${dto.user_id}'">글쓰기</button>
										</section>
								</div>
							</div>
						</div>
					</div>
					<!--페이징처리 -->
						<div class="page">
							<c:if test="${page>1}">
								<a href="/customerManage/questionToAdmin?page=${page-1}">&lt;</a>
							</c:if>
							<c:forEach begin="${firstPage}" end="${lastPage}" step="1" var="i">
								<c:choose>
									<c:when test="${page==i}">
										<span>${i}</span>
									</c:when>
									<c:otherwise>
										<a href="/customerManage/questionToAdmin?page=${i}">${i}</a>
									</c:otherwise>
								</c:choose>								
							</c:forEach>
							<c:if test="${page<totalPage}">
								<a href="/customerManage/questionToAdmin?page=${page+1}">&gt;</a>						
							</c:if>
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