package jp.co.example.service.impl;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.UserGroupDao;
import jp.co.example.entity.UserGroup;
import jp.co.example.service.UserGroupService;
@Service
public class UserGroupServiceImpl implements UserGroupService{
	
	@Autowired
	private UserGroupDao userGroupDao;
	
	
	public List <UserGroup> findByGroupID(String loginId) {
		return userGroupDao.findByGroupID(loginId);
	}
	
	//管理者画面のグループ検索用の処理クラス
	public UserGroup selectUserGroup(String groupName) {
		  
		return userGroupDao.selectUserGroup(groupName);
	}
	
	public UserGroup groupSearch(Integer userId, String groupName) {
		return userGroupDao.groupSearch(userId, groupName);
	}
	
	public List<UserGroup> findByUserGroupList(Integer groupId) {
		
		return userGroupDao.findByUserGroupList(groupId);
	}
	
	public List<UserGroup> selectUserName(Integer userId, Integer groupId) {
		return userGroupDao.selectUserName(userId, groupId);
	}
}
