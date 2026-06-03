<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/tool/header.jsp">
	<jsp:param value="削除" name="title" />
</jsp:include>

<form action="
${pageContext.request.contextPath}/update/DeleteUserSerch.action" method="post">
	
	<p>名前:<input type="text" name="lastname" value="${userlastname}" required></p>
	
	<input type="submit" value="検索">
	<input type="button" value="戻る" onclick="location.href=
					'${pageContext.request.contextPath}/views/login/login-menu.jsp'">
	
</form>

<%@ include file="/tool/footer.html"%>