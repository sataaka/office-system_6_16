package jp.co.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.example.dao.MessageDao;
import jp.co.example.dao.UserGroupDao;
import jp.co.example.dao.UserListPageDao;
import jp.co.example.entity.MessageInsert;
import jp.co.example.entity.UserGroup;
import jp.co.example.service.UserInfoUpdateService;

@Service
@Transactional
public class UserInfoUpdateServiceImpl implements UserInfoUpdateService {

	@Autowired
	private UserListPageDao userListPageDao;
	
	
	@Autowired
	UserGroupDao userGroupDao;
	
	@Autowired
	MessageDao messageDao;
	
	public void findByUserInfoUpdate(Integer roleId, Integer userId) {
		
		userListPageDao.findByUserInfoUpdate(roleId, userId);
	}
	
	public void findByUserGorupInsert(UserGroup userGroup) {
		 userListPageDao.findByUserGorupInsert(userGroup);
	}
	
	//新規作成グループ内にユーザーを追加
	public void InsertGroupUserAdd(UserGroup userGroup) {
		userGroupDao.InsertGroupUserAdd(userGroup);
	}
	
	//メッセージの新規作成
	public void InsertMessage(MessageInsert messageInsert) {
		messageDao.InsertMessage(messageInsert);
	}
}
