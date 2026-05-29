<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%request.setAttribute("title", "ログアウト")%>
<jsp:include page="/tool/header.jsp" />

<p>ログアウトしますか</p>
<form action="<c:url value='/Logout.action' />" method="post">
<input type="submit" value="ログアウト" class="logout">
</form>
<form action="login-menu.jsp" method="post"><input type="submit" value="戻る"></form>

<%@ include file="/tool/footer.html"%>