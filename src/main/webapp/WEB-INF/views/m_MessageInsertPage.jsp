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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/loginPage.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/newUserPage.css">
<title>メッセージ作成画面</title>
</head>
<body>
	<div class="newDisplay1">
		
		<div class="d-flex justify-content-center">
			<div class="mt-2">
				<div class="fs-4">
					<div class="text-white"><b>新規メッセージ</b></div>
				</div>
			</div>
		</div>
	
	</div>
	
	<div class="newDisplay2">
		
		<form:form action="messageInsert" modelAttribute="result" method="post">
			
			<div class="mx-3">
				<label class="px-4">宛先</label>
					<form:select class="messageBorder" path="groupId">
		        		<form:options items="${AllGroups}" itemLabel="groupName" itemValue="groupId" />
		      		</form:select>
		     </div>
			
			<div class="m-3">
				<label class="px-1">タイトル</label>
					<form:input class="messageBorder" path="messageTitle"/><form:errors path="messageTitle" cssStyle="color: red"/>
			</div>
			
			<div class="m-3">
				<label class="px-3">日付</label>
					<form:input class="messageBorder" path="createDatatime"/>
		      		<form:hidden path="userId" value="${fn:escapeXml(users.userId)}"/>
	      	</div>
			
				<label class="labelText">メッセージ</label>
			<div class="mx-3">
					<form:textarea class="messageText" path="messageText"/><form:errors path="messageText" cssStyle="color: red"/>
			</div>
			
			<form:button class="button">送信</form:button>
		
		</form:form>
		
	</div>
	
</body>
</html>