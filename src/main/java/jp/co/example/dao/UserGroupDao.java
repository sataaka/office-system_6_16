package jp.co.example.dao;

import java.util.List;



import jp.co.example.entity.UserGroup;

public interface UserGroupDao {
	public List <UserGroup> findByGroupID(String loginId);
	
	
	public UserGroup selectUserGroup(String groupName);
	
	public UserGroup groupSearch(Integer userId, String groupName);
	
	public List<UserGroup> findByUserGroupList(Integer groupId);
	
	public void DeleteUserGroup(Integer userId, Integer groupId);
	
	public void DeleteGroup(Integer groupId);
	
	//新規作成グループ内にユーザーを追加
	public void InsertGroupUserAdd(UserGroup userGroup);
	
	public List<UserGroup> selectUserName(Integer userId, Integer groupId);
}

