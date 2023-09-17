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
				<div id="main-wrapper">
					<div class="container">
						<div class="csInfo">
							<div>
								<div>
									<table >
										<thead > 
											<tr >
												<td colspan="4" style="text-align: center; color: #9E9E9E;">1:1 문의사항</td>
											</tr>
										</thead>
										<tbody >
											<tr>
												<td class="questionInfo-t-col-1">
													${board.board_type }
												</td>
												<td class="questionInfo-t-col-3">
													${ board.user_id }
												</td>
												<td class="questionInfo-t-col-3">
													${ board.board_title }
												</td>
												<td class="questionInfo-t-col-4">
													${board.board_date }
												</td>
											</tr>
											<tr>
												<td class="csInfo-t-body" colspan="4">
												<p class="textArea-content-newLine">
													${ board.board_content }
												</p>
												</td>
											</tr>									
										</tbody>
										
									</table>
									
									
									<c:if test="${ sessionScope.login.user_id == board.user_id }">
										<c:choose>
										<c:when test="${comments !=null }">
											<div class="csInfo-comments">
												<h3> [ 문의답글 ]</h3>
												<p class="textArea-content-newLine">${ comments.question_comment}</p>
											</div>
										</c:when>
										<c:otherwise>
											<div class="button-del-question">
												
												<input class="buttonDelQuestion" type="button" value="게시글 삭제" onclick="delQuestionView(${board.board_no });">
											</div>
										</c:otherwise>
										</c:choose>
									</c:if>
									<c:choose>
									<c:when test="${questionCommentsOn =='true' && sessionScope.login.user_grade== '운영자' }">
										<div>
											<form action="/customerManage/insertQuestionComments" method="post" name="insertQuestionCommentForm">
												<input type="hidden" name="board_no" value="${board.board_no }">
												<input type="hidden" name="user_id" value="${board.user_id }">
												<p class="textArea-content-newLine">
													<textarea class="inputComments" name="question_comment" rows="20" cols="110" style="resize: none;" ></textarea>
												</p>
												<div class="button-del-question-comments" > 
													<input class="buttonShowInputText" id="buttonShowInputText" type="button" value="답글쓰기" onclick="showInputText();">
												</div>
												<div class="button-align-right">
													<input class="buttonInsertQuestion" type="button" value="전송" onclick="insertQuestionComments();">
													<input class="buttonHideInputText" type="button" value="취소" onclick="hideInputText();">
												</div>
											</form>
										</div>
									</c:when>
									<c:when test="${questionCommentsOn =='false' && sessionScope.login.user_grade== '운영자' }">
										<div class="csInfo-comments">
												<h3> [ 문의답글 ]</h3>
												<p class="textArea-content-newLine">${ comments.question_comment}</p>
											</div>
										<div class="button-del-question-comments">
											<input type="button" value="답글삭제" onclick="deleteQuestionCommentView(${comments.comment_no});">
										</div>
									</c:when>
									</c:choose>
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
		<!-- Scripts -->


</body>
<script>let cp = "${pageContext.request.contextPath}"</script>
<script type="text/javascript" src ="${cp}/resources/assets/js/customerServiceBoard.js"></script>
</html>