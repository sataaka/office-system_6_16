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
<title>userListページ</title>
</head>
<body>
	
	<div class="text-dark">
	
	
		<div class="text-center">
			
			<div class="font">ユーザーリストページです</div>
		
		</div>
		
		
		<form:form action="/usersSelect" modelAttribute="result" method="POST">
			
			<div class="d-flex justify-content-end">
				<div class="mx-5">
				<form:input path="userName"/>
				<form:button>検索</form:button> 
				</div>
			</div>
			
			<div class="d-flex justify-content-center">
				<form:errors path="userName" cssStyle="color: red"/>
			</div>
			
		</form:form>
		
		<c:choose>
			
			
			<c:when test="${typeMatch eq 'ng'}">
			
				<div class="d-flex justify-content-center">
				
					<div class="my-2">
					
						<div class="error">名前が違います。</div>
						
					</div>
					
				</div>
				
			</c:when>
			
			
			<c:when test="${typeMatch eq 'ok'}">
				<div class="d-flex justify-content-center">
				
					
						<div class="my-2">${fn:escapeXml(userNameSearch.userName)}</div>
						
							<form:form action="/userinfo" modelAttribute="result">
							
					 			<form:hidden path="userId" value="${fn:escapeXml(userNameSearch.userId)}"/>
					 			
					 			
					 			<div class="m-2"><form:button class="button1">選択</form:button></div>
					 			
					 		</form:form>
			 	
			 	
			 	</div>
			 </c:when>	
								
			
			
		</c:choose>
		
		
		<c:forEach items="${usersList}" var="users">
		
			<div class="d-flex justify-content-center">
			
				<div class="my-2">${fn:escapeXml(users.userName)}</div>
				
			 	<form:form action="/userinfo" modelAttribute="result">
			 	
			 			<form:hidden path="userId" value="${fn:escapeXml(users.userId)}"/>
			 		<div class="m-2"><form:button class="button1">選択</form:button></div>
			 		
			 		<c:forEach items="${roleList}" var="roleId" >
			 		
						<form:hidden path="roleId" value="${fn:escapeXml(roleId.roleId)}"/>
					
					</c:forEach>
					
			 	</form:form>
			 	
			</div>
			
		</c:forEach>
		
		
		<div class="text-left">
			<div class="mx-4">
				<form:form action="/loginConfirm" modelAttribute="result" method="get">	
				
					<input class="text-secondary" type="submit" value="TOP">
					
				</form:form>
			</div>
		</div>
	
	
	</div>
	
</body>
</html>