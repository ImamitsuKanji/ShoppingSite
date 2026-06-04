<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/tool/header.jsp">
	<jsp:param value="編集完了" name="title"/>
</jsp:include>

<p>変更完了いたしました</p>
<meta http-equiv="refresh" content="3;URL=
	${pageContext.request.contextPath}/views/login/login-in.jsp">

<%@ include file="/tool/footer.html"%>