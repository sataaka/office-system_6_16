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

import jp.co.example.controller.form.LoginPageForm;
import jp.co.example.controller.form.UserNameSearchForm;
import jp.co.example.entity.Groups;
import jp.co.example.entity.Role;
import jp.co.example.entity.UserGroup;
import jp.co.example.entity.Users;
import jp.co.example.service.DeleteService;
import jp.co.example.service.SignUpPageService;
import jp.co.example.service.UserInfoUpdateService;
import jp.co.example.service.UsersListPageService;


@Controller
public class UsersList_DisplayPageController {
	
	
	@Autowired
	HttpSession session;
	
	@Autowired
	UsersListPageService usersListPageService;
	
	@Autowired
	SignUpPageService insertUserService;
	
	@Autowired
	UserInfoUpdateService userInfoUpdateService;
	
	@Autowired
	DeleteService deleteService;
	
	@RequestMapping(value="/users")
	public String group(@ModelAttribute("result") LoginPageForm form, Model model) {
		
		
		List<Users> usersList = usersListPageService.findByAllUsersList();
		
		List<Role> roleList = usersListPageService.findbyRoleId();
		
		
		session.setAttribute("usersList", usersList);
		
		session.setAttribute("roleList", roleList);	
		
		
		
		return "m_UserListPage";
	}

	
	@RequestMapping(value="/usersSelect", method=RequestMethod.POST)
	public String select(@Validated @ModelAttribute("result") UserNameSearchForm form, 
			BindingResult bindingResult, Model model) {
		
		Users userNameSearch = usersListPageService.findByUserNameSearch(form.getUserName());
		
			if(bindingResult.hasErrors()) {
				
				
				return "m_UserListPage";
			}
			
			if(userNameSearch == null) {
				model.addAttribute("typeMatch", "ng");
				
				return "m_UserListPage";
			}
			
			model.addAttribute("typeMatch", "ok");
			
			model.addAttribute("userNameSearch", userNameSearch);
		
		return "m_UserListPage";
		
	}
		
	
	@RequestMapping(value="/userinfo")
	public String userInfo(@ModelAttribute("result") LoginPageForm form, Model model) {
		
		
		Users usersInfo = usersListPageService.findByUserId(form.getUserId());
		
		session.setAttribute("usersInfo", usersInfo);
		
		return "m_UserListPage_2";
		
	}
	
	
	@RequestMapping(value="/userinfoUpdata")
	public String userInfoUpdata(@ModelAttribute("result") LoginPageForm form, Model model) {
		
		if(form.getRoleId() == null) {
			model.addAttribute("typeMatch", "ng");
			return "m_UserListPage_2";
		}
		
		model.addAttribute("typeMatch", "usersUpDate");
		
		userInfoUpdateService.findByUserInfoUpdate(form.getRoleId(), form.getUserId());
		
		
		return "anser_user_Info_Update_Page";
	}
	
	
	@RequestMapping(value="/usersDelete")
	public String usersDelete(@ModelAttribute("result") LoginPageForm form, Model model) {
		
		
		deleteService.usersDelete(form.getUserId());
		model.addAttribute("typeMatch", "usersDelete");
		
		return "anser_user_Info_Update_Page";
	}
	
	
	@RequestMapping(value="/userGroupInsert")
	public String userGroupUpdate(@ModelAttribute("result") LoginPageForm form, Model model) {
		
		List<Users> usersUserGroupList = usersListPageService.findByUsersUserGroupList(form.getUserId());
		
		List<Groups> groupsAllList = usersListPageService.findByGroupsList();
		
		session.setAttribute("usersUserGroupList", usersUserGroupList);
		
		session.setAttribute("groupsAllList", groupsAllList);
		
		return "m_UserListPage_3";
	}

	
	@RequestMapping(value="/userInfoUserGroup")
	public String UserGroupInsert(@ModelAttribute("result") LoginPageForm form, Model model) {
		
		UserGroup userGroup = new UserGroup(form.getUserId(), form.getGroupId());
		userInfoUpdateService.findByUserGorupInsert(userGroup);
		
		return "m_UserListPage_2";
	}
}
