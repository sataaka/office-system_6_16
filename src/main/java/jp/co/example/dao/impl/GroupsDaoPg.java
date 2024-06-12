package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.GroupsDao;
import jp.co.example.entity.Groups;
@Repository
public class GroupsDaoPg implements GroupsDao{
	private static final String INSERT_INTO_GROUP_NAME =
			"insert into groups (group_name) values(:groupName)";
	
	private static final String SELECT_FROM_GROUPS =
			"select * from groups where group_name = :groupName";
	
	private static final String SELECT_ALL_GROUPS =
			"select * from groups order by group_id";
	
	private static final String SELECT_ALL_GROUPS2 =
			"select * from groups where group_id = :groupId";
	
	private static final String SELECT_ALL_GROUP_NAME =
			"SELECT group_name FROM groups WHERE group_name = :groupName";
	
	
	@Autowired
	private NamedParameterJdbcTemplate NamedjdbcTemplate;
	
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	
	public List<Groups> findGroupName() {
		return jdbcTemplate.query("SELECT group_name FROM groups", new BeanPropertyRowMapper<Groups>(Groups.class));
	}
	
	
	public void InsertGroupName(String groupName) {
		String sql = INSERT_INTO_GROUP_NAME;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("groupName", groupName);
		NamedjdbcTemplate.update(sql, param);
	}
	
	public Groups findByGroupName(String groupName) {
		String sql = SELECT_FROM_GROUPS;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("groupName", groupName);
		List<Groups> resultList = NamedjdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Groups>(Groups.class));
		return resultList.isEmpty() ? null : resultList.get(0);
	}
	
	//メッセージ作成のグループ一覧
	public List<Groups> findByALLGorups() {
		String sql = SELECT_ALL_GROUPS;
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Groups>(Groups.class));
	}
	
	//グループIDに紐づいたメッセージリストを表示する
	public Groups groupNameList(Integer groupId) {
		String sql = SELECT_ALL_GROUPS2;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("groupId", groupId);
		List<Groups> resultList = NamedjdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Groups>(Groups.class));
		return resultList.isEmpty() ? null : resultList.get(0);
	}
	
	public Groups groupNameMatch(String groupName) {
		String sql = SELECT_ALL_GROUP_NAME;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("groupName", groupName);
		List<Groups> resultList = NamedjdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Groups>(Groups.class));
		return resultList.isEmpty() ? null : resultList.get(0);
	}
	
	
}
