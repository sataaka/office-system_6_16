package jp.co.example.controller.form;

import javax.validation.constraints.Pattern;

public class UserNameSearchForm {

	private Integer userId;
	
	@Pattern(regexp = "^[ぁ-ゞ[一-龠]*$]+$", message="名前が違います")
	private String userName;
	
	private String telNo;
	
	private Integer roleId;
	
	
	
		public Integer getUserId() {return this.userId;}
		public void setUserId(Integer userId) {this.userId = userId;}
		
		public String getUserName() {return this.userName;}
		public void setUserName(String userName) {this.userName = userName;}
		
		public String getTelNo() {return this.telNo;}
		public void setTelNo(String telNo) {this.telNo = telNo;}
		
		public Integer getRoleId() {return this.roleId;}
		public void setRoleId(Integer roleId) {this.roleId = roleId;}
}
