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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/newUserPage.css">
<title>新規登録画面</title>
</head>
<body>
	
	<!-- タイトル -->
	<div class="newDisplay1">
		<div class="d-flex justify-content-center">
			<div class="mt-2">
				<div class="fs-4">
					<div class="text-white">新規ユーザー登録画面</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="newDisplay2">
	
				<!-- 新規登録画面 -->
		<form:form action="/signUp" modelAttribute="result" method="post">
			<div class="mx-3">
					<label class="py-1">名前</label>
					<br>
				<form:input class="input" path="userName"/><form:errors path="userName" cssStyle="color: red"/>
			</div>
			
			<div class="mx-3">
				<label class="py-1">メールアドレス</label> 
					<br>
				<c:choose>

					<c:when test="${typeMatch eq 'ok'}">
						<div class="error">すでに登録されているメールアドレスなので、変更してください</div>
					</c:when>

				</c:choose>
				<form:input class="input" path="loginId"/><form:errors path="loginId" cssStyle="color: red"/>
			</div>
			
			<div class="mx-3">
				<label class="py-1">パスワード</label>　
					<br>
				<form:password class="input" path="passWord"/><form:errors path="passWord" cssStyle="color: red"/>
			</div>
			
			<div class="mx-3">
				<label class="py-1">電話番号</label> 
					<br>
				<form:input class="input" path="telNo"/><form:errors path="telNo" cssStyle="color: red"/>
			</div>
				
			<div class="mx-3">
				<label class="py-1">権限</label>
					<br>
				<form:select class="selectBox" path="roleId">
	        		<form:options items="${roleList}" itemLabel="roleName" itemValue="roleId" /><form:errors path="roleId" cssStyle="color: red"/>
	      		</form:select>
	     	</div>
	     			<br>
	     			
	     	<div class="mx-3">
	     		<form:button class="newButton"><b>登録</b></form:button>
	     	</div>
		
		</form:form>
		
	</div>
	
</body>
</html>