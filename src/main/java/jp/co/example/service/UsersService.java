package jp.co.example.service;

import java.util.List;


import jp.co.example.entity.Message;
import jp.co.example.entity.Users;

public interface UsersService {
	
	public List<Users> findByUserId();
	
	public Users findByLogin(String loginId, String passWord);
	
	public Message findGroupNameDisplay(Integer groupId);
	
	public List<Message> findByMessageList(Integer groupId, String messageTitle);
}
