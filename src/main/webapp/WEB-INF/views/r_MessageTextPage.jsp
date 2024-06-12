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
<title>メッセージ表示画面</title>
</head>
<body>
	<div class="background-color">
		<img src="picture/illust.jpg" alt="イラスト" width="95%" height="40" />
			
			<div class="d-flex justify-content-center">
			
					<b>〜${fn:escapeXml(messageLetter.groupName)}〜</b>
			
			</div>	
			
		<img src="picture/illust.jpg" alt="イラスト" width="95%" height="40" /> <br>
		
		<div class="d-flex justify-content-center">
			
			<div class="title">${fn:escapeXml(userGroup.groupName)}</div>
		
		</div>

		<div class="d-flex justify-content-center">
			
			<div class="title">${fn:escapeXml(messageLetter.messageTitle)}</div>
		
		</div>	
			
			<br>
		
		<div class="d-flex justify-content-center">
			
			<div class="createdDate">${fn:escapeXml(messageLetter.createDatatime)}</div>
		
		</div>
			
		<div class="d-flex justify-content-center">	
			
			<div class="textForm">${fn:escapeXml(messageLetter.messageText)}</div>
		
		</div>
		
						<br>

		<div class="text-center">
			<table class="table table-bordered">
				<thead>
					<c:forEach items="${sendMessageList}" var="sendMessageAll">
						<tr>
							<td>日付:/${fn:escapeXml(sendMessageAll.createDatatime)} <br>
								名前:/${fn:escapeXml(sendMessageAll.userName)} <br>
								<div class="hidden_box">
									<input type="checkbox" name="checkbox" value="1" id="check">
									ボックスを押す
									<div class="hidden_show">
										<!--非表示ここから-->
										<div class="d-flex justify-content-center">
											<form:form action="/sendMessageDelete"></form:form>
											<div class="sendTextForm">${fn:escapeXml(sendMessageAll.sendmessageText)}</div>
										</div>
										<!--ここまで-->
									</div>
								</div>
							</td>
							<td><form:form action="/sendMessageDelete"
									modelAttribute="result" method="post">
									<form:hidden path="messageSend"
										value="${fn:escapeXml(sendMessageAll.messageSend)}" />
									<form:button>削除</form:button>
								</form:form></td>
						</tr>
					</c:forEach>
				</thead>
			</table>
		</div>

		<form:form action="/rederMessagereply" modelAttribute="result" method="post">
			<div class="d-flex justify-content-center">
				<form:button class="btn btn-primary">返信する</form:button>
			</div>
		</form:form>
		
			<br>
			
		<div class=	m-3>	
			
			<form:form action="/returnRederPage" modelAttribute="result" method="get">
				<input class="text-secondary" type="submit" value="TOP">
			</form:form>
		
		</div>
	
	</div>
</body>
</html>