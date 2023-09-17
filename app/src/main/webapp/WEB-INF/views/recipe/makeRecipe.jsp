


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>레시피 만들기</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<c:set var="cp" value = "${pageContext.request.contextPath}"/>
		<c:if test="${ login ==null}">
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
					<div class="makeRecipeMain" id="makeRecipeMain" style="margin-top: 100px;">
						<form action="/recipe/makeRecipeGo" id="makeRecipe" name="makeRecipe" method="post" enctype="multipart/form-data">
							<table border="5" style="background: #EFEFFB;">
							<tr>
							<th width="150px;">
								<h1>레시피 제목</h1>
							</th>
							<th>
								<input class="" name="recipe_name" id="recipe_name" type="text" value="name" style="width: 50%">
							</th>
							</tr>
							<tr>
							<th>
								<h1>사진등록</h1>
							</th>
							<th>
								<div class="image-container">
									<input style="display: block;" type="file" id="input-image" name="file"  >
								    <img width="150px;" height="150px;" id="preview-image" name="preview-image" src="${cp}/resources/images/recipe/image_unknown.png">
								    
								</div>
							</th>
							</tr>
							<tr>
							<th>
								<h1>카테고리</h1>
							</th>
							<td>
								<select name="recipe_category" id="recipe_category" size="1">
									<option value="pork1">밑반찬</option>
									<option value="pork2">메인반찬</option>
									<option value="chicken">국/찌개</option>
									<option value="chicken">디저트</option>
									<option value="chicken">면/만두</option>
									<option value="chicken">밥/죽/떡</option>
									<option value="chicken">퓨전</option>
									<option value="chicken">김치/젓갈/장류</option>
									<option value="chicken">빵</option>
									<option value="chicken">양식</option>
								</select>
							</td>
							<th>
								<input class="" type="radio" value="" style="width: 50%;" >
							</th>
							</tr>

							      <tr>
							
							         <td style="vertical-align:top">재료</td>
							         <td><textarea name="cook_ingredient" id="cook_ingredient" rows="5" cols="70" style="resize: none;" placeholder="여기에 재료 입력.."></textarea></td>
							
							      </tr>
							
							<tr>
							<th>
								<h1>요리정보</h1>
							</th>
							</tr>
							<tr>				
							<td colspan = "2" align = "center">
								<textarea name="recipe_contents" id="recipe_contents" rows="20" cols="110" style="resize: none;" ></textarea>
							</td>
							</tr>
							<tr>
							<td colspan="2" align="center">
								<input type="hidden" name="user_id" id="user_id" value="${user_id}" >
								<input type="button" onclick="insertRecipe();" value="레시피 등록">
							</td>
							</tr>
							</table>
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


</body>
<script>let cp = "${pageContext.request.contextPath}"</script>
<script type="text/javascript" src="${cp}/resources/assets/js/myjs.js"></script>
</html>