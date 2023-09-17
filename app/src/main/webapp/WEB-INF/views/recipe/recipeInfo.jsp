


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
	<head>
		<title>레시피</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<c:set var="cp" value = "${pageContext.request.contextPath}"/>
		<link rel="stylesheet" href="${cp}/resources/assets/css/main3.css" />
		
		<style>
		.js-load {
			display: none;
		}
		.js-load.active {
			display: block;
		}
		.js-load:after {
			display: none;
		}
		.btn-wrap {
			display: block;
		}
		</style>
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
					<div class= "container">
							<div class="recipe-info">
								<div class="recipeInfo-head">
									<div class="recipeInfo-head-left">
										<img alt="이미지없음" width="500px;" height="500px;" src="${cp}/resources/images/userRecipeImage/${recipe.recipe_image}" onerror="this.src='${cp}/resources/images/recipe/image_unknown.png'" >
									</div>
									<div class="recipeInfo-head-right">
											<h1>유저 | ${recipe.user_id}</h1>
											<h1>제목 | ${recipe.recipe_name}</h1>
											<h1>분류 | ${recipe.recipe_category}</h1>
											<h1 style="margin-left: 200px;"> [ 재료 ] </h1>
											<p class="textArea-content-newLine">
												
												${recipe.cook_ingredient}
											</p>
											<c:if test="${isMyRecipe=='true' }">
											<div class="recipeInfo-manage">
												<section>
													<input type="button" id="recipeInfo_edit" value="수정" onclick="recipeInfoEdit(${recipe.recipe_no});">
													<input type="button" id="recipeInfo_delete" value="삭제" onclick="recipeDelete(${recipe.recipe_no});">
												</section>
											</div>
											</c:if>
									</div>
								</div>
							
								<div class="recipeInfo-body">
									<section>
											<header>
												<h1>[ 조리방법 ]</h1>
											</header>
											<p class="textArea-content-newLine">
												${recipe.recipe_contents}
											</p>
									</section>
									<section>
										<div class="recipeInfo-button-like">
												<h1>좋아요    ${recipe.recipe_like} </h1>
											<input type="hidden" id="user_id" name="user_id" value="${login.user_id}">
										
											<c:choose>
												<c:when test="${ likeOn != 'true'}">
													<input type="image" id="recipeLike" onclick="recipeLike( ${likeOn} , ${recipe.recipe_no} )" src="${cp}/resources/images/recipe/likeOff.png">
												</c:when>
												<c:otherwise>
													<input type="image" id="recipeLike" onclick="recipeLike( ${likeOn} , ${recipe.recipe_no} )" src="${cp}/resources/images/recipe/likeOn.png">
												</c:otherwise>
											</c:choose>
										</div>
									</section>
								</div>
								<div class="recipeInfo-comments">
									<section>
										<header>
											<hr>
										</header>
										
										<div id="js-load" class="main">
										<ul class="">
											<c:forEach var="comment" items="${comments}" >
											<li class="lists__item js-load">
												<div class = "recipe-comment" id="${comment.comment_no }">
													<form action="/recipe/commentUpdate" method="post" id="rcForm" name="rcForm">
													<h1>${comment.user_id} | <img width="20px;" height="20px;" src="${cp}/resources/images/userGrade/${comment.user_grade}.png"> ${comment.comment_date}</h1>	  
													<div class="rc-edit" id="rc-edit${comment.comment_no}">
													
														<textarea name="recipe_comment" id="newComment${comment.comment_no}" rows="20" cols="60" style="resize: none;"  >${comment.recipe_comment} </textarea>
													</div>
													<c:if test="${ comment.user_id == sessionScope.login.user_id }">
													
														<input class="editRc" id="editRc${comment.comment_no}" type="button" value="수정" onclick="updateRc(${comment.comment_no});" >
														<input class="delRc" id="delRc${comment.comment_no}" type="button" value="삭제" onclick="deleteRcView(${comment.comment_no});">
															<input type="hidden" name="comment_no" value="${comment.comment_no }">	
															<input type="hidden" name="recipe_no" value="${comment.recipe_no }">
															<input type="hidden" name="user_id" value="${comment.user_id }">
															<input type="hidden" name="user_grade" value="${comment.user_grade }">
															<input type="hidden" name="comment_date" value="${comment.comment_date }">
															<input type="hidden" name="recipe_name" value="${comment.recipe_name }">
															<input class="saveRc" id="saveRc${comment.comment_no}" type="submit" value="저장" >	
														<input class="cancelRc" id="cancelRc${comment.comment_no}" type="button" value="취소" onclick="cancelRc(${comment.comment_no});">	
													</c:if>
													<div class="rc-p" id="rc-p${comment.comment_no }">
													<p class="content-newLine">${comment.recipe_comment}</p>
													</div>
													</form>
												</div>
											</li>
											</c:forEach >
										</ul>
										</div>
										<div style="padding-top:20px;">
											<button type="button" id="js-btn-wrap" class="more">더보기</button>
										</div>
										
										<form accept-charset="utf-8" action="/recipe/commentWrite" id="recipeComentWrite" name="recipeComentWrite" method="post">
											<div class="recipe-comment-write">
												<textarea id="recipe_comment" name="recipe_comment" style="resize: none;" placeholder="댓글 입력.."></textarea>
												<button type="button" onclick="comentWrite()"> 글쓰기 </button>
												<input type="hidden" name="recipe_no" value="${recipe.recipe_no}">
												<input type="hidden" name="user_id" value="${login.user_id}">
												<input type="hidden" name="user_grade" value="${login.user_grade}">
												<input type="hidden" name="recipe_name" value="${recipe.recipe_name}">
											</div>
										</form>
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
			
			
			
		<!-- Scripts -->
</body>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.10.2.min.js" /></script>
<script>let cp = "${pageContext.request.contextPath}"</script>
<script type="text/javascript" src="${cp}/resources/assets/js/recipeInfo.js"></script>
<script type="text/javascript" src="${cp}/resources/assets/js/recipeManage.js"></script>
</html>