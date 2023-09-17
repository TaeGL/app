

$(window).on('load', function () {
	load('#js-load', '5', '#js-btn-wrap');

	$("#js-btn-wrap").on("click", function () {
		load('#js-load', '5', '#js-btn-wrap');
	})
});
function load(id, cnt, btn) {
	var girls_list = id + " .js-load:not(.active)";
	var girls_length = $(girls_list).length;
	var girls_total_cnt;
	if (cnt < girls_length) {
		girls_total_cnt = cnt;
	} else {
		girls_total_cnt = girls_length;
		$(btn).hide();
	}
	$(girls_list + ":lt(" + girls_total_cnt + ")").addClass("active");
}


//댓글 수정


function updateRc(cNo){
		var editRc = document.querySelector('#editRc'+cNo);
		var rcP = document.querySelector('#rc-p'+cNo);
		var rcEdit = document.querySelector('#rc-edit'+cNo);
		var delRc = document.querySelector('#delRc'+cNo);
		var saveRc = document.querySelector('#saveRc'+cNo);
		var cancelRc = document.querySelector('#cancelRc'+cNo);
		
		editRc.style.display='none';
    	rcP.style.display='none';
		rcEdit.style.display='block';
		
		delRc.style.display='none';
		saveRc.style.display='inline';
		cancelRc.style.display='inline';
}

function cancelRc(cNo){
	var editRc = document.querySelector('#editRc'+cNo);
	var rcP = document.querySelector('#rc-p'+cNo);
	var rcEdit = document.querySelector('#rc-edit'+cNo);
	var delRc = document.querySelector('#delRc'+cNo);
	var saveRc = document.querySelector('#saveRc'+cNo);
	var cancelRc = document.querySelector('#cancelRc'+cNo);
	
	rcP.style.display='block';
	rcEdit.style.display='none';
	editRc.style.display='inline';
	delRc.style.display='inline';
	saveRc.style.display='none';
	cancelRc.style.display='none';
	
}

function saveRc(){
 	
	var rcForm = document.rcForm; 	
 	rcForm.submit();
}

function deleteRcView(cNo,rNo){
	window.open("/recipe/recipeDeleteView?cNo="+cNo , "PopupWin", "width=500,height=600")
}

function deleteRc(cNo){
	$.ajax({
		
		url : "/recipe/commentDeleteLogic",
		data : { "cNo" : cNo }, 
		type : "POST",
		datatype : "JSON" ,
		success : function(data){
			alert('댓글이 삭제되엇습니다');
			window.close();
			opener.window.location.assign("/recipe/recipeInfo/"+data.rNo);
		}
	});
}

function deleteCancel(){

	window.close();
}


 
//수정 삭제
	function recipeInfoEdit(rNo){
		window.location.assign("/recipe/recipeInfoEdit?rNo="+rNo);
	}
	
	function recipeDelete(rNo){
		window.open("/recipe/recipeDelete?rNo="+rNo , "PopupWin", "width=500,height=600")
		
	}

	function recipeDelYes(rNo){
		
	$.ajax({
		
		url : "/recipe/recipeDelete",
		data : { "rNo" : rNo }, 
		type : "POST",
		datatype : "JSON" ,
		success : function(data){
			alert('레시피가 삭제되엇습니다');
			window.close();
			
			opener.window.location.assign("/recipe/recipeList");
		}
	});
	}
	
	function recipeDeleteYes(){
		window.close();
	}


	
var formRecipe = document.editRecipe;

function editRecipeCheck(){
	if(!formRecipe.recipe_name.value){
		alert("레시피 제목을 입력해주세요");
		formRecipe.recipe_name.focus(); // id로 커서가 깜빡이게됨
		return;
	}
	if(!formRecipe.recipe_contents.value){
		alert("레시피 내용을 입력해주세요");
		formRecipe.recipe_contents.focus(); // id로 커서가 깜빡이게됨
		return;
	}
	
	
	formRecipe.submit();
	
}




//이미지 이벤트
function readImage(input) {
    // 인풋 태그에 파일이 있는 경우
    if(input.files && input.files[0]) {
        // 이미지 파일인지 검사 (생략)
        // FileReader 인스턴스 생성
        const reader = new FileReader()
        // 이미지가 로드가 된 경우
        reader.onload = e => {
            const previewImage = document.getElementById("preview-image")
            previewImage.src = e.target.result
        }
        // reader가 이미지 읽도록 하기
        reader.readAsDataURL(input.files[0])
    }
}

const inputImage = document.getElementById("input-image")
inputImage.addEventListener("change", e => {
    readImage(e.target)
})




