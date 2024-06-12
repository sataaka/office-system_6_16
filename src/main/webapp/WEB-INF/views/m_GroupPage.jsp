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

<title>管理者画面</title>
<title>グループページ</title>
</head>
<body>
	<!-- グループ名を検索したら、この画面に遷移する -->
	<div class="p-3 mb-2 bg-light text-dark">

	
	<!-- グループ名を選択したらこの画面に遷移する -->
		<div class="p-2">
		 	<h2 class="d-flex justify-content-center"><b>〜${fn:escapeXml(groupsNameList.groupName)}〜</b></h2> 
		</div>
		
			<div class="mx-5">
				<img src="picture/illust.jpg" alt="イラスト" width="35" height="5"/>
					ようこそ<b>${fn:escapeXml(users.userName)}さん</b>
				<img src="picture/illust.jpg" alt="イラスト" width="35" height="5"/>
			</div>
		
	
			<table class="table table-bordered">
						
						<form:form action="/MessageSearch" modelAttribute="result" method="POST">
							<div class="d-flex justify-content-end">
								<div class="p-2">
									<form:hidden path="groupId" value="${fn:escapeXml(groupsNameList.groupId)}"/>
									<form:input path="input"/>
									<form:button>検索</form:button>
								</div>
							</div>
							
							<div class="text-center">
								<form:errors path="input" cssStyle="color: red"/>
							</div>
				
				<c:choose>
					<c:when test="${typeMatch eq 'ng'}">

						<div class="text-center">
							<div class="error">メッセージがありません</div>
						</div>

					</c:when>
				</c:choose>


			</form:form>
				
					<tbody>
							<c:forEach items="${messageSerach}" var="serach">
								<tr>
									<td>${fn:escapeXml(serach.messageTitle)}</td>
									<td>${fn:escapeXml(serach.createDatatime)}</td>
									<td>${fn:escapeXml(serach.userName)}</td>
								
									<form:form action="/messageTextPage" modelAttribute="result" method="get">
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
												
										
										
										<form:form action="/messageTextPage" modelAttribute="result" method="get">
											<td> <form:hidden path="messageId" value="${fn:escapeXml(message.messageId)}"/>
												<input class="submit" type="submit" value="選択">
											</td>
										</form:form>
									
										</tr>
											
								
							</c:forEach> 
							
							</tbody>	
							
					</table>
					
	
			
				
				<div class=m-1>
					
					<form:form action="/InUserGroupList" modelAttribute="result" method="GET">
						<form:button class="submit">ユーザー一覧</form:button>
						<form:hidden path="groupId" value="${fn:escapeXml(messageGroupName.groupId)}"/>
					</form:form>
				
				</div>
			
				<div class=m-1>
					<form:form action="/GroupDelete" modelAttribute="result" method="GET">
						<div class="m-3">※グループを削除する時以外は、押さないでください。</div>
						<form:hidden path="groupId" value="${fn:escapeXml(messageGroupName.groupId)}"/>
						<form:button class="delete">グループ削除</form:button>
					</form:form>
				
				</div>
				
			
			
	</div>

</body>
</html>