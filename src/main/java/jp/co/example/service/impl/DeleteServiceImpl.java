package jp.co.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.example.dao.MessageDao;
import jp.co.example.dao.UserGroupDao;
import jp.co.example.dao.UserListPageDao;
import jp.co.example.service.DeleteService;

@Service
@Transactional
public class DeleteServiceImpl implements DeleteService{

	@Autowired
	private UserGroupDao userGroupDaoDelete;
	
	@Autowired
	UserListPageDao userListPageDao;
	
	@Autowired
	MessageDao messageDao;
	
	public void DeleteUserGroup(Integer userId, Integer groupId) {
		
		 userGroupDaoDelete.DeleteUserGroup(userId, groupId);
	}
	
	public void DeleteGroup(Integer groupId) {
		
		userGroupDaoDelete.DeleteGroup(groupId);
	}
	
	public void usersDelete(Integer userId) {
		
		userListPageDao.usersDelete(userId);
	}
	
	public void  DeleteMessage(Integer messageId) {
		
		messageDao.DeleteMessage(messageId);
		
	}
	
	public void  DeleteSendMessage(Integer messageSend) {
		messageDao.DeleteSendMessage(messageSend);
	}
	
	
}
