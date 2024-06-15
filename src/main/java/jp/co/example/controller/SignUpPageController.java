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
import jp.co.example.controller.form.SignUpPageForm;
import jp.co.example.entity.Role;
import jp.co.example.entity.Users;
import jp.co.example.service.SignUpPageService;
import jp.co.example.service.UsersService;

@Controller
public class SignUpPageController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	UsersService usersService;
	
	@Autowired
	SignUpPageService signUpPageService ;
	
	@RequestMapping({"/signUpPage"})
	public String signUp(@ModelAttribute("result") LoginPageForm form,Model model) {
		
		List<Role> roleList = signUpPageService .findbyRoleId();

		session.setAttribute("roleList", roleList);
		
		return "SignUpPage";
	}

	
	@RequestMapping(value="/signUp", method=RequestMethod.POST)
		public String InsertUsers(@Validated @ModelAttribute("result") SignUpPageForm form,
				BindingResult bindingResult, Model model) {
		
		Users LoginIdMatch = signUpPageService.LoginIdMatch(form.getLoginId());
		
		
		if (bindingResult.hasErrors()) {
			return "SignUpPage";
		}
		
		//form.getLoginId().equals(LoginIdMatch.getLoginId())
		if (LoginIdMatch != null) {

			model.addAttribute("typeMatch", "ok");
			model.addAttribute("LoginIdMatch", LoginIdMatch);

			return "SignUpPage";
		}
		
		Users userData = new Users(form.getUserName(), form.getLoginId(), form.getPassWord(), form.getTelNo(),
				form.getRoleId());

		signUpPageService.findByInserrtUsers(userData);

		return "anserPage";
		
		
	}
	
	
}
