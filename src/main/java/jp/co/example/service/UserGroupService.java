package jp.co.example.service;




import java.util.List;

import jp.co.example.entity.UserGroup;


public interface UserGroupService {
	
	public List <UserGroup> findByGroupID(String loginId);
	
	//管理者画面のグループ検索用の処理クラス
	public UserGroup selectUserGroup(String groupName);
	
	public UserGroup groupSearch(Integer userId, String groupName);
	
	public List<UserGroup> findByUserGroupList(Integer groupId);
	
	//登録したグループに追加したユーザーを表示
	public List<UserGroup> selectUserName(Integer userId, Integer groupId);
}
