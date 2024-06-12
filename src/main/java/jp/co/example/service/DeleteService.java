package jp.co.example.service;

public interface DeleteService {

	public void DeleteUserGroup(Integer userId, Integer groupId);
	
	public void DeleteGroup(Integer groupId);
	
	public void usersDelete(Integer userId);
	
	//メッセージIDに紐づくメッセージ情報を削除
	public void  DeleteMessage(Integer messageId);
	
	public void  DeleteSendMessage(Integer messageSend);
}
