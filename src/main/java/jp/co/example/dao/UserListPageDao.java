package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.Groups;
import jp.co.example.entity.Role;
import jp.co.example.entity.UserGroup;
import jp.co.example.entity.Users;

public interface UserListPageDao {
	
		public List<Users> findByAllUsersList();
		
		public List<Role> findbyRoleId();
		
		public Users findByUserNameSearch(String userName);
		
		public Users findByUserId (Integer userId);
		
		public void findByUserInfoUpdate(Integer roleId, Integer userId);
		
		public List<Users> findByUsersUserGroupList(Integer userId);
		
		public List<Groups> findByGroupsList();
		
		public void findByUserGorupInsert(UserGroup userGroup);
		
		public void usersDelete(Integer userId);
}
