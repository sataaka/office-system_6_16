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
import jp.co.example.entity.Message;
import jp.co.example.service.DeleteService;
import jp.co.example.service.MessageService;


@Controller
public class Message_DisplayPageController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	DeleteService deleteService;
	
	@RequestMapping(value="/messagePage")
	public String messagePage(@ModelAttribute("result") ManagerPageForm form, Model model) {
		
		List<Message> messageAllList = messageService.findByAllMessageList();
		
		
		session.setAttribute("messageAllList", messageAllList);
		
		
		return "m_messagePage";
	}
	
	
	
	@RequestMapping(value="/messageText", method= RequestMethod.GET)
	public String groupSelect(@ModelAttribute("result") ManagerPageForm form, Model model) {
		Message message = messageService.messageLetter(form.getMessageId());
		
		session.setAttribute("messageLetter", message);		
		
		return "m_MessageTextPage";
	}
	
	
	
	@RequestMapping(value="/messageDelete", method= RequestMethod.POST)
	public String messageDelete(@ModelAttribute("result") ManagerPageForm form, Model model) {
		
		deleteService.DeleteMessage(form.getMessageId());
		
		return "anser_messageDeleterPage";
	}
	
	
	
	@RequestMapping(value="/messageSerach")
	public String messageSerach(@Validated @ModelAttribute("result") ManagerPageForm form, 
			BindingResult bindingResult,Model model) {
		
		//メッセージリストを表示する為の検証
		Message messageInspection = messageService.MassegeTitleSerachTest(form.getInput());
		
		List<Message> messageSerach = messageService.findByMassegeTitleSerachTest(form.getInput());
		
		if(bindingResult.hasErrors()) {
			
			return "m_messagePage";
		}
		
		if(messageInspection == null) {
			model.addAttribute("typeMatch", "ng");
			
			return "m_messagePage";
		}
					
		model.addAttribute("messageSerach", messageSerach);
				
		return "m_messagePage";
	}
	
	
	
	
}
