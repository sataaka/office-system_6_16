package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.example.dao.GroupsDao;
import jp.co.example.entity.Groups;
import jp.co.example.service.GroupsService;
@Service
@Transactional
public class GroupsServiceImpl implements GroupsService{
	@Autowired
	private GroupsDao groupsDao;
	
	//上書き処理インターフェース
	@Override
	public List<Groups> findGroupName() {
		return groupsDao.findGroupName();
	}
	
	public void InsertGroupName(String groupName) {
		groupsDao.InsertGroupName(groupName);
	}
	
	public Groups findByGroupName(String groupName) {
		return groupsDao.findByGroupName(groupName);
	}
	
	public List<Groups> findByALLGorups() {
		return groupsDao.findByALLGorups();
	}
	
	public Groups groupNameList(Integer groupId) {
		return groupsDao.groupNameList(groupId);
	}
	
	public Groups groupNameMatch(String groupName) {
		return groupsDao.groupNameMatch(groupName);
	}
}
