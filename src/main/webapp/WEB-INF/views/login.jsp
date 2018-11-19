<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!--
<style type="text/css">
/* errorMassegeクラスのCSSは
 * login.cssファイルにまとめて記載しました
 */
</style>
-->
<html>
<head>
	<title>かっこいいメール</title>
	<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
</head>
<body>
<h1 class="title">
	(いい)「かっこいいめーる」( ;∀;)
</h1>
<c:if test="${data != null}">
  	<p class="errorMassege"><c:out value="${data}"/></p>
</c:if>
<form action="reception" method="POST">
	<div class="input_center">
		<label class="id">ID</label>
		<input type="text" name="loginid"></input>
		<br/>
	</div>
	<div class="input_center">
		<label class="pw">Password</label>
		<input type="password" name="password"></input>
		<br/>
	</div>
	<br/>
	<input type="submit" value="ログイン" class="button login"></input>
	<input type="button" value="クリア" class="button clear" ></input>
</form>
</body>
</html>
