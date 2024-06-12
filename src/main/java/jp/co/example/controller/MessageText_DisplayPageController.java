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
import jp.co.example.controller.form.ManagerPageForm;
import jp.co.example.controller.form.SendMessageForm;
import jp.co.example.entity.Message;
import jp.co.example.entity.MessageInsert;
import jp.co.example.entity.SendMessage;
import jp.co.example.service.DeleteService;
import jp.co.example.service.MessageService;
import jp.co.example.service.UserInfoUpdateService;

@Controller
public class MessageText_DisplayPageController {

	@Autowired
	HttpSession session;
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	UserInfoUpdateService userInfoUpdateService;
	
	@Autowired
	DeleteService deleteService;
	
	@RequestMapping(value="/messageTextPage", method= RequestMethod.GET)
	public String groupSelect(@ModelAttribute("result") ManagerPageForm form, Model model) {
		
		Message message = messageService.messageLetter(form.getMessageId());
		List<SendMessage> sendMessageList = messageService.findBySendMessage(form.getMessageId());
		
		session.setAttribute("messageLetter", message);
		model.addAttribute("sendMessageList", sendMessageList);
		
		return "m_MessageTextPage";
	}
	
	/*追加案件　メッセージ内メッセージ送受信*/
	@RequestMapping(value="/sendMessageDelete", method= RequestMethod.POST)
	public String sendMessageDelete(@ModelAttribute("result") ManagerPageForm form, Model model) {
		
		deleteService.DeleteSendMessage(form.getMessageSend());
		
		return "anser_messageDeleterPage";
	}
	/*追加案件　メッセージ内メッセージ送受信*/
	@RequestMapping(value="/messagereply", method= RequestMethod.POST)
	public String messagereply(@ModelAttribute("result") ManagerPageForm form, Model model) {
		/*メッセージ内に返信を返すform*/
		return "m_SendMessageTextPage";
	}
	/*追加案件　メッセージ内メッセージ送受信*/
	@RequestMapping(value="/messagereplyPage", method= RequestMethod.POST)
	public String messagereplyPage(@ModelAttribute("result") ManagerPageForm form, Model model) {
		
		SendMessage sendMessage = new SendMessage(form.getMessageSend(),form.getMessageId(),
				  form.getSendmessageText(),form.getCreateDatatime(),form.getUserId());
		messageService.sendMessageInsert(sendMessage);
		List<SendMessage> sendMessageList = messageService.findBySendMessage(form.getMessageId());
		model.addAttribute("sendMessageList", sendMessageList);
		return "m_MessageTextPage";
	}
	
	@RequestMapping(value="/loginConfirm", method= RequestMethod.GET)
	public String returnManagerPage(@ModelAttribute("result") LoginPageForm form, Model model) {
		
		return "managerPage";
	}
	
	
	//一般ページ用のメッセージ一覧
	@RequestMapping(value="/nomalMessageTextPage", method= RequestMethod.GET)
	public String nomalMessageText(@ModelAttribute("result") ManagerPageForm form, Model model) {
		Message message = messageService.messageLetter(form.getMessageId());
		List<SendMessage> sendMessageList = messageService.findBySendMessage(form.getMessageId());
		
		session.setAttribute("messageLetter", message);		
		model.addAttribute("sendMessageList", sendMessageList);
		
		return "n_MessageTextPage";
	}
	
	/*追加案件　メッセージ内メッセージ送受信*/
	@RequestMapping(value="/nomalMessagereply", method= RequestMethod.POST)
	public String nomalMessagereply(@ModelAttribute("result") ManagerPageForm form, Model model) {
		/*メッセージ内に返信を返すform*/
		return "n_SendMessageTextPage";
	}
	/*追加案件　メッセージ内メッセージ送受信*/
	@RequestMapping(value="/nomalMessagereplyPage", method= RequestMethod.POST)
	public String nomalMessagereplyPage(@ModelAttribute("result") ManagerPageForm form, Model model) {
		
		SendMessage sendMessage = new SendMessage(form.getMessageSend(),form.getMessageId(),
				  form.getSendmessageText(),form.getCreateDatatime(),form.getUserId());
		messageService.sendMessageInsert(sendMessage);
		List<SendMessage> sendMessageList = messageService.findBySendMessage(form.getMessageId());
		model.addAttribute("sendMessageList", sendMessageList);
		return "n_MessageTextPage";
	}
	
	
	@RequestMapping(value="/returnNomalPage", method= RequestMethod.GET)
	public String returnNomalPage(@ModelAttribute("result") LoginPageForm form, Model model) {
		
		return "nomalPage";
	}
	
	
	
	//一般ページ用のメッセージ一覧
		@RequestMapping(value="/rederMessageTextPage", method= RequestMethod.GET)
		public String rederMessageText(@ModelAttribute("result") ManagerPageForm form, Model model) {
			Message message = messageService.messageLetter(form.getMessageId());
			List<SendMessage> sendMessageList = messageService.findBySendMessage(form.getMessageId());
			
			session.setAttribute("messageLetter", message);		
			model.addAttribute("sendMessageList", sendMessageList);
			
			return "r_MessageTextPage";
		}
		
		/*追加案件　メッセージ内メッセージ送受信*/
		@RequestMapping(value="/rederMessagereply", method= RequestMethod.POST)
		public String rederMessagereply(@ModelAttribute("result") ManagerPageForm form, Model model) {
			/*メッセージ内に返信を返すform*/
			return "r_SendMessageTextPage";
		}
		/*追加案件　メッセージ内メッセージ送受信*/
		@RequestMapping(value="/rederMessagereplyPage", method= RequestMethod.POST)
		public String rederMessagereplyPage(@ModelAttribute("result") ManagerPageForm form, Model model) {
			
			SendMessage sendMessage = new SendMessage(form.getMessageSend(),form.getMessageId(),
					  form.getSendmessageText(),form.getCreateDatatime(),form.getUserId());
			messageService.sendMessageInsert(sendMessage);
			List<SendMessage> sendMessageList = messageService.findBySendMessage(form.getMessageId());
			model.addAttribute("sendMessageList", sendMessageList);
			return "r_MessageTextPage";
		}
		
		
		@RequestMapping(value="/returnRederPage", method= RequestMethod.GET)
		public String returnRederPage(@ModelAttribute("result") LoginPageForm form, Model model) {
			
			return "rederPage";
		}
		
		
}
