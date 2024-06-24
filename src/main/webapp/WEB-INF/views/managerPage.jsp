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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/Top.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>管理者画面</title>
</head>
<body>

	<div class="background-color-Top">
		<!-- ユーザー名が表示される -->
		<div class="px-4">
			<div class="pt-3">ようこそ<b>${fn:escapeXml(users.userName)}さん</b></div>
		</div>
	
	
		<!-- LoginPageControllerクラスのformクラスの処理が、実行される。 -->
		
					<!-- グループ名を検索 -->
			<div>
			
				<div class="px-4">
					<form:form action="/M_GroupSearch" modelAttribute="result" method="post">
						<div class="p-1">
							<form:hidden path="userId" value="${fn:escapeXml(users.userId)}"/>
							<form:input class="input" path="groupName"/>
							<input class="button" type="submit" value="検索">
							<form:errors path="groupName" cssStyle="color: red"/>
						</div>
					</form:form>	
				</div>
						
					<c:choose>						
						<c:when test="${typeMatch eq 'ng'}">
							<div class="error">グループがありません</div>
						</c:when>
					
						<c:when test="${typeMatch eq 'ok'}">
							<form:form action="/GroupPage" modelAttribute="result" method="post">
								
								<td>
									<div class="d-flex p-1 bd-highlight">
										<div class="px-3"><b>${fn:escapeXml(groupSearch.groupName)}</b></div>
									
									<form:hidden path="groupId" value="${fn:escapeXml(groupSearch.groupId)}"/>
									
										<form:button class="btn-primary btn-block">選択</form:button>
									
									</div>
								</td>
							
							</form:form>
						</c:when>
					</c:choose>
					
			</div>
		
	
		
				<!-- グループ名を表示 -->
		<div>
			<!-- LoginPageControllerクラスの sessionに保存した値　繰り返しても(MessageDaoクラスのメソッドで指定したDBにgroupIdを紐づけている。)-->
			<c:forEach items="${GroupList}" var="Group">

				<tr>
					<!-- GroupPageControllerクラスのURL  -->
					<form:form action="/GroupPage" modelAttribute="result"
						method="post">

						<!-- <forEach items="${userGroupList}" var="userGroup">タグに紐づけた値 -->
						<td>
							<div class="d-flex p-1 bd-highlight">
								<div class="px-3">
									<b>${fn:escapeXml(Group.groupName)}</b>
								</div>

								<!-- groupIdは、(userGroupList)から、取得した,groupIdをフォームにして一致したグループIDだけをgroupPageに渡す -->
								<form:hidden path="groupId"
									value="${fn:escapeXml(Group.groupId)}" />

								<input class="btn-primary btn-block" type="submit" value="選択">
							</div>
						</td>

					</form:form>

				</tr>
			</c:forEach>

		</div>

		<br>
		
			<!-- コントロラークラスに推移先を指定したら変更する -->
		<div class=mx-3>
		<form:form action="users" modelAttribute="result" method="post">
			<form:button class="button">ユーザー一覧</form:button>
		</form:form>
		</div>
		
			<br>
		
			<!-- コントロラークラスに推移先を指定したら変更する -->
		<div class=mx-3>
		<form:form action="/messagePage" modelAttribute="result">
			<form:button class="button">メッセージ一覧</form:button>
		</form:form>
		</div>
		
			<br>
		
			<!-- コントロラークラスに推移先を指定したら変更する -->
		<div class=mx-3>
			<form:form action="/groupInsertPage" modelAttribute="result">
				<form:button class="button">グループ作成</form:button>
			</form:form>
		</div>
			
			<br>
		
			<!-- コントロラークラスに推移先を指定したら変更する -->
		<div class=mx-3>
			<form:form action="/messageInsertPage" modelAttribute="result" method="post">
				<form:button class="button">メッセージ作成</form:button>
			</form:form>
		</div>
			
			<br>
			
			<!-- コントロラークラスに推移先を指定したら変更する -->
		<div class=mx-3>
			<form:form action="/logOut" modelAttribute="result">
				<form:button class="button">ログアウト</form:button>
			</form:form>
		 </div>
			
			<br>
			
	</div>	
	
</body>
</html>