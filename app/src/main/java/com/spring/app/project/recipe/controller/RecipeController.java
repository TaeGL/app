package com.spring.app.project.recipe.controller;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.StandardServletAsyncWebRequest;
import org.springframework.web.multipart.MultipartFile;

import com.spring.app.project.recipe.dto.Recipe_DTO;
import com.spring.app.project.recipe.dto.RecipeComent_DTO;
import com.spring.app.project.recipe.dto.RecipeLike_DTO;
import com.spring.app.project.recipe.service.IRecipeComentService;
import com.spring.app.project.recipe.service.IRecipeService;
import com.spring.app.project.user.dto.GRADE_DTO;
import com.spring.app.project.user.dto.USER_DTO;

import jdk.nashorn.internal.ir.RuntimeNode.Request;


@Controller
public class RecipeController {
	
	@Autowired
	IRecipeService rService;

	@Autowired
	IRecipeComentService rcService;
	
	// 레시피 등록
		@RequestMapping(value = "/recipe/makeRecipe",method = RequestMethod.GET)
		public String makeRecipe(Model model ,  HttpSession session){
			if(session.getAttribute("login")!=null) {
				USER_DTO login =  (USER_DTO)session.getAttribute("login");
				model.addAttribute("user_id", login.getUser_id());
				return "/recipe/makeRecipe";
			}else {
				model.addAttribute("result", false);
				return "/member/login/loginView";
			}
			
		}
		
		
		@PostMapping(value = "/recipe/makeRecipeGo")
		public String makeRecipeGo(Model model, HttpSession session,Recipe_DTO recipe,MultipartFile file, HttpServletRequest request) throws Exception {
			if(session.getAttribute("login") !=null) {
			USER_DTO login = (USER_DTO)session.getAttribute("login");
				rService.makeRecipe(file,recipe,request);
				
				model.addAttribute("page" , 1);
				int rNo = rService.rnMax(login.getUser_id());
				
				return "redirect:/recipe/recipeInfo/"+rNo;
			}else {
				model.addAttribute("likeOn" , "false");
				return "/member/login/loginView";
			}
			
		}
		
		// 레시피 리스트
		@RequestMapping(value = "/recipe/recipeList")
		public String recipeList(Model model,@RequestParam(required = false, defaultValue = "1") int page){
			
			List<Recipe_DTO> list =  rService.recipeList(page);
			int pageSize = 10;
			int firstPage = ((page-1)/pageSize+1);
			int lastPage = firstPage+pageSize-1;
			int totalPage = (rService.recipeTotalCnt()/(pageSize+1))+1;
			lastPage = lastPage>totalPage?totalPage:lastPage;
			
			model.addAttribute("totalPage" , totalPage);
			model.addAttribute("recipes" ,list ); 
			model.addAttribute("page" , page );
			model.addAttribute("firstPage" , firstPage);
			model.addAttribute("lastPage" , lastPage);
			return "/recipe/recipeList";
		}
		
		// 레시피 검색
		@GetMapping("/recipe/search")
		public String recipeSearch(Model model ,@RequestParam(required = false, defaultValue = "1") int page,@RequestParam(required = false, defaultValue = " ") String search) {
			System.out.println("search : "+ search);
			List<Recipe_DTO> list = rService.searchRecipe(page,search);
			int pageSize = 10;
			int firstPage = ((page-1)/pageSize+1);
			int lastPage = firstPage+pageSize-1;
			
			int totalPage = rService.searchRecipeTotalCnt(search)/pageSize+1;
			lastPage = lastPage>totalPage?totalPage:lastPage;
			
			model.addAttribute("totalPage" , totalPage);
			model.addAttribute("recipes" ,list ); 
			model.addAttribute("page" , page );
			model.addAttribute("firstPage" , firstPage);
			model.addAttribute("lastPage" , lastPage);
			
			model.addAttribute("search",search);
			
			return "/recipe/recipeSearchList";
		}
		
		// 레시피 상세정보
		@GetMapping(value = "/recipe/recipeInfo/{rNo}")
		public String recipeInfo(Model model, @PathVariable int rNo, HttpSession session ) {
			
			USER_DTO login = (USER_DTO)session.getAttribute("login");
			model.addAttribute("recipe" , rService.getRecipe(rNo));
			model.addAttribute("comments", rcService.select(rNo));
			// 로그인 상태라면
			if(login!=null) {
				String userId = login.getUser_id();
				model.addAttribute("login", login);
				// 로그인 한 사용자가 등록한 레시피라면
				if(userId.equals( rService.selectRecipeRno(rNo).getUser_id())){
					model.addAttribute("isMyRecipe" , "true");
				}
				// 좋아요를 눌럿다면
				if(rService.selectRecipeLike(rNo, userId) !=null) {
					model.addAttribute("likeOn" , "true");
					return "/recipe/recipeInfo";
				}
				
			}
			// 로그인 상태가 아니라면 좋아요 검색시 false이므로 빈 좋아요 버튼이 보임
			model.addAttribute("likeOn" , "false");
			return "/recipe/recipeInfo";
		}
		
		// 레시피 댓글 생성
		@PostMapping(value = "/recipe/commentWrite")
		public String commentWrite(Model model, RecipeComent_DTO dto,HttpSession session) {
			
			
			if(session.getAttribute("login") !=null) {
				rcService.insert(dto);
				return "redirect:/recipe/recipeInfo/"+dto.getRecipe_no();
			}else {
				model.addAttribute("result", false);
				return "/member/login/loginView";
			}
			
		}
		
		// 레시피 댓글 수정
		@PostMapping(value = "/recipe/commentUpdate")
		public String commentUpadate(Model model , RecipeComent_DTO rc  , HttpSession session) {
			if(session.getAttribute("login") !=null) {
				rcService.rcUpdate(rc, rc.getComment_no());
				return "redirect:/recipe/recipeInfo/"+rc.getRecipe_no();
			}else {
				model.addAttribute("result", false);
				return "redirect:/member/login/loginView";
			}
			
			
		}
		
		// 레시피 댓글 삭제
		@GetMapping(value = "/recipe/recipeDeleteView")
		public String commentDeleteView(Model model , HttpSession session , int cNo ) {
			if(session.getAttribute("login") !=null) {
				model.addAttribute("cNo", cNo);
				return "/recipe/rcDelete";
			}else {
				model.addAttribute("result", false);
				return "redirect:/member/login/loginView";
			}
			
		}
		
		@ResponseBody
		@PostMapping(value = "/recipe/commentDeleteLogic")
		public Map<String, Object> commentDelete(Model model ,  @RequestParam Map<String, Object> data) {
			int cNo = Integer.parseInt((String)data.get("cNo"));
			data.put("rNo", rcService.selectRcno(cNo).getRecipe_no());
			rcService.delete(cNo);
			return data;
		}
		
		// 레시피 좋아요 검색
		@ResponseBody
		@PostMapping(value = "/recipe/checkLike")
		public String checkLike( @RequestParam Map<String, Object> param , HttpSession session) {
			
			USER_DTO login =  (USER_DTO)session.getAttribute("login");
			
			String likeOn = (String)param.get("likeOn");
			int rNo = Integer.parseInt((String)param.get("rNo"));
			
			
			//로그인이 되어잇다면
			if(param.get("userId") !=null && login !=null) {
				String userId = (String)param.get("userId");
				//좋아요가 눌러져잇다면 클릭시 좋아요 해제가 필요하므로
				if( rService.selectRecipeLike(rNo, userId)!=null ) {
					rService.deleteRecipeLike(rNo, userId);
					return "false";
				}else {
					rService.insertRecipeLike(rNo, userId);
					return "true";
				}
				
			}else {
				return "fail";
			}
			
		}
		
		
		// 레시피 정보 수정
		@GetMapping(value = "/recipe/recipeInfoEdit")
		public String recipeInfoEdit( @RequestParam int rNo , Model model , HttpSession session ) {
			
			if(session.getAttribute("login") !=null && rService.getRecipe(rNo) !=null) {
				
				USER_DTO login =(USER_DTO)session.getAttribute("login");
				Recipe_DTO recipe = rService.getRecipe(rNo);
				if( login.getUser_id().equals(recipe.getUser_id())) {
					// 해당 레시피를 등록한 사용자가 수정 버튼을 누른 경우
					System.out.println("recipe"+recipe);
					model.addAttribute("recipe" , recipe);
					return "/recipe/recipeInfoEdit";
				}
			}
			model.addAttribute("result", false);
			return "/member/login/loginView";
			
		}
		
		@PostMapping(value = "/recipe/recipeInfoEdit")
		public String recipeInfoEdit(Recipe_DTO recipe , Model model,MultipartFile file,HttpSession session,HttpServletRequest request) throws Exception {
			System.out.println("file = " + file);
			
			String str = recipe.getRecipe_date();
			
			System.out.println(recipe);
			rService.editRecipe(file, recipe,request);
			
			return "redirect:/recipe/recipeInfo/"+recipe.getRecipe_no();
		}
		
		// 레시피 삭제
		@GetMapping(value = "/recipe/recipeDelete")
		public String recipeDelete(Model model , int rNo) {
			model.addAttribute("rNo" , rNo);
			return "/recipe/recipeDelete";
		}
		
		@ResponseBody
		@PostMapping(value = "/recipe/recipeDelete")
		public void recipeDeleteLogic(Model model , int rNo) {
			rService.deleteRecipe(rNo);
		}
		
		
		// 레시피 댓글 DTO에 추가된 레시피 제목 업데이트
		@GetMapping("/admin/rcUpdate")
		public String rcUpate(Model model) {
			List<RecipeComent_DTO> list = rcService.selelctAll();
			for(RecipeComent_DTO dto : list) {
				dto.setRecipe_name(rService.selectRecipeRno(dto.getRecipe_no()).getRecipe_name());
				rcService.rcUpdate(dto, dto.getComment_no());
			}
			return "/";
		}
		
		
}
