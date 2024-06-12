package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.MessageDao;
import jp.co.example.entity.Message;
import jp.co.example.entity.MessageInsert;
import jp.co.example.entity.SendMessage;
import jp.co.example.entity.Users;

@Repository
public class MessageDaoPg implements MessageDao{
	
	//仕様済み
	private static final String SELECT_FROM_GROUPS_GROUP_NAME = 
			"SELECT groups.group_id, groups.group_name, message_id, message_title FROM"
			+ " groups JOIN message ON groups.group_id = message.group_id WHERE groups.group_id = :groupId";
	
	
	//仕様済み
	//グループに紐づいたメッセージリストを表示する箇所
	private static final String SELECT_FROM_MESSAGE = 
			"SELECT message.message_id, message.message_title,message.message_text,message.create_datatime,"
			+ " groups.group_id,groups.group_name,users.user_name"
			+ " FROM message JOIN groups ON message.group_id = groups.group_id"
			+ " RIGHT JOIN users ON message.user_id = users.user_id"
			+ " WHERE groups.group_id = :groupId";
			
	
	//仕様済み
	private static final String SELECT_FROM_MESSAGE_WHERE_MESSAGE_ID = 
			"SELECT message.message_id,message.message_title, message.message_text,message.create_datatime,"
			+ " message.user_id, message.group_id,"
			+ " groups.group_name"
			+ " FROM message JOIN groups"
			+ " ON message.group_id = groups.group_id WHERE message_id = :messageId";
	
	
	//仕様済み
	//グループページの検索画面	
	private static final String MASSAGE_TITLE_SEARCH = 
			"SELECT message.message_id,message.message_title, message.message_text,message.create_datatime"
			+ " ,message.user_id, message.group_id, users.user_name FROM message JOIN users ON"
			+ " message.user_id = users.user_id WHERE message_title LIKE :input"
			+ " OR user_name LIKE :input OR to_char(message.create_datatime, 'yyyy/mm/dd') LIKE :input";
	
	private static final String MASSAGE_TITLE_SEARCH_GROUP_ID = 
			"SELECT message.message_id,message.message_title, message.message_text,message.create_datatime"
			+ " ,message.user_id, message.group_id, users.user_name FROM message JOIN users ON"
			+ " message.user_id = users.user_id WHERE group_id = :groupId and message_title LIKE :input"
			+ " AND group_id = :groupId OR user_name LIKE :input"
			+ " AND group_id = :groupId OR to_char(message.create_datatime, 'yyyy/mm/dd') LIKE :input"
			+ " AND group_id = :groupId";
	
	//仕様済み
	private static final String MESSAGE_CREATE_USER_NAME_SERACH =
			"SELECT message.message_title,"
			+ " message.message_text, message.create_datatime, message.user_id,users.user_name"
			+ " FROM message JOIN users ON message.user_id = message.user_id WHERE message.user_id = :userId"
			+ " AND user_name = :userName";
	
	//仕様済み
	private static final String USER_MESSAGE_ALL_LIST =
			"SELECT message_id, message_title, message_text, create_datatime,"
			+ " users.user_id,group_id, users.user_name"
			+ " FROM message JOIN users ON message.user_id = users.user_id"
			+ " ORDER BY message_id";
	
	
	//仕様済み
	private static final String MESSAGE_DELETE =
			"DELETE FROM message WHERE message_id = :messageId";
	
	
	
	//仕様済み
	public static final String MESSSAGE_INSERT =
			"INSERT INTO message (message_title, message_text,create_datatime,"
			+ " user_id, group_id)"
			+ " VALUES(:messageTitle, :messageText, :createDatatime, :userId, :groupId)";
	
	private static final String SENDMESSAGE_INSERT =
			"INSERT INTO sendmessage (message_id,sendmessage_text,create_datatime,user_id)"
			+ " VALUES(:messageId, :sendmessageText,:createDatatime,:userId)";
	
	private static final String SENDMESSAGE_LIST =
			"select message_send, sendmessage_text,sendmessage.create_datatime,"
			+ " message.message_id,users.user_name"
			+ " from sendmessage join message"
			+ " on sendmessage.message_id = message.message_id"
			+ " right join users on sendmessage.user_id = users.user_id"
			+ " where message.message_id = :messageId"
			+ " order by message_send";
	
	private static final String SENDMESSAGE_DELETE =
			"delete from sendmessage where message_send = :messageSend";
	
	
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	private JdbcTemplate jdbcTemplateMessage;
	
	//仕様済み
	//groupIdに紐づいたgroupNameをgroupPageに送る為のメソッド
	public Message findGroupNameDisplay(Integer groupId) {
		String sql = SELECT_FROM_GROUPS_GROUP_NAME ;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("groupId", groupId);
		List<Message> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Message>(Message.class));
		return resultList.isEmpty() ? null : resultList.get(0);
	}
	
	//仕様済み
	//groupIdに紐づいたメッセージリストをgroupPageに送る為のメソッド
	public List<Message> findByMessageList(Integer groupId, String messageTitle) {
		String sql = SELECT_FROM_MESSAGE;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("groupId", groupId);
		param.addValue("messageTitle", messageTitle);
		
		return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Message>(Message.class));
	}
	
	//仕様済み
	public Message messageLetter(Integer messageId) {
		String sql = SELECT_FROM_MESSAGE_WHERE_MESSAGE_ID;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("messageId", messageId);
		List<Message> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Message>(Message.class));
		return resultList.isEmpty() ? null : resultList.get(0);
	}
	
	public List<Message> messageRepry(Integer messageId) {
		String sql = SELECT_FROM_MESSAGE_WHERE_MESSAGE_ID;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("messageId", messageId);
		return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Message>(Message.class));
	}
	
	
	//仕様済み
	//グループページでメッセージの検索
	public Message findByMassegeTitleSerach(String input) {
		String sql = MASSAGE_TITLE_SEARCH;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("input", input);
		
		List<Message> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Message>(Message.class));
		return resultList.isEmpty() ? null : resultList.get(0);
	}
	
	//仕様済み
	//メッセージタイトル検索
	public List<Message> findByMassegeTitleSerachTest(String input) {
		String sql = MASSAGE_TITLE_SEARCH;
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		param.addValue("input", "%" + input + "%");
		
		return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Message>(Message.class));
	}
	
	public Message findByGroupId_MassegeTitleSerach(String input, Integer groupId) {
		String sql = MASSAGE_TITLE_SEARCH_GROUP_ID;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("input", "%" + input + "%");
		param.addValue("groupId", groupId);
		
		List<Message> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Message>(Message.class));
		return resultList.isEmpty() ? null : resultList.get(0);
	}
	
	public List<Message> findByGroupId_MassegeTitleSerachTest(String input, Integer groupId) {
		String sql = MASSAGE_TITLE_SEARCH_GROUP_ID;
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		param.addValue("input", "%" + input + "%");
		param.addValue("groupId", groupId);
		
		return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Message>(Message.class));
	}
	
	
		//仕様済み
		//メッセージタイトル検索検証用
		public Message MassegeTitleSerachTest(String input) {
			String sql = MASSAGE_TITLE_SEARCH;
			MapSqlParameterSource param = new MapSqlParameterSource();
			
			param.addValue("input", "%" + input + "%");
			
			List<Message> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Message>(Message.class));
			
			return resultList.isEmpty() ? null : resultList.get(0);
		}
	
	
	//仕様済み
	public Message findByMessageCreatorUserNameSerach(Integer userId, String userName) {
		String sql = MESSAGE_CREATE_USER_NAME_SERACH;
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		param.addValue("userId", userId);
		param.addValue("userName", userName);
		
		List<Message> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Message>(Message.class));
		
		return resultList.isEmpty() ? null : resultList.get(0);
	}

	
	
	//仕様済み
	public List<Message> findByAllMessageList() {
		String sql = USER_MESSAGE_ALL_LIST;
		
		return jdbcTemplateMessage.query(sql , new BeanPropertyRowMapper<Message>(Message.class));
		
	}

	
	
	//仕様済み
	public void  DeleteMessage(Integer messageId) {
		String sql = MESSAGE_DELETE;
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		param.addValue("messageId", messageId);
		
		jdbcTemplate.update(sql, param);
	}
	
	
	
	public void InsertMessage(MessageInsert messageInsert) {
		String sql = MESSSAGE_INSERT;
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		param.addValue("messageTitle", messageInsert.getMessageTitle());
		param.addValue("messageText", messageInsert.getMessageText());
		param.addValue("createDatatime", messageInsert.getCreateDatatime());
		param.addValue("userId", messageInsert.getUserId());
		param.addValue("groupId", messageInsert.getGroupId());
		
		jdbcTemplate.update(sql, param);
		
	}
	/*メッセージ内、メッセージ送受信*/
	public void sendMessageInsert(SendMessage sendMessage){
		String sql = SENDMESSAGE_INSERT;
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		param.addValue("messageId", sendMessage.getMessageId());
		param.addValue("sendmessageText", sendMessage.getSendmessageText());
		param.addValue("createDatatime", sendMessage.getCreateDatatime());
		param.addValue("userId", sendMessage.getUserId());
		
		jdbcTemplate.update(sql, param);
	}
	
	public List<SendMessage> findBySendMessage(Integer messageId){
		String sql = SENDMESSAGE_LIST;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("messageId", messageId);
		return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<SendMessage>(SendMessage.class));
	}
	
	public void  DeleteSendMessage(Integer messageSend) {
		String sql = SENDMESSAGE_DELETE;
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		param.addValue("messageSend", messageSend);
		jdbcTemplate.update(sql, param);
		
	}
	
}
