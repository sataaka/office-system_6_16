<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/group.css">
<title>ユーザー追加</title>
</head>
<body>

	<div class="back-color">
		
		<div class="text-groupInsert">ユーザーを追加します:グループ名</div>
			
			<div class="text-groupNameInsert">${fn:escapeXml(InsertGroupName.groupName)}</div>
		
			<div class="text-groupInsert">〜追加するユーザー一覧〜</div>
				
					
						
					
					
						<c:forEach items="${AllusersList}" var="Allusers">
								
							
							
								<form:form action="/usersGroupInsert" modelAttribute="result" method="get">
							<div class="text-group">${fn:escapeXml(Allusers.userName)}		
									<form:hidden path="userId" value="${fn:escapeXml(Allusers.userId)}"/>
									<form:hidden path="groupId" value="${fn:escapeXml(InsertGroupName.groupId)}"/>
										<form:button class="button">追加</form:button>
							</div>			
								</form:form>
							
							
							
						</c:forEach>
						
						
					 
					
			
		<div class="back-color">	
		
			
			<label class="text-group">〜追加したユーザー〜</label>	
			
				<c:forEach items="${addUserName}" var="addName">
					
					<div class="text-group">${fn:escapeXml(addName.userName)}</div>
				
				</c:forEach>
				
				<div class="text-group">
					
					<form:form action="/anserPage" modelAttribute="result" method="get">
						
						<form:hidden path="userId" value="${fn:escapeXml(users.userId)}"/>
						<form:hidden path="groupId" value="${fn:escapeXml(InsertGroupName.groupId)}"/>
						
						<form:button class="button">次に進む</form:button>
						
					</form:form>
					
				</div>
				
				
		</div>
		
	</div>		
</body>
</html>