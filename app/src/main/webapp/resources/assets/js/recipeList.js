

function search(){
	
	var search = document.querySelector("#search").value.trim();
	window.location.assign("/recipe/search?search="+search);
	
}