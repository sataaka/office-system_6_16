package jp.co.example.entity;



import java.sql.Date;
import java.text.SimpleDateFormat;


public class Message {
	
	private Integer messageId;
	private String messageTitle;
	private String messageText;
	private SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
	private Date createDatatime = new Date(System.currentTimeMillis());
	private String str = df.format(createDatatime);
	private Integer userId;
	private Integer groupId;
	private String groupName;
	private String userName;
	private String input;
	
	
	
	public Message() {}  
	public Message(Integer messageId, String messageTitle, String messageText, Date createDatatime, 
			Integer userId, Integer groupId, String groupName) {
		this.messageId = messageId;
		this.messageTitle = messageTitle;
		this.messageText = messageText;
		this.createDatatime = createDatatime;
		this.userId = userId;
		this.groupId = groupId;
		this.groupName = groupName;
	}
	
	public Integer getMessageId() {return this.messageId;}
	public void setMessageId(Integer messageId) {this.messageId = messageId;}
	
	public String getMessageTitle() {return this.messageTitle;}
	public void setMessageTitle(String messageTitle) {this.messageTitle = messageTitle;}
	
	public String getMessageText() {return this.messageText;}
	public void setMessageText(String messageText) {this.messageText = messageText;}
	
	public String getStr() {return this.str;}
	public void setStr(String str) {this.str = str;}
	
	public Date getCreateDatatime() {return this.createDatatime;}
	public void setCreateDatatime(Date createDatatime) {this.createDatatime = createDatatime;}
	
	public Integer getUserId() {return this.userId;}
	public void setUserId(Integer userId) {this.userId = userId;}
	
	public Integer getGroupId() {return this.groupId;}
	public void setGroupId(Integer groupId) {this.groupId = groupId;}
	
	public String getGroupName() {return this.groupName;}
	public void setGroupName(String groupName) {this.groupName = groupName;}
	
	public String getUserName() {return this.userName;}
	public void setUserName(String userName) {this.userName = userName;}
	
	public String getInput() {return this.input;}
	public void setInput(String input) {this.input = input;}
	
	
	
	
}
