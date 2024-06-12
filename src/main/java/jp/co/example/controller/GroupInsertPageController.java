package jp.co.example.controller;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.controller.form.GroupInsertForm;
import jp.co.example.controller.form.ManagerPageForm;
import jp.co.example.entity.Groups;
import jp.co.example.entity.UserGroup;
import jp.co.example.entity.Users;
import jp.co.example.service.GroupsService;
import jp.co.example.service.UserGroupService;
import jp.co.example.service.UserInfoUpdateService;
import jp.co.example.service.UsersListPageService;

@Controller
public class GroupInsertPageController {

	@Autowired
	HttpSession session;
	
	
	@Autowired
	UsersListPageService usersListPageService;
	
	@Autowired
	GroupsService groupService;
	
	@Autowired
	UserInfoUpdateService userInfoUpdateService;
	
	@Autowired
	UserGroupService userGroupService;
	
	
	@RequestMapping(value="/groupInsertPage")
	public String groupInsertPage(@ModelAttribute("result") ManagerPageForm form, Model model) {
		
		
		return "m_GroupInsertPage";
	}
	
	@RequestMapping(value="/groupInsertName", method=RequestMethod.POST)
	public String groupInsertName(@Validated @ModelAttribute("result") GroupInsertForm  form,
			BindingResult bindingResult, Model model) {
		
		Groups groupNameMatch = groupService.groupNameMatch(form.getGroupName());
		
		if(bindingResult.hasErrors()) {
			
			return "m_GroupInsertPage";
		
		}
		
		if(groupNameMatch != null) {
			
			model.addAttribute("typeMatch", "ok");
			model.addAttribute("groupNameMatch", groupNameMatch);
			return "m_GroupInsertPage";
		}
			
		// グループの新規作成
		groupService.InsertGroupName(form.getGroupName());

		// 新規作成した、グループ名を次の画面に送る
		Groups InsertGroupName = groupService.findByGroupName(form.getGroupName());

		session.setAttribute("InsertGroupName", InsertGroupName);

		List<Users> userList = usersListPageService.findByAllUsersList();

		session.setAttribute("AllusersList", userList);
		
		return "m_GroupInsertPage_2";
	}
	
	@RequestMapping(value="/usersGroupInsert",method=RequestMethod.GET)
	public String getUserName(@ModelAttribute("result") ManagerPageForm form, Model model) {
		
		
		
		
		
		UserGroup userGroup = new UserGroup(form.getUserId(), form.getGroupId());
		
		userInfoUpdateService.InsertGroupUserAdd(userGroup);
		
		
		List<UserGroup> adduserName = userGroupService.selectUserName(form.getUserId(),form.getGroupId());
		
		session.setAttribute("addUserName", adduserName);
		
		
		
		
		return "m_GroupInsertPage_2";
	}
	
	
	
	@RequestMapping(value="/anserPage",method=RequestMethod.GET)
	public String anserPage(@ModelAttribute("result") ManagerPageForm form, Model model) {
		
		//グループを作成したユーザー名
		UserGroup userGroup = new UserGroup(form.getUserId(), form.getGroupId());
		
		userInfoUpdateService.InsertGroupUserAdd(userGroup);
		
		
		return "anserPage";
	
	}
	
	
}
