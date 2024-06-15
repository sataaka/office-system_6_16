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
import jp.co.example.entity.UserGroup;
import jp.co.example.entity.Users;
import jp.co.example.service.GroupsService;
import jp.co.example.service.UserGroupService;
import jp.co.example.service.UsersService;

@Controller
public class LoginPageController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	UsersService usersService;		
	
	@Autowired
	GroupsService groupService;
	
	@Autowired
	UserGroupService userGroupService;
	//このコントロールクラスで、URLをマッピング、下記メソッドを紐でけるloginPageへ推移する
	@RequestMapping({"/login"})
	public String login(@ModelAttribute("result") LoginPageForm form, Model model) {
		
			List<Users> userId = usersService.findByUserId();
			session.setAttribute("userIdList", userId);
		
		return "loginPage";
	}
	
	
	
	@RequestMapping(value="/logOut") 
	public String loginSessionInvalidate(@ModelAttribute("result") LoginPageForm form, Model model) {
		
		session.invalidate();
		return "loginPage";
	}
	
	
	
	@RequestMapping(value="/loginConfirm", method=RequestMethod.POST)
	public String test(@Validated @ModelAttribute("result") LoginPageForm form, 
			BindingResult bindingResult, Model model) {
		
		//ログインIDとパスワードが一致したら、ユーザー情報を取得する
		Users users = usersService.findByLogin(form.getLoginId(), form.getPassWord());
		
		//パスワードが一致したら、グループ情報を取得する
		List <UserGroup> list = userGroupService.findByGroupID(form.getLoginId());
		
			//usersテーブルの情報と一致しなかった場合ログインページに止まる。
			if(bindingResult.hasErrors()) {
				
				return "loginPage";
			}
			
			if(users == null) {
				model.addAttribute("typeMatch", "ng");
				return "loginPage";
			}
			
				switch (users.getRoleId()) {
				
				case 1:
					
					users.getRoleId().equals(1);
					session.setAttribute("users", users);
					session.setAttribute("GroupList", list);
						
					return "managerPage";
				
				case 2:
					
					users.getRoleId().equals(2);
					session.setAttribute("users", users);
					session.setAttribute("GroupList", list);
					
					return "nomalPage";
				
				case 3:
					
					users.getRoleId().equals(3);
					session.setAttribute("users", users);
					session.setAttribute("GroupList", list);
					
					return "rederPage";
				}
				
			
			return "loginPage";
						
	}
	
	
}
