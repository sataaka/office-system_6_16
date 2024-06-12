package jp.co.example.dao.impl;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.SignUpPageDao;
import jp.co.example.entity.Role;
import jp.co.example.entity.Users;


@Repository
public class SignUpPageDaoPg implements SignUpPageDao{
	
	private static final String INSERT_USERS =
			"insert into users (user_name, login_id, password, tel_no, role_id)"
			+ " values(:userName,:loginId, :passWord, :telNo ,:roleId)";
	
	
	private static final String SELECT_ALL_ROLE =
			"select * from role order by role_id";
	
	
	private static final String SELCT_ALL_LOGIN_ID =
			"select login_id from users where login_id = :loginId";
	
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	
	@Autowired
	private JdbcTemplate RoleJdbcTemplate;
	
	public void findByInserrtUsers(Users userData) {
		
		String sql = INSERT_USERS ;
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		param.addValue("userName", userData.getUserName());
		param.addValue("loginId", userData.getLoginId());
		param.addValue("passWord", userData.getPassWord());
		param.addValue("telNo", userData.getTelNo());
		param.addValue("roleId", userData.getRoleId());
		
		jdbcTemplate.update(sql, param);
	}
	
	public List<Role> findbyRoleId() {
		String sql = SELECT_ALL_ROLE;
		
		return RoleJdbcTemplate.query(sql, new BeanPropertyRowMapper<Role>(Role.class));
	}
	
	public Users LoginIdMatch(String loginId) {
		String sql = SELCT_ALL_LOGIN_ID;
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("loginId", loginId);
		
		List<Users> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Users>(Users.class));
		return resultList.isEmpty() ? null : resultList.get(0);
	}
}
