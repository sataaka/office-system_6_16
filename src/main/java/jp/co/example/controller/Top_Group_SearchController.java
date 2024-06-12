package jp.co.example.controller;




import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.controller.form.GroupSearchForm;
import jp.co.example.entity.UserGroup;
import jp.co.example.service.UserGroupService;


@Controller
public class Top_Group_SearchController {

	
	@Autowired
	HttpSession session;
	
	
	@Autowired
	UserGroupService userGroupService;
	
	@RequestMapping(value="/M_GroupSearch",method= RequestMethod.POST) 
	public String select(@Validated @ModelAttribute("result") GroupSearchForm form, 
			BindingResult bindingResult, Model model) {
	
		//グループ検索の際の、グループ判定
		UserGroup groupSearch = userGroupService.groupSearch(form.getUserId(), form.getGroupName());
		
			if(bindingResult.hasErrors()) {
				
				return "managerPage";
			}
			
			if(groupSearch == null) {
				model.addAttribute("typeMatch", "ng");
				return "managerPage";
			}
			
			model.addAttribute("typeMatch", "ok");
			model.addAttribute("groupSearch", groupSearch);
			return "managerPage";
			
	}
	
	
	
	@RequestMapping(value="/N_GroupSearch",method= RequestMethod.POST) 
	public String NomalSelect(@Validated @ModelAttribute("result") GroupSearchForm form,
			BindingResult bindingResult, Model model) {
		
		//グループ検索の際の、グループ判定
		UserGroup groupSearch = userGroupService.groupSearch(form.getUserId(), form.getGroupName());
	
			if(bindingResult.hasErrors()) {
				return "nomalPage";
			}
			
			if(groupSearch == null) {
				model.addAttribute("typeMatch", "ng");
				return "nomalPage";
			}
			
			model.addAttribute("typeMatch", "ok");
			model.addAttribute("groupSearch", groupSearch);
			return "nomalPage";
	}
	
	
	
	@RequestMapping(value="/R_GroupSearch",method= RequestMethod.POST) 
	public String rederSelect(@Validated @ModelAttribute("result") GroupSearchForm form,
			BindingResult bindingResult, Model model) {
		
		//グループ検索の際の、グループ判定
		UserGroup groupSearch = userGroupService.groupSearch(form.getUserId(), form.getGroupName());
		
			if(bindingResult.hasErrors()) {
				return "rederPage";
			}
		
			if(groupSearch == null) {
				model.addAttribute("typeMatch", "ng");
				return "rederPage";
			}
			
			model.addAttribute("typeMatch", "ok");
			model.addAttribute("groupSearch", groupSearch);
			return "rederPage";
	
	}
	
}
