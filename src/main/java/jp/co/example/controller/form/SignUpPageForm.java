package jp.co.example.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SignUpPageForm {
	
	
	
	@Pattern(regexp = "^[ぁ-ゞ[一-龠]*$]+$", message="名前は必須です")
	private String userName;
	
	
	@Email(message="メールアドレスの形式が違います")
	@Pattern(regexp = "^([a-zA-Z0-9])+([a-zA-Z0-9._-])*@([a-zA-Z0-9_-])+([a-zA-Z0-9._-]+)+$")
	private String loginId;
	
	
	@Size(min = 8, max = 8, message="※英数字8文字以内入力してください")
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String passWord;
	
	@NotEmpty(message="電話番号は必須です")
	@Pattern(regexp = "0\\d{1,4}\\d{1,4}\\d{8}", message="ハイフンなしで入力してください")
	private String telNo;
	
	@NotNull
	private Integer roleId;
	
	
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
