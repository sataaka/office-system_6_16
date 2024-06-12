package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.Message;
import jp.co.example.entity.MessageInsert;
import jp.co.example.entity.SendMessage;


public interface MessageDao {
	public Message findGroupNameDisplay(Integer groupId);	//groupPageに送る為のDBを取得する為のメソッド
	
	public List<Message> findByMessageList(Integer groupId, String Message);	//groupIdに紐づいたメッセージリストをDBから取得する為のメソッド
	
	public Message messageLetter(Integer messageId);
	
	public List<Message> messageRepry(Integer messageId);
	
	
	
	public Message findByMassegeTitleSerach(String input);
	//グループページ内の検索ページの検証用
	public Message MassegeTitleSerachTest(String input);
	
	//グループページ内の検索ページの作成
	public List<Message> findByMassegeTitleSerachTest(String input);
	
	public Message findByGroupId_MassegeTitleSerach(String input, Integer groupId);
	
	public List<Message> findByGroupId_MassegeTitleSerachTest(String input, Integer groupId);
	
	public Message findByMessageCreatorUserNameSerach(Integer userId, String userName);
	
	//UserIdに紐づくメッセージリスト全件リスト
	public List<Message> findByAllMessageList();
	
	//メッセージIDに紐づいたメッセージ情報を削除
	public void  DeleteMessage(Integer messageId);
	
	public void InsertMessage(MessageInsert messageINsert);
	
	/*新たにメッセージ内でメッセージを返すメソッド*/
	public void sendMessageInsert(SendMessage sendMessage);
	
	public List<SendMessage> findBySendMessage(Integer messageId);
	
	public void  DeleteSendMessage(Integer messageSend);
	
	
}
