//레시피 댓글

var formRecipeComment = document.recipeComentWrite;


function comentWrite(){
	if(!formRecipeComment.recipe_comment.value){
		alert("댓글을 입력해주세요");
		formRecipeComment.recipe_comment.focus(); // id로 커서가 깜빡이게됨
		return;
	}
	
	formRecipeComment.submit();
}

function recipeLike(likeOn , rNo){
	var userId = document.getElementById("user_id").value
	
	if(userId !=null){
	
	$.ajax({
	
	url: "/recipe/checkLike", // 클라이언트가 요청을 보낼 서버의 URL 주소
	data: {"likeOn": likeOn, "rNo": rNo , "userId": userId },        // HTTP 요청과 함께 서버로 보낼 데이터
	type: 'POST',          // HTTP 요청 방식(GET, POST),
	
	
	success : function(data) {
		if(data=="true"){
			document.getElementById("recipeLike").src = "/resources/images/recipe/likeOn.png";
		}else if( data == "false"){
			document.getElementById("recipeLike").src = "/resources/images/recipe/likeOff.png";
		}else{
			alert("로그인 후 이용하세요");
			window.location.assign("/member/login/loginView");
		}
	}
});

 

}	

	

	

}