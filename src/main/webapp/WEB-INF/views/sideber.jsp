<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<link href="<c:url value="/resources/css/sideber.css" />" rel="stylesheet">
</head>
<body>
	<div class="side">
		<ul class="sb">
			<li><a href="reception">受信メール一覧</a></li>
			<li><a href="submitList">送信メール一覧</a></li>
			<li><a href="submitForm">メール作成</a></li>
			<li><a href="address">アドレス一覧</a></li>
			<li><a href="/mail">ログアウト</a></li>
		</ul>
	</div>
</body>
</html>