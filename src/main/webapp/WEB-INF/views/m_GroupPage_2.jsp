
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
<title>グループユーザー一覧画面</title>
</head>
<body>
		
	<div class="text-dark">
		
		<div class="p-2">
			 	
			 	<h2 class="d-flex justify-content-center"><b>〜${fn:escapeXml(groupsNameList.groupName)}〜</b></h2> 
			 		
			 		<div class="d-flex justify-content-center">
			 			<div class="warning"><b>※</b>退会ボタンは、グループ内から、ユーザーを退会する時以外は押さないでください。</div>
			 		</div>
		
		</div>
	
		
		
		<c:forEach items="${InUserGroupList}" var="InUserGroup">
			
			<div class="d-flex justify-content-center">
				<b>${fn:escapeXml(InUserGroup.userName)}</b>
				${fn:escapeXml(InUserGroup.userId)}
				
				<form:form action="/UserGroupDelete" modelAttribute="result" method="post">
					
					<div class="mx-1">
					
						<form:hidden path="userId" value="${fn:escapeXml(InUserGroup.userId)}"/>
						<form:hidden path="groupId" value="${fn:escapeXml(InUserGroup.groupId)}"/>
						<form:button class="button">退会</form:button>
					
					</div>
				
				</form:form>
			
			</div>
		
		</c:forEach>

		
		<div class=m-4>

			<form:form action="/loginConfirm" modelAttribute="result"
				method="get">

				<input class="text-secondary" type="submit" value="TOP">

			</form:form>

		</div>

	</div>
	
</body>
</html>