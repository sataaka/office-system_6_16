package jp.co.example.entity;

public class Role {
	private Integer roleId;
	private String roleName;
	
	public Role() {}
	public Role(Integer roleId, String roleName) {
		this.roleId = roleId;
		this.roleName = roleName;
	}
	
	public Integer getRoleId() {return this.roleId;}
	public void setRoleId(Integer roleId) {this.roleId = roleId;}
	
	public String getRoleName() {return this.roleName;}
	public void setRoleName(String roleName) {this.roleName = roleName;}
}
