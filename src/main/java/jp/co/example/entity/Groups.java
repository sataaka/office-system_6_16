package jp.co.example.entity;
//gurupsテーブル
public class Groups {
	
	//管理番号
	private Integer groupId;
	//グループ名
	private String groupName;
	
	public Groups() {}
	public Groups(Integer groupId, String groupName) {
		this.groupId = groupId;
		this.groupName = groupName;
	}			
				
	public Integer getGroupId() {return this.groupId;}
	public void setGroupId(Integer groupId) {this.groupId = groupId;}
	
	public String getGroupName() {return this.groupName;}
	public void setGroupName(String groupName) {this.groupName = groupName;}
}
