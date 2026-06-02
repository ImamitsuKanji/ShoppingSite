<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/tool/header.jsp">
	<jsp:param value="削除完了" name="title"/>
</jsp:include>

<p>削除しました</p>
<form action="<%= request.getContextPath() %>/views/login/login-in.jsp" method="post">
	<input type="submit" value="ログイン">
</form>

<%@ include file="/tool/footer.html"%>