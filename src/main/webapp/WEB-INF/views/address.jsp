<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<title>アドレス一覧</title>
	<link href="<c:url value="/resources/css/sideber.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/address.css" />" rel="stylesheet">
</head>
<body>
<div class="main">
	<h1>アドレス一覧</h1>
	<table>
		<thead>
			<tr>
				<td>名前</td>
				<td>アドレス</td>
				<td>ユーザーID</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="list" items="${addressList}">
				<tr>
					<td>${list.japaneseName}</td>
					<td>${list.address}</td>
					<td>${list.userId}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<%@ include file="sideber.jsp" %>
</body>
</html>
