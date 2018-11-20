<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>完了</title>
	<link href="<c:url value="/resources/css/confilm.css" />" rel="stylesheet">
</head>
<body>
<div class="main">
	<h1>完了画面</h1>
	<c:if test="${deleteflg == 1}">
	  	<p class="left">削除が完了しました。</p>
	</c:if>
	<c:if test="${midokuflg == 1}">
	  	<p class="left">選択したメールを未読にしました。</p>
	</c:if>
</div>
<%@ include file="sideber.jsp" %>
</body>
</html>
