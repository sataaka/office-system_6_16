package jp.co.example.entity;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class MessageInsert {
	
	private Integer messageId;
	private String messageTitle;
	private String messageText;
	private SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
	private Date createDatatime = new Date(System.currentTimeMillis());
	private String str = df.format(createDatatime);
	private Integer userId;
	private Integer groupId;
	
	
	
	public MessageInsert() {}  
	public MessageInsert(String messageTitle, String messageText, 
			Date createDatatime ,Integer userId, Integer groupId) {
		
		this.messageTitle = messageTitle;
		this.messageText = messageText;
		this.createDatatime  = createDatatime;
		this.userId = userId;
		this.groupId = groupId;
		
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
	
	
}
