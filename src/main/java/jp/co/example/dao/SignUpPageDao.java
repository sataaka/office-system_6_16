package jp.co.example.dao;


import java.util.List;


import jp.co.example.entity.Role;
import jp.co.example.entity.Users;


public interface SignUpPageDao {
	
	public void findByInserrtUsers(Users userData);
	
	public List<Role> findbyRoleId();
	
	public Users LoginIdMatch(String loginId);
	
}
