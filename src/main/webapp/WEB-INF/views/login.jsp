<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<link rel="stylesheet" href="./css/common.css">
<html>
<head>
	<title>かっこいいメール</title>
</head>
<body>
<h1 class="title">
	(いい)メール「かっこいいめーる」( ;∀;)
</h1>
<form action="reception" method="get">
	<input type="text" name="login"></input>
	<br />
	<input type="password" name="password"></input>
	<br />
	<input type="submit" value="ログイン"></input>
	<input type="button" value="クリア"></input>
</form>
</body>
</html>
