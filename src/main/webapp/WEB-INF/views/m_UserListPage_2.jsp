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
<title>ユーザー情報詳細</title>
</head>
<body>
	
	<div class="back-color">

		
			
			<div class="text-center"><b>〜名前〜</b></div>
				
				<div class="text-center">${fn:escapeXml(usersInfo.userName)}</div>
			
			<div class="text-center"><b>〜ID(メールアドレス)〜</b></div>
				
				<div class="text-center">${fn:escapeXml(usersInfo.loginId)}</div>
			
			<div class="text-center"><b>〜PASSWORD〜</b></div>
				
				<div class="text-center">${fn:escapeXml(usersInfo.passWord)}</div>	
			
			<div class="text-center"><b>〜電話番号〜</b></div>
				
				<div class="text-center">${fn:escapeXml(usersInfo.telNo)}</div>
			
			<div class="text-center"><b>〜権限〜</b></div>
			
				<div class="text-center">${fn:escapeXml(usersInfo.roleName)}</div>
			
			<br>
				
			<form:form action="/userinfoUpdata" modelAttribute="result">
				
				<div class="text-center"><b>〜権限の変更〜</b></div>
				
				<div class="text-center">
					
					<label>権限</label>



				<c:choose>
					<c:when test="${typeMatch eq 'ng' }">
						<div class="error">※権限を指定してください※</div>
					</c:when>
				</c:choose>

				<form:select path="roleId">
					<option value="" selected />
						<c:forEach items="${roleList}" var="List">
							<option value="${fn:escapeXml(List.roleId)}">${fn:escapeXml(List.roleName)}</option>
						</c:forEach>
					<form:hidden path="userId"
						value="${fn:escapeXml(usersInfo.userId)}" />
				</form:select>



			</div>
				
				<div class="text-center">
					
					<form:button class="button1">ユーザー情報更新</form:button>
				
				</div>
			
			</form:form>
			
				
				<br>
				
				
				<div class="text-center">
					
					<form:form action="/userGroupInsert" modelAttribute="result">
						
						<form:button class="button1">グループ追加</form:button>
						<form:hidden path="userId" value="${fn:escapeXml(usersInfo.userId)}"/>
					
					</form:form>
				
				</div>
				
				<div class="text-left">
					<div class="mx-4">
						<form:form action="/loginConfirm" modelAttribute="result" method="get">	
						
							<input class="text-secondary" type="submit" value="TOP">
							
						</form:form>
					</div>
				</div>
				
				<br><br><br>
				
				
				<div>
					
					<div class="text-center">
						<div class="error">ユーザー削除しない場合は押さないでください</div>
					</div>
					
					<form:form action="/usersDelete" modelAttribute="result">
						
						<div class="text-center">
							
							<form:hidden path="userId" value="${fn:escapeXml(usersInfo.userId)}"/>
							<form:button class="button">ユーザー削除</form:button>
						
						</div>
					
					</form:form>
				
				</div>
			
	</div>		
	
</body>
</html>