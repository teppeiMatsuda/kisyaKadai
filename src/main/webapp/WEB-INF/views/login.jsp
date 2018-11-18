<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<style type="text/css">
<!--
.errorMassege{
	text-align:center;
	color:red;
}

-->
</style>
<html>
<head>
	<title>かっこいいメール</title>
	<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
</head>
<body>
<h1 class="title">
	(いい)メール「かっこいいめーる」( ;∀;)
</h1>
<c:if test="${data != null}">
  	<p class="errorMassege"><c:out value="${data}"/></p>
</c:if>
<form action="reception" method="POST">
	<span class="id">ID</span>
	<input type="text" name="loginid"></input>
	<br />
	<span class="pw">Password</span>
	<input type="password" name="password"></input>
	<br />
	<input type="submit" value="ログイン"></input>
	<input type="button" value="クリア"></input>
</form>
</body>
</html>
