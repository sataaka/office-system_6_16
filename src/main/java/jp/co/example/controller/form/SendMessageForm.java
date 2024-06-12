package jp.co.example.controller.form;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class SendMessageForm {
	private Integer messageSend;
	private Integer messageId;
	private String sendmessageText;
	private SimpleDateFormat dx = new SimpleDateFormat("yyyy/MM/dd");
	private Date createDatatime = new Date(System.currentTimeMillis());
	private String stf = dx.format(createDatatime);
	private Integer userId;
	private String userName;
	
	public Integer getMessageSend() {return this.messageSend;}
	public void setMessageSend(Integer messageSend) {this.messageSend = messageSend;}
	
	public Integer getMessageId() {return this.messageId;}
	public void setMessageId(Integer messageId) {this.messageId = messageId;}
	
	public String getStf() {return this.stf;}
	public void setStf(String stf) {this.stf = stf;}
	
	public String getSendmessageText() {return this.sendmessageText;}
	public void setSendmessageText(String sendmessageText) {this.sendmessageText = sendmessageText;}
	
	public Date getCreateDatatime() {return this.createDatatime;}
	public void setCreateDatatime(Date createDatatime) {this.createDatatime = createDatatime;}
	
	public Integer getUserId() {return this.userId;}
	public void setUserId(Integer userId) {this.userId = userId;}
	
	public String getUserName() {return this.userName;}
	public void setUserName(String userName) {this.userName = userName;}
}
