package jp.co.example.entity;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class SendMessage {
	private Integer messageSend;
	private Integer messageId;
	private String sendmessageText;
	private SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
	private Date createDatatime = new Date(System.currentTimeMillis());
	private String str = df.format(createDatatime);
	private Integer userId;
	private String userName;
	
	public SendMessage() {}
	public SendMessage(Integer messageSend, Integer messageId, String sendmessageText,
			Date createDatatime, Integer userId) {
		this.messageSend = messageSend;
		this.messageId = messageId;
		this.sendmessageText = sendmessageText;
		this.createDatatime = createDatatime;
		this.userId = userId;
	}
	
	public Integer getMessageSend() {return this.messageSend;}
	public void setMessageSend(Integer messageSend) {this.messageSend = messageSend;}
	
	public Integer getMessageId() {return this.messageId;}
	public void setMessageId(Integer messageId) {this.messageId = messageId;}
	
	public String getStr() {return this.str;}
	public void setStr(String str) {this.str = str;}
	
	public String getSendmessageText() {return this.sendmessageText;}
	public void setSendmessageText(String sendmessageText) {this.sendmessageText = sendmessageText;}
	
	public Date getCreateDatatime() {return this.createDatatime;}
	public void setCreateDatatime(Date createDatatime) {this.createDatatime = createDatatime;}
	
	public Integer getUserId() {return this.userId;}
	public void setUserId(Integer userId) {this.userId = userId;}
	
	public String getUserName() {return this.userName;}
	public void setUserName(String userName) {this.userName = userName;}
}
