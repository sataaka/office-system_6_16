package jp.co.example.entity;

public class Users {
	//userテーブルの情報
	private Integer userId;
	private String userName;
	private String loginId;
	private String passWord;
	private String telNo;
	//roleテーブルの情報
	private Integer roleId;
	private String roleName;
	//groupテーブルの情報
	private String groupName;
	
	
	public Users() {}
	public Users(String userName, String loginId, String passWord, String telNo, Integer roleId) {
		
		this.userName = userName;
		this.loginId = loginId;
		this.passWord = passWord;
		this.telNo = telNo;
		this.roleId = roleId;
		
	}
	
	//取得メソッドとセットメソッド
	public Integer getUserId() {return this.userId;}
	public void setUserId(Integer userId) {this.userId = userId;}
	
	public String getUserName() {return this.userName;}
	public void setUserName(String userName) {this.userName = userName;}
	
	public String getLoginId() {return this.loginId;}
	public void setLoginId(String loginId) {this.loginId = loginId;}
	
	public String getPassWord() {return this.passWord;}
	public void setPassWord(String passWord) {this.passWord = passWord;}
	
	public String getTelNo() {return this.telNo;}
	public void setTelNo(String telNo) {this.telNo = telNo;}
	
	public Integer getRoleId() {return this.roleId;}
	public void setRoleId(Integer roleId) {this.roleId = roleId;}
	
	public String getRoleName() {return this.roleName;}
	public void setRoleName(String roleName) {this.roleName = roleName;}
	
	
	public String getGroupName() {return this.groupName;}
	public  void setGroupName(String groupName) {this.groupName = groupName;}
}
