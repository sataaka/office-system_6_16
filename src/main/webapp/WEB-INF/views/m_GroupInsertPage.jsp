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
<title>グループ画面</title>
</head>
<body>
	
	<div class="back-color">
	
		<div class="text-group"><b>グループ作成</b></div>
		
		<div class="textgroupName">〜グループ名入力欄〜</div>
			<form:form action="/groupInsertName" modelAttribute="result" method="post">
				<div class="text">
					<form:input class="input" path="groupName"/>
					<form:button class="button" id="btn">作成</form:button>
					<form:errors path="groupName" cssStyle="color: red"/>
					<script src="js/tool.js"></script>
				</div>
			</form:form>
		
		<c:choose>

			<c:when test="${typeMatch eq 'ok'}">
				<div class="text">
					<div class="error">同じ名前のグループがあるので、名前を変更してください</div>
				</div>
			</c:when>

		</c:choose>

	</div>	
</body>
</html>