<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>メールプレビュー</title>
	<link href="<c:url value="/resources/css/prevew.css" />" rel="stylesheet">
</head>
<body>
<div class="main">
	<h1>メールプレビュー</h1>
	<span class="link">
		<a href="reception">受信一覧に戻る</a>
	</span>
	<br/>
	<P class="mail"> タイトル </P>
	<P class="maildata">${title}</P>
	<P class="mail"> 本文</P>
	<P class="maildata">${main}</P>
</div>
<%@ include file="sideber.jsp" %>
</body>
</html>
