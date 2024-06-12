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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/loginPage.css">
<title>社内連絡システム</title>
</head>
<body>
		
	<div class="background-color-Login">
		
		
		<!-- 画面表示をlogin URLで送る-->
		
		<form:form action="/login" modelAttribute="result">
			
			<c:forEach items="${userIdList}" var="user">
				<form:hidden path="userId" value="${fn:escapeXml(user.userId)}"/>
			</c:forEach>
		
		</form:form>
		
				<!-- タイトル -->
				<div class="d-flex justify-content-center">
					<div class="mt-3">
						<div class="fs-4">〜社内連絡システム〜</div>
					</div>
				</div>
				
			<form:form action="loginConfirm" modelAttribute="result" method="POST">
				
					<!-- IDフォーム -->
				<div class="d-flex justify-content-start">
						ID:
					<form:input class="ID" path="loginId"/>
					<form:errors path="loginId" cssStyle="color: red"/>
				</div>
					
					<!-- passWordフォーム -->
				<div class="d-flex justify-content-start">
						パスワード:
					<form:password class="passWord" path="passWord"/>
					<form:errors path="passWord" cssStyle="color: red"/>
				</div>
				
				<!-- userIdと一致させる -->
				<form:hidden path="userId" value="${fn:escapeXml(users.userId)}"/>
			
					<c:choose>
						
						<c:when test="${typeMatch eq 'ng'}">
							<div class="px-3">
								<div class="error">IDまたは、パスワードが一致しません</div>
							</div>
						</c:when>
					
					</c:choose>	
						
						
						
				<!-- ログインボタン -->
				<form:button class="button">ログイン</form:button>
			
			</form:form>
			
				<br>
			
				<!-- 新規登録ボタン -->
			<form:form action="signUpPage" modelAttribute="result" method="POST">
				
				<c:forEach items="${roleList}" var="roleId" >
					<form:hidden path="roleId" value="${fn:escapeXml(roleId.roleId)}"/>
				</c:forEach>
				
				<div class="mx-2">
					<form:button class="newButton">新規登録</form:button>
				</div>
				
			</form:form>
		
			
	</div>	
	
</body>
</html>