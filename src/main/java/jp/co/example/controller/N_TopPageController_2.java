package jp.co.example.controller;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.controller.form.LoginPageForm;
import jp.co.example.entity.UserGroup;
import jp.co.example.service.UserGroupService;
@Controller
public class N_TopPageController_2 {

	
	
	@Autowired
	HttpSession session;
	
	
	@Autowired
	UserGroupService userGroupService;
	
	
	
	@RequestMapping(value="/nomalUserGroupList", method= RequestMethod.GET)
	public String nomalGroupSelect(@ModelAttribute("result") LoginPageForm form, Model model) {
		
		List<UserGroup> userGroupList = userGroupService.findByUserGroupList(form.getGroupId());
		
		session.setAttribute("userGroupList", userGroupList);
		
		return "n_GroupPage_2";
	}
	
	@RequestMapping(value="/nomalPage", method= RequestMethod.GET)
	public String nomalGorupPage(@ModelAttribute("result") LoginPageForm form, Model model) {
		
		
		
		
		return "nomalPage";
	}
}
