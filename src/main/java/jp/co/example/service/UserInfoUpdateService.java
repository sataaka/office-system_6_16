package jp.co.example.service;

import jp.co.example.entity.MessageInsert;
import jp.co.example.entity.UserGroup;

public interface UserInfoUpdateService {
	
	public void findByUserInfoUpdate(Integer roleId, Integer userId);
	
	public void findByUserGorupInsert(UserGroup userGroup);
	
	//新規作成グループ内にユーザーを追加
	public void InsertGroupUserAdd(UserGroup userGroup);
	
	//メッセージの新規作成
	public void InsertMessage(MessageInsert messageInsert);
}
