<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="sideber.jsp" %>
<style type="text/css">
<!--
h1{
	text-align:center;
	color:red;
}
table {
	text-align:center;
	margin-left: auto;
	margin-right: auto;
	border
}
.naiyo {
	padding: 5px;
}
.mail {
	text-align:center;
}
-->
</style>
<html>
<head>
	<title>メールプレビュー</title>
</head>
<body>
<h1>
	メールプレビュー
</h1>

<P class="mail"> タイトル </P>
<P class="mail">${maildata.title}</P>
<P class="mail"> 本文</P>
<P class="mail">${maildata.main}</P>
</body>
</html>
