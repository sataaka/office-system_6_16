package jp.co.example.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.MessageDao;
import jp.co.example.entity.Message;
import jp.co.example.entity.SendMessage;
import jp.co.example.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService{

	
	@Autowired
	private MessageDao messageDao;
	
	public Message messageLetter(Integer messageId) {
		
		return messageDao.messageLetter(messageId);
		
	}
	
	public List<Message> messageRepry(Integer messageId) {
		return messageDao.messageRepry(messageId);
	}
	
	//グループページ内の検索ページの作成
		
	
		public List<Message> findByMassegeTitleSerachTest(String input){
			return messageDao.findByMassegeTitleSerachTest(input);
		}
		
		public Message MassegeTitleSerachTest(String input) {
			return messageDao.MassegeTitleSerachTest(input);
		}
		
		public Message findByGroupId_MassegeTitleSerach(String input, Integer groupId) {
			return messageDao.findByGroupId_MassegeTitleSerach(input, groupId);
		}
		
		public List<Message> findByGroupId_MassegeTitleSerachTest(String input, Integer groupId){
			return messageDao.findByGroupId_MassegeTitleSerachTest(input, groupId);
		}
		
		
		public Message findByMessageCreatorUserNameSerach(Integer userId, String userName) {
			return messageDao.findByMessageCreatorUserNameSerach(userId, userName);
		}
		
		
		//UserIdに紐づくメッセージリスト全件リスト
		public List<Message> findByAllMessageList() {
			
			return messageDao.findByAllMessageList();
		}
		
		/*新たにメッセージ内でメッセージを返すメソッド*/
		public void sendMessageInsert(SendMessage sendMessage) {
			messageDao.sendMessageInsert(sendMessage);
		}
		
		public List<SendMessage> findBySendMessage(Integer messageId){
			return messageDao.findBySendMessage(messageId);
		}
		

		
}
