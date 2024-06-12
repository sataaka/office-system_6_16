package jp.co.example.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.example.dao.SignUpPageDao;
import jp.co.example.entity.Role;
import jp.co.example.entity.Users;
import jp.co.example.service.SignUpPageService;

@Service
@Transactional
public class SignUpPageServiceImpl implements SignUpPageService{

	@Autowired
	private SignUpPageDao signUpPageDao;
	
	
	public void findByInserrtUsers(Users userData) {
		signUpPageDao.findByInserrtUsers(userData);
	}
	
	public List<Role> findbyRoleId(){
		return signUpPageDao.findbyRoleId();
	}
	
	public Users LoginIdMatch(String loginId) {
		return signUpPageDao.LoginIdMatch(loginId);
	}
	
}
