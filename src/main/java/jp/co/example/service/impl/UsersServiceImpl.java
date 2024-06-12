package jp.co.example.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.MessageDao;
import jp.co.example.dao.UsersDao;
import jp.co.example.entity.Message;
import jp.co.example.entity.Users;
import jp.co.example.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UsersDao usersDao;
	
	
	@Autowired
	private MessageDao messageDao;
	
	
	public List<Users> findByUserId() {
		return usersDao.findByUserId();
	}
	
	public Users findByLogin(String loginId, String passWord) {
		return usersDao.findByLogin(loginId, passWord);
	}
	
	
    public Message findGroupNameDisplay(Integer groupId) {
		return messageDao.findGroupNameDisplay(groupId);
	}
	
    
    public List<Message> findByMessageList(Integer groupId, String messageTitle){
		return messageDao.findByMessageList(groupId, messageTitle);
	}
	

}
