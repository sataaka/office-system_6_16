package jp.co.example.dao.impl;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.UsersDao;
import jp.co.example.entity.Users;

@Repository
public class UsersDaoPg implements UsersDao{
	private static final String SELECT_BY_LOGINID_AND_PASSWORD = 
			"SELECT * from users WHERE login_id = :loginId AND passWord = :passWord";
	
	private static final String SELECT_USER_ID_FROM_USERS =
			"select user_id from users order by user_id";
	
	
	//プレースホルダの定義
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	private JdbcTemplate UserIdJdbcTemplate;
	
	public Users findByLogin(String loginId, String passWord) {
		String sql = SELECT_BY_LOGINID_AND_PASSWORD;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("loginId", loginId);
		param.addValue("passWord", passWord);
		List<Users> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Users>(Users.class));
		return resultList.isEmpty() ? null : resultList.get(0);
	}
	
	public List<Users> findByUserId() {
		String sql = SELECT_USER_ID_FROM_USERS;
		return UserIdJdbcTemplate.query(sql, new BeanPropertyRowMapper<Users>(Users.class));
	}
	
}
