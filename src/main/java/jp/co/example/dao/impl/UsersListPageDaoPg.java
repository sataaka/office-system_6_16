package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.UserListPageDao;
import jp.co.example.entity.Groups;
import jp.co.example.entity.Role;
import jp.co.example.entity.UserGroup;
import jp.co.example.entity.Users;

@Repository
public class UsersListPageDaoPg implements UserListPageDao {

	//仕様済み
	private static final String SELECT_ALL_USERS_LIST =
			"SELECT * FROM users ORDER BY user_id";
	
	//仕様済み
	private static final String SELECT_ALL_ROLE =
			"select * from role order by role_id";
	
	//仕様済み
	private static final String SELECT_ALL_USERS_SEACRH =
			"SELECT * FROM users WHERE user_name LIKE :userName";

	//仕様済み
	private static final String SELECT_USER_Id_USERS =
			"SELECT user_id,user_name,login_id,password,tel_no,users.role_id, role.role_name"
			+ " FROM users JOIN role"
			+ " ON users.role_id = role.role_id WHERE user_id = :userId";

	//仕様済み
	private static final String USERS_UPDATE =
			"UPDATE users SET role_id = :roleId WHERE user_id = :userId";
	
	//仕様済み
	private static final String USERS_USER_GROUP_LIST =
			"SELECT user_group.user_id,user_group.group_id,users.user_name,groups.group_name"
			+ " FROM user_group JOIN users ON user_group.user_id = users.user_id"
			+ " RIGHT JOIN groups ON user_group.group_id = groups.group_id"
			+ " WHERE user_group.user_id = :userId";
	
	//仕様済み
	private static final String GORUPS_ALL_LIST =
			"SELECT * FROM groups ORDER BY group_id";
	
	//仕様済み
	private static final String GROUPS_INSERT =
			"INSERT INTO user_group (user_id, group_id)"
			+ " VALUES(:userId, :groupId)";
	
	//仕様済み
	private static final String USERS_DELETE =
			"DELETE FROM users WHERE user_id = :userId";
	
	private static final String USER_GROUP_DELETE =
			"DELETE FROM user_group WHERE user_id = :userId";
	
	private static final String MESSAGE_USER_DELETE =
			"DELETE FROM message WHERE user_id = :userId";
	
	private static final String SENDMESSAGE_DELETE =
			"delete from sendmessage where user_id = :userId";
	
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	private JdbcTemplate JdbcTemplate;
	
	
	//仕様済み
	public List<Users> findByAllUsersList() {
		
		String sql = SELECT_ALL_USERS_LIST;
		return JdbcTemplate.query(sql, new BeanPropertyRowMapper<Users>(Users.class));
	}
	
	//仕様済み
	public List<Role> findbyRoleId() {
		String sql = SELECT_ALL_ROLE;
		
		return JdbcTemplate.query(sql, new BeanPropertyRowMapper<Role>(Role.class));
	}
	
	
	//仕様済み
	public Users findByUserNameSearch(String userName) {
		String sql = SELECT_ALL_USERS_SEACRH;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userName", "%" + userName + "%");
		List<Users> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Users>(Users.class));
		return resultList.isEmpty() ? null : resultList.get(0);
	}

	//仕様済み
	public Users findByUserId (Integer userId) {
		
		String sql = SELECT_USER_Id_USERS;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);
		List<Users> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Users>(Users.class));
		return resultList.isEmpty() ? null : resultList.get(0);
	
	}
	
	//仕様済み
	public void findByUserInfoUpdate(Integer roleId, Integer userId) {
		String sql = USERS_UPDATE;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("roleId", roleId);
		param.addValue("userId", userId);
		
		jdbcTemplate.update(sql, param);
	}
	
	//仕様済み
	public List<Users> findByUsersUserGroupList(Integer userId) {
		String sql = USERS_USER_GROUP_LIST;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);
		return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Users>(Users.class));
		
	}
	
	//仕様済み
	public List<Groups> findByGroupsList() {
		String sql = GORUPS_ALL_LIST;
		return JdbcTemplate.query(sql, new BeanPropertyRowMapper<Groups>(Groups.class));
	}
	
	//仕様済み
	public void findByUserGorupInsert(UserGroup userGroup) {
		String sql = GROUPS_INSERT;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userGroup.getUserId());
		param.addValue("groupId", userGroup.getGroupId());
		
		jdbcTemplate.update(sql, param);
		
	}
	
	//仕様済み
	public void usersDelete(Integer userId) {
		String sql1 = USER_GROUP_DELETE;
		String sql2 = MESSAGE_USER_DELETE;
		String sql3 = SENDMESSAGE_DELETE;
		String sql4 = USERS_DELETE;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);
		jdbcTemplate.update(sql1, param);
		jdbcTemplate.update(sql2, param);
		jdbcTemplate.update(sql3, param);
		jdbcTemplate.update(sql4, param);
	}
	
}
