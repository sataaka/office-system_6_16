package jp.co.example.service;


import java.util.List;


import jp.co.example.entity.Role;
import jp.co.example.entity.Users;


public interface SignUpPageService {

	
	public void findByInserrtUsers(Users userData);

	public List<Role> findbyRoleId();
	
	public Users LoginIdMatch(String loginId);
	
}
