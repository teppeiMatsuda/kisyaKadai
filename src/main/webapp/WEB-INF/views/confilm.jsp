<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="sideber.jsp" %>
<!-- <link rel="stylesheet" href="/common.css"> -->
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
-->
</style>
<html>
<head>
	<title>完了</title>
</head>
<body>
<h1>
	完了画面
</h1>
	<c:if test="${deleteflg == 1}">
	  	削除が完了しました。
	</c:if>
	<c:if test="${midoku == 1}">
	  	選択したメールを未読にしました。
	</c:if>
</body>
</html>
