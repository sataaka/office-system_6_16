package jp.co.example.service;



import java.util.List;

import jp.co.example.entity.Message;
import jp.co.example.entity.SendMessage;

public interface MessageService {
	
	//messageTextを表示するメソッド
	public Message messageLetter(Integer messageId);
	
	public List<Message> messageRepry(Integer messageId);

	
	//グループページ内の検索ページの作成
		
		//グループページ内の検索ページの作成
		public List<Message> findByMassegeTitleSerachTest(String input);
		//グループページ内の検索ページの検証用
		public Message MassegeTitleSerachTest(String input);
		
		public Message findByGroupId_MassegeTitleSerach(String input, Integer groupId);
		
		public List<Message> findByGroupId_MassegeTitleSerachTest(String input, Integer groupId);
		
		public Message findByMessageCreatorUserNameSerach(Integer userId, String userName);
		
		public List<Message> findByAllMessageList();
		
		/*新たにメッセージ内でメッセージを返すメソッド*/
		public void sendMessageInsert(SendMessage sendMessage);
		
		public List<SendMessage> findBySendMessage(Integer messageId);
		
		
}
