<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="jp.co.aforce.beans.User"%>

<%
User user = (User) session.getAttribute("user");

if (user != null) {
%>
<p>ようこそ、${user.lastName}さん！</p>
<%
} else {
%>
<p>ログインされていません。</p>
<%
}
%>