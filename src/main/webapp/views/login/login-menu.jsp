<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/tool/header.jsp">
	<jsp:param value="ログイン" name="title"/>
</jsp:include>

<jsp:include page="/tool/logout-check.jsp"/>

<!--修正ボタン（仮）-->
	<input type="submit" value="修正">
<!--削除ボタン（仮）-->
<!--<%-->
<!--String role= request.getParameter("role");-->
<!--String url;-->
<!--if(role.equals(admin)){-->
<!--	url= "/views/delete/delete-input.jsp";-->
<!--}else{-->
<!--	url= "/views/delete/delete-check.jsp";-->
<!--}-->
<!--%>-->

	<form action="${pageContext.request.contextPath}/delete/DeleteUserSerch.action" method="post">
		<input type="hidden" name="lastname" value="${user.lastname}">
		<input type="submit" value="削除">
	</form>
<!--	ログアウトボタン-->
	<form action="${pageContext.request.contextPath}/views/logout/logout-in.jsp" method="post">
		<input type="submit" value="ログアウト">
	</form>

<%@ include file="/tool/footer.html"%>