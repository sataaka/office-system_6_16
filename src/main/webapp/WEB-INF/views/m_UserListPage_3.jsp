<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/userList.css">
<title>ユーザーグループ追加画面</title>
</head>
<body>

	<div class="back-color-GroupAdd">

		<div class="text-center"><b>〜管理者〜</b></div>
			
			<div class="text-center">${fn:escapeXml(users.userName)}さん</div>
	
		<div class="text-center"><b>〜名前〜</b></div>
			
			<div class="text-center">${fn:escapeXml(usersInfo.userName)}さん</div>
	
		<div class="text-center">
			
			<label><b>~現在のグループ一覧~</b></label>
		
		</div>
	
		<div class="text-center">
			
			<c:forEach items="${usersUserGroupList}" var="userGroupList">
				<div class="pt-1">${fn:escapeXml(userGroupList.groupName)}</div>
			</c:forEach>
			
		</div>
	
		<br><br>
		
		
			
			<div class="text-center">
				
				<label><b>~グループ一覧~</b></label>
			
			</div>
			
			<div class="text-center">
					
					<c:forEach items="${groupsAllList}" var="groupAll">
						
						<form:form action="/userInfoUserGroup" modelAttribute="result">
							
							<div class="pt-3">
								
								<b>${fn:escapeXml(groupAll.groupName)}</b>
									
									<form:hidden path="userId" value="${fn:escapeXml(usersInfo.userId)}"/>
									<form:hidden path="groupId" value="${fn:escapeXml(groupAll.groupId)}"/>
									<form:button class="btn btn-primary">追加</form:button>
									
							</div>
							
						</form:form>
						
					
					</c:forEach>
			</div>
		
		
	
	
	</div>
	
</body>
</html>