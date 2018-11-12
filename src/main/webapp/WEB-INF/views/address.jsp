<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="sideber.jsp" %>
<html xmlns:th="http://www.thymeleaf.org">

<html>
<head>
<title>アドレス一覧</title>
</head>
<body>
	<h1>アドレス一覧</h1>
	<table>
		<tr>
			<td>名前</td>
			<td>アドレス</td>
			<td>ユーザーID</td>
		</tr>

		<c:forEach var="list" items="${addressList}">
			<tr>
				<td>${list.japaneseName}</td>
				<td>${list.address}</td>
				<td>${list.userId}</td>
			</tr>
		</c:forEach>

	</table>
</body>

</html>
