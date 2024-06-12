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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/group.css">
<title>グループ画面</title>
</head>
<body>
	<div class="p-3 mb-2 bg-light text-dark">

		
		
		<div class="p-2">
		 	<h2>${fn:escapeXml(groupsNameList.groupName)}</h2> 
		</div>
		
			<div class="mx-5">
				<img src="picture/illust.jpg" alt="イラスト" width="35" height="5"/>
					<p>ようこそ${fn:escapeXml(users.userName)}さん</p>
				<img src="picture/illust.jpg" alt="イラスト" width="35" height="5"/>	
			</div>		 
				
			
					
				
		
								<!-- 検索テーブル -->		 					
		<table class="table table-bordered">
			
			
			<form:form action="/rederMessageSearch" modelAttribute="result" method="POST">

				<div class="d-flex justify-content-end">
					<div class="p-2">
						<form:hidden path="groupId" value="${fn:escapeXml(groupsNameList.groupId)}"/>
						<form:input path="input" />
						<input class="submit" type="submit" value="検索">
						<form:errors path="input" cssStyle="color: red"/>
					</div>
				</div>

			</form:form>
					
							
			<c:choose>
				<c:when test="${typeMatch eq 'ng' }">

					<div class="text-center">
						<div class="error">メッセージがありません</div>
					</div>

				</c:when>
			</c:choose>	
					
				<tbody>
					
					<c:forEach items="${messageSerach}" var="serach">
						<tr>
							<td>${fn:escapeXml(serach.messageTitle)}</td>
							<td>${fn:escapeXml(serach.createDatatime)}</td>
							<td>${fn:escapeXml(serach.userName)}</td>
						
							<form:form action="/rederMessageTextPage" modelAttribute="result" method="GET">
								<td> <form:hidden path="messageId" value="${fn:escapeXml(serach.messageId)}"/>
									<input class="submit" type="submit" value="選択">
								</td>									 
							</form:form>
						</tr>
					</c:forEach>
						
				</tbody>	
			
		
		</table>
		
		
		<div class="p-2">
				<b>メッセージ一覧</b>
		</div>			
				
				
		<table class="table table-bordered">
			
				<thead>
					<tr>
						
						<th>メッセージタイトル</th>
						<th>日付</th>
						<th>作成者</th>
					
					</tr>
				</thead>
			
			
			
				<tbody>
				
				<c:forEach items="${messageList}" var="message">	 
					
							
							<tr>
					 					<td>${fn:escapeXml(message.messageTitle)}</td>
										<td>${fn:escapeXml(message.createDatatime)}</td>
										<td>${fn:escapeXml(message.userName)}</td>
									
							
							
							<form:form action="/rederMessageTextPage" modelAttribute="result" method="get">
								<td> <form:hidden path="messageId" value="${fn:escapeXml(message.messageId)}"/>
									<input class="submit" type="submit" value="選択">
								</td>
							</form:form>
						
							</tr>
								
					
				</c:forEach> 
				
				</tbody>	
							
		</table>
		
		
		
		<div class=m-1>
		
				<form:form action="/rederUserGroupList" modelAttribute="result" method="get">
					<form:button class="submit">ユーザー一覧</form:button>
					<form:hidden path="groupId" value="${fn:escapeXml(messageGroupName.groupId)}"/>
				</form:form>
			
		</div>
		
	</div>
</body>
</html>