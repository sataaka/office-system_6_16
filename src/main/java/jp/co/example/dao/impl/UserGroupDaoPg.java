package jp.co.example.dao.impl;



import java.util.List;








import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import jp.co.example.dao.UserGroupDao;
import jp.co.example.entity.UserGroup;



@Repository
public class UserGroupDaoPg implements UserGroupDao{
	
	//groups.groupId,groupNameを取得
	private static final String GROUP_ID_TO_LOGIN_ID_MATCH = 
			"SELECT user_group.group_id,groups.group_name"
			+ " FROM user_group JOIN groups ON user_group.group_id = groups.group_id"
			+ " RIGHT JOIN users ON user_group.user_id = users.user_id"
			+ " WHERE login_id = :loginId"
			+ " ORDER BY group_id";
	
	
	private static final String SELECT_USER_GROUP_USER_ID_GROUPS_GROUP_NAME =
			"SELECT user_group.user_id,user_group.group_id,groups.group_name,"
			+ " message.message_id,message.message_title"
			+ " FROM user_group JOIN groups ON user_group.group_id = groups.group_id"
			+ " RIGHT JOIN message ON user_group.user_id = message.user_id"
			+ " WHERE groups.group_name like :groupName";
	
	private static final String SELECT_USER_GROUP_NAME =
			"SELECT user_group.user_id, user_group.group_id,groups.group_name"
			+ " FROM user_group JOIN groups ON user_group.group_id = groups.group_id"
			+ " WHERE user_group.user_id = :userId and groups.group_name Like :groupName";
	
	private static final String USER_GROUP_LIST =
			"SELECT user_group.group_id, user_group.user_id,"
			+ " users.user_name, groups.group_name"
			+ " FROM user_group JOIN users ON user_group.user_id = users.user_id"
			+ " JOIN groups ON user_group.group_id = groups.group_id"
			+ " WHERE groups.group_id = :groupId";
	
	private static final String DELETE =
			"DELETE FROM user_group WHERE user_id = :userId AND group_id = :groupId";
	
	private static final String DELETE_USER_GROUP =
			"DELETE FROM user_group WHERE group_id = :groupId";
	
	private static final String DELETE_GROUP =
			"DELETE FROM groups WHERE group_id = :groupId";
	
	private static final String GROUPS_IN_DELETE_MESSAGE =
			"DELETE FROM message WHERE group_id = :groupId";
	
	//新規作成グループ内にユーザーを追加
	private static final String INSERT_GROUPS_USER_ADD =
			"INSERT INTO user_group (user_id, group_id)"
			+ " VALUES(:userId, :groupId)";
	
	private static final String SELECT_USER_NAME =
			"SELECT user_group.user_id, user_group.group_id, users.user_name"
			+ " FROM user_group"
			+ " JOIN users ON user_group.user_id = users.user_id"
			+ " WHERE group_id = :groupId";
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public List <UserGroup> findByGroupID(String loginId) {
		String sql = GROUP_ID_TO_LOGIN_ID_MATCH;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("loginId", loginId);
		return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<UserGroup>(UserGroup.class));
		 
	}
	
	
	public UserGroup selectUserGroup(String groupName) {
		String sql = SELECT_USER_GROUP_USER_ID_GROUPS_GROUP_NAME;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("groupName", "%" + groupName + "%");
		
		List<UserGroup> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<UserGroup>(UserGroup.class));
		return resultList.isEmpty() ? null : resultList.get(0);
	}
	
	public UserGroup groupSearch(Integer userId, String groupName) {
		String sql = SELECT_USER_GROUP_NAME;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);
		param.addValue("groupName", "%" + groupName + "%");
		List<UserGroup> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<UserGroup>(UserGroup.class));
		return resultList.isEmpty() ? null : resultList.get(0);
	}
	
	//仕様済み
	public List<UserGroup> findByUserGroupList(Integer groupId) {
		String sql = USER_GROUP_LIST;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("groupId", groupId);
		return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<UserGroup>(UserGroup.class));
	}
	
	//仕様済み
	public void DeleteUserGroup(Integer userId, Integer groupId) {
		String sql = DELETE;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);
		param.addValue("groupId", groupId);
		jdbcTemplate.update(sql, param);
		
	}
	
	public void DeleteGroup(Integer groupId) {
		String sql = DELETE_USER_GROUP;
		String sql1 = GROUPS_IN_DELETE_MESSAGE;
		String sql2 = DELETE_GROUP;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("groupId", groupId);
		jdbcTemplate.update(sql, param);
		jdbcTemplate.update(sql1, param);
		jdbcTemplate.update(sql2, param);
	}
	
	
	//新規作成グループ内にユーザーを追加
	public void InsertGroupUserAdd(UserGroup userGroup) {
		String sql = INSERT_GROUPS_USER_ADD;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userGroup.getUserId());
		param.addValue("groupId", userGroup.getGroupId());
		jdbcTemplate.update(sql, param);
		
		
	}
	
	public List<UserGroup> selectUserName(Integer userId, Integer groupId) {
		String sql = SELECT_USER_NAME;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);
		param.addValue("groupId", groupId);
		return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<UserGroup>(UserGroup.class));
		
	}
}
