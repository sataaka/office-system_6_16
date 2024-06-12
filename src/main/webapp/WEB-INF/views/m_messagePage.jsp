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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/message.css">
<title>メッセージ一覧</title>
</head>
<body>
	<div class="back-color-GroupAdd">
		
		<div class="text">メッセージ検索</div>

		<form:form action="/messageSerach" modelAttribute="result">

			<div class="text">

				<form:input path="input" />
				<form:button>検索</form:button>

			</div>
				
				<div class="text-center">
					<form:errors path="input" cssStyle="color: red"/>
				</div>

			<c:choose>

				<c:when test="${typeMatch eq 'ng'}">

					<div class="text-center">
						<b>検索結果</b>
						<div class="error">該当するメッセージがありません</div>
					</div>

				</c:when>

			</c:choose>

		</form:form>




		<div class="text-center">
			<table class="table table-bordered">
				<thead>
					<c:forEach items="${messageSerach}" var="messageList">
						<tr>

							<td><form:form action="/messageText" modelAttribute="result"
									method="get">
									<form:button class="button">
											${fn:escapeXml(messageList.messageTitle)}/
											${fn:escapeXml(messageList.createDatatime)}/
											${fn:escapeXml(messageList.userName)}
										</form:button>
									<form:hidden path="messageId"
										value="${fn:escapeXml(messageList.messageId)}" />
								</form:form></td>

							<td><form:form action="/messageDelete"
									modelAttribute="result" method="post">
									<form:hidden path="messageId"
										value="${fn:escapeXml(messageList.messageId)}" />
									<form:button class="button1">削除</form:button>
								</form:form></td>

						</tr>
					</c:forEach>
				</thead>

			</table>
		</div>


		<div class="text-center">
			<label>メッセージ一覧</label>
		</div>

		<div class="text-center">
			<table class="table table-bordered">

				<thead>
					<c:forEach items="${messageAllList}" var="messageAll">


						<tr>

							<td><form:form action="/messageText" modelAttribute="result"
									method="get">
									<form:button class="button">
											${fn:escapeXml(messageAll.messageTitle)}/
										 	${fn:escapeXml(messageAll.createDatatime)}/
											${fn:escapeXml(messageAll.userName)}
										</form:button>
									<form:hidden path="messageId"
										value="${fn:escapeXml(messageAll.messageId)}" />
								</form:form></td>
							
							<td><form:form action="/messageDelete"
									modelAttribute="result" method="post">
									<form:hidden path="messageId"
										value="${fn:escapeXml(messageAll.messageId)}" />
									<form:button class="button1">削除</form:button>
								</form:form></td>

						</tr>


					</c:forEach>
				</thead>

			</table>
		</div>

	</div>
</body>
</html>