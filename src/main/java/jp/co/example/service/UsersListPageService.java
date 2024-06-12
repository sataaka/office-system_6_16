package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.Groups;
import jp.co.example.entity.Role;
import jp.co.example.entity.Users;

public interface UsersListPageService {

	
	public List<Users> findByAllUsersList();
	
	public List<Role> findbyRoleId();
	
	public Users findByUserNameSearch(String userName);
	
	public Users findByUserId (Integer userId);

	public List<Users> findByUsersUserGroupList(Integer userId);
	
	public List<Groups> findByGroupsList();
}
