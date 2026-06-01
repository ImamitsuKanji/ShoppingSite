<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/tool/header.jsp">
	<jsp:param value="管理者ログイン" name="title"/>
</jsp:include>

<jsp:include page="/tool/logout-check.jsp"/>

<!--修正ボタン（仮）-->
	<input type="submit" value="修正">
<!--削除ボタン（仮）-->
	<input type="submit" value="削除">
<!--	ログアウトボタン-->
	<form action="${pageContext.request.contextPath}/views/logout/logout-in.jsp" method="post">
		<input type="submit" value="ログアウト">
	</form>

<%@ include file="/tool/footer.html"%>