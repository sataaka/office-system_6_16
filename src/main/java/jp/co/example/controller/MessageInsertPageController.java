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

import jp.co.example.controller.form.MessageInsertPageForm;
import jp.co.example.entity.Groups;
import jp.co.example.entity.MessageInsert;
import jp.co.example.service.GroupsService;
import jp.co.example.service.UserInfoUpdateService;

@Controller
public class MessageInsertPageController {

	
	@Autowired
	HttpSession session;
	
	
	@Autowired
	UserInfoUpdateService userInfoUpdateService;
	
	@Autowired
	GroupsService groupService;
	
	
	@RequestMapping(value="/messageInsertPage")
	public String messageInsertPage(@ModelAttribute("result") MessageInsertPageForm form, Model model) {
		
		
		List<Groups> AllGroups = groupService.findByALLGorups();
		
		session.setAttribute("AllGroups", AllGroups);
		
		
		
		return "m_MessageInsertPage";
	}
	
	
	@RequestMapping(value="/messageInsert",method=RequestMethod.POST)
	public String messageInsert(@Validated @ModelAttribute("result") MessageInsertPageForm form, 
			BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			return "m_MessageInsertPage";
		}
		
		
		MessageInsert message = new MessageInsert(form.getMessageTitle(),form.getMessageText(),
				 form.getCreateDatatime(),form.getUserId(), form.getGroupId());
		
		userInfoUpdateService.InsertMessage(message);
		
		return "anserPage";
	}
}
