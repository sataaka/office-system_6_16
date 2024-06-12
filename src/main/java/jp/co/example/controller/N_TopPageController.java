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

import jp.co.example.controller.form.ManagerPageForm;
import jp.co.example.entity.Groups;
import jp.co.example.entity.Message;
import jp.co.example.entity.UserGroup;
import jp.co.example.service.GroupsService;
import jp.co.example.service.MessageService;
import jp.co.example.service.UserGroupService;
import jp.co.example.service.UsersService;

@Controller
public class N_TopPageController {

	
	@Autowired
	HttpSession session;
	
	@Autowired
	UsersService usersService;
	
	@Autowired
	UserGroupService userGroupService;
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	GroupsService groupsService;
	
	
	@RequestMapping(value="/nomalGroupPage",method= RequestMethod.POST)
	public String nomalGroupPage(@ModelAttribute("result") ManagerPageForm form, Model model) {
		 
		UserGroup userGroup = userGroupService.selectUserGroup(form.getGroupName());	
		 Message message = usersService.findGroupNameDisplay(form.getGroupId());				
		 List<Message> list = usersService.findByMessageList(form.getGroupId(),form.getMessageTitle());	
		 Groups groupsName = groupsService.groupNameList(form.getGroupId());
		
		 	 session.setAttribute("userGroup", userGroup);		
			 session.setAttribute("messageGroupName", message);	//ログイン時に保存されたグループIDが一致したらgroupNameがgurpuPageに遷移される
			 session.setAttribute("messageList", list);			//グループIDが一致したら、グループIDに紐づいたメッセージ一覧が表示される
			 session.setAttribute("groupsNameList", groupsName);
		
			 
		return "n_GroupPage";
	}

	
	
	@RequestMapping(value="/nomalMessageSearch", method= RequestMethod.POST)
	public String nomalGroupSelect(@Validated @ModelAttribute("result") ManagerPageForm form,
			BindingResult bindingResult, Model model) {
		 
		Message messageInspection = messageService.findByGroupId_MassegeTitleSerach(
				form.getInput(), form.getGroupId());
		
		List <Message> messageSerach = messageService.findByGroupId_MassegeTitleSerachTest(
				form.getInput(), form.getGroupId());
			
			if (bindingResult.hasErrors()) {
				return "n_GroupPage";
			}
		
			if (messageInspection == null) {
				model.addAttribute("typeMatch", "ng");
			}

			model.addAttribute("messageSerach", messageSerach);
			 
			return "n_GroupPage";
		
	}

}
