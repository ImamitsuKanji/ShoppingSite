<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:include page="/tool/header.jsp">
	<jsp:param value="ログアウト確認" name="title"/>
</jsp:include>

<!--ログアウトボタン-->
<p>ログアウトしますか</p>
<form action="${pageContext.request.contextPath}/Logout.action" method="post">
	<input type="submit" value="ログアウト" class="logout">
</form>

<!--戻るボタン-->
<input type="button" value="メニューへ戻る"
		onclick="location.href=
				'${pageContext.request.contextPath}/views/login/login-menu.jsp'">

<%@ include file="/tool/footer.html"%>