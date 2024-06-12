package jp.co.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.controller.form.ManagerPageForm;
import jp.co.example.entity.UserGroup;
import jp.co.example.service.DeleteService;
import jp.co.example.service.UserGroupService;

@Controller
public class M_TopPageController_2 {

	@Autowired
	HttpSession session;
	
	
	@Autowired
	UserGroupService userGroupService;
	
	@Autowired
	DeleteService deleteService;
	
	
	@RequestMapping(value="/InUserGroupList", method= RequestMethod.GET)
	public String InUserGroupList(@ModelAttribute("result") ManagerPageForm form, Model model) {
		
		List<UserGroup> InUserGroupList = userGroupService.findByUserGroupList(form.getGroupId());
		
		session.setAttribute("InUserGroupList", InUserGroupList);
		
		return "m_GroupPage_2";
	}
	
	@RequestMapping(value="/UserGroupDelete", method= RequestMethod.POST)
	public String userGroupDelete(@ModelAttribute("result") ManagerPageForm form, Model model) {
		
		model.addAttribute("typeMatch", "usersDelete");
		
		deleteService.DeleteUserGroup(form.getUserId(), form.getGroupId());
		
		return "anser_withdrawal_from_groupPage";
	}
	
	
}
