package jp.co.example.controller.form;

import javax.validation.constraints.Pattern;

public class GroupInsertForm {
	private Integer userId;
	
	private Integer groupId;
	
	@Pattern(regexp = "^[ぁ-ゞ[一-龠]*$[a-zA-Z0-9]+[ァ-ヶ]+]+$", message="グループ名を入力してください")
	private String groupName;
	
		//グループ名のuserid
		public Integer getUserId() {return this.userId;}
		public void setUserId(Integer userId) {this.userId = userId;}
		
		public Integer getGroupId() {return this.groupId;}
	    public void setGroupId(Integer groupId) {this.groupId = groupId;}	
		
		//グループ名の検索用
		public String getGroupName() {return this.groupName;}
		public void setGroupName(String groupName) {this.groupName = groupName;}
}
