package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.Groups;

public interface GroupsService {
	public List<Groups> findGroupName();
	
	public void InsertGroupName(String groupName);
	
	public Groups findByGroupName(String groupName);
	
	public List<Groups> findByALLGorups();
	
	public Groups groupNameList(Integer groupId);
	
	public Groups groupNameMatch(String groupName);
}
