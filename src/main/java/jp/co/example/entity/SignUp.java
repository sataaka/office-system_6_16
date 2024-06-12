package jp.co.example.entity;

public class SignUp {
	
	private String userName;
	private String loginId;
	private String passWord;
	private String telNo;
	private Integer roleId;
	
	
	public SignUp () {}
	public SignUp (String userName, String loginId, String passWord, String telNo, Integer roleId) {
		
		this.userName = userName;
		this.loginId = loginId;
		this.passWord = passWord;
		this.telNo = telNo;
		this.roleId = roleId;
		 
		
	}
	
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
								                       
					
	
	
}
