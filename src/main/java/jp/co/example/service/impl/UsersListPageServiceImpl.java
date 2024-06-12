package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.UserListPageDao;
import jp.co.example.entity.Groups;
import jp.co.example.entity.Role;
import jp.co.example.entity.Users;
import jp.co.example.service.UsersListPageService;

@Service
public class UsersListPageServiceImpl implements UsersListPageService {
	
	@Autowired
	private UserListPageDao userListPageDao;
	
	
	//仕様済み
	public List<Users> findByAllUsersList() {
		
		return userListPageDao.findByAllUsersList();
	}
	
	//仕様済み
	public List<Role> findbyRoleId() {
		
		return userListPageDao.findbyRoleId();
	}
	
	
	public Users findByUserNameSearch(String userName) {
		return userListPageDao.findByUserNameSearch(userName);
	}
	
	public Users findByUserId (Integer userId) {
		
		return userListPageDao.findByUserId(userId);
	}
	
	public List<Users> findByUsersUserGroupList(Integer userId) {
		
		return userListPageDao.findByUsersUserGroupList(userId);
	}

	public List<Groups> findByGroupsList() {
		return userListPageDao.findByGroupsList();
	}
	
	
}
