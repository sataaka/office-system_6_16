package jp.co.example.controller.form;







import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.validation.constraints.Pattern;





public class ManagerPageForm implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer userId;
	private String userName;
	
	private Integer groupId;
	
	
	private String groupName;
	
	
	private Integer messageId;
	private String messageTitle;
	private String messageText;
	private SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
	private Date createDatatime = new Date(System.currentTimeMillis());
	private String str = df.format(createDatatime);
	
	private Integer messageSend;
	private String sendmessageText;
	
	//メッセージ検索用の文字列
	@Pattern(regexp = "^[ぁ-ゞ[一-龠]*$[a-zA-Z0-9]+[ァ-ヶ]+[-/:-@\\[-\\`\\{-\\~]+]+$", message="該当するメッセージがありません")
	private String input;
	
	
	//グループ名の検索用
		public Integer getUserId() {return this.userId;}
		public void setUserId(Integer userId) {this.userId = userId;}
		
		public String getUserName() {return this.userName;}
		public void setUserName(String userName) {this.userName = userName;}
	
		
		public String getGroupName() {return this.groupName;}
		public void setGroupName(String groupName) {this.groupName = groupName;}
		
		public Integer getGroupId() {return this.groupId;}
		public void setGroupId(Integer groupId) {this.groupId = groupId;}
		
		
		public Integer getMessageId() {return this.messageId;}
		public void setMessageId(Integer messageId) {this.messageId = messageId;}
		
		public String getMessageTitle() {return this.messageTitle;}
		public void setMessageTitle(String messageTitle) {this.messageTitle = messageTitle;}
		
		public String getMessageText() {return this.messageText;}
		public void setMessageText(String messageText) {this.messageText = messageText;}
		
		
	//時間のゲッターとセッター	
		public String getStr() {return this.str;}
		public void setStr(String str) {this.str = str;}
		
		public Date getCreateDatatime() {return this.createDatatime;}
		public void setCreateDatatime(Date createDatatime) {this.createDatatime = createDatatime;}
		
		
		public String getInput() {return this.input;}
		public void setInput(String input) {this.input = input;}
		
		public Integer getMessageSend() {return this.messageSend;}
		public void setMessageSend(Integer messageSend) {this.messageSend = messageSend;}
		
		public String getSendmessageText() {return this.sendmessageText;}
		public void setSendmessageText(String sendmessageText) {this.sendmessageText = sendmessageText;}
		
		
}
