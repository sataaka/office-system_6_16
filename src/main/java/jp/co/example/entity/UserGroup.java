package jp.co.example.entity;


//groupsテーブルとusersグループを紐付けている親クラス
public class UserGroup {
	//管理番号
	private Integer managementId;
	//usersテーブルのuser_id
	private Integer userId;
	private String userName;
	//groupsテーブルのgroup_id
	private Integer groupId;
	private String groupName;
	
	private String messageTitle;
	
	
	public UserGroup() {}
	public UserGroup(Integer userId ,Integer groupId) {
		
		this.userId = userId;
		this.groupId = groupId;
		
	}
	
	public Integer getManagementId() {return this.managementId;}
	public void setManagementId(Integer managementId) {this.managementId = managementId;}
	
	public Integer getUserId() {return this.userId;}
	public void setUserId(Integer userId) {this.userId = userId;}
	
	public String getUserName() {return this.userName;}
	public void setUserName(String userName) {this.userName = userName;}
	
	public Integer getGroupId() {return this.groupId;}
	public void setGroupId(Integer groupId) {this.groupId = groupId;}
	
	public String getGroupName() {return this.groupName;}
	public void setGroupName(String groupName) {this.groupName = groupName;}
	
	public String getMessageTitle() {return this.messageTitle;}
	public void setMessageTitle(String messageTitle) {this.messageTitle = messageTitle;}
	
}
