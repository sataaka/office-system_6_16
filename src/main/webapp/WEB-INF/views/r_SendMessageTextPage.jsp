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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/text.css">
<title>メッセージ内返信画面</title>
</head>
<body>
	<div class="background-color">
	
	
		<!-- メッセージ情報 -->	
		<img src="picture/illust.jpg" alt="イラスト" width="95%" height="40"/>
		
			<div class="d-flex justify-content-center">
			
					<b>〜${fn:escapeXml(messageLetter.groupName)}〜</b>
			</div>	
			
		<img src="picture/illust.jpg" alt="イラスト" width="95%" height="40"/>	
		
				<br>
		
		
		<div class="d-flex justify-content-center">
		
			<div class="title">${fn:escapeXml(messageLetter.messageTitle)}</div>		
		
		</div>
		
		<div class="d-flex justify-content-center">
		
			<div class="createdDate">${fn:escapeXml(messageLetter.createDatatime)}</div>			
		
		</div>
		
		<div class="d-flex justify-content-center">	
					
			<div class="textForm">${fn:escapeXml(messageLetter.messageText)}</div>
		
		</div>
			
			<br>
			
		<form:form action="/rederMessagereplyPage" modelAttribute="result" method="post">
		
			<div class="createdDatetime">	
				<form:input path="createDatatime"/>
			</div>
				<div class="d-flex justify-content-center">
					<form:hidden path="messageId" value="${fn:escapeXml(messageLetter.messageId)}"/>
					<form:textarea cols="80" rows="5" path="sendmessageText"/>
					<form:hidden path="userId" value="${fn:escapeXml(users.userId)}"/>
					<form:button class="btn btn-primary">送信</form:button>
				</div>
		
		</form:form>
	</div>
</body>
</html>