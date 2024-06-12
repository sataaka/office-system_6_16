package jp.co.example.controller.form;




import java.sql.Date;

import javax.validation.constraints.Pattern;









public class LoginPageForm {
	
	
	
	@Pattern(regexp= "^(.*[a-zA-Z0-9])$")
	private String loginId;		//ログイン画面のフォーム用
	
	
	
	@Pattern(regexp= "^(.*[a-zA-Z0-9])$")
	private String passWord;	//ログイン画面のフォーム用
	
	private Integer userId;		//ユーザーページに遷移した際に、
	
	private String userName;
	
	private String telNo;
	
	private Integer roleId;
	
	
	private String groupName;
	
	private Integer groupId;
	
	private Integer messageId;
	
	private String messageTitle;
	
	private Date input;
	
	//ログイン画面のフォーム用  (login)
	public String getLoginId() {return this.loginId;}
	public void setLoginId(String loginId) {this.loginId = loginId;}
	
	
	//ログイン画面のフォーム用  (passWord)
	public String getPassWord() {return this.passWord;}
	public void setPassWord(String passWord) {this.passWord = passWord;}
	
	//グループ名のuserid
	public Integer getUserId() {return this.userId;}
	public void setUserId(Integer userId) {this.userId = userId;}
	
	public String getUserName() {return this.userName;}
	public void setUserName(String userName) {this.userName = userName;}
	
	public String getTelNo() {return this.telNo;}
	public void setTelNo(String telNo) {this.telNo = telNo;}
	
	public Integer getRoleId() {return this.roleId;}
	public void setRoleId(Integer roleId) {this.roleId = roleId;}
	
	//グループ名の検索用
	public String getGroupName() {return this.groupName;}
	public void setGroupName(String groupName) {this.groupName = groupName;}
	
	public Integer getGroupId() {return this.groupId;}
    public void setGroupId(Integer groupId) {this.groupId = groupId;}	
    
    public Integer getMessageId() {return this.messageId;}
    public void setMessageId(Integer messageId) {this.messageId = messageId;}
    
    public String getMessageTitle() {return this.messageTitle;}
    public void setMessageTitle(String messageTitle) {this.messageTitle = messageTitle;}
    
    public Date getInput() {return this.input;}
    public void setInput(Date input) {this.input = input;}
    
  
}
