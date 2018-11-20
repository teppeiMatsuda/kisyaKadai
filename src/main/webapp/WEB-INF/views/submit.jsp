<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>送信メール一覧</title>
	<link href="<c:url value="/resources/css/submit.css" />" rel="stylesheet">
</head>
<body>
<div class="main">
	<h1>送信メール一覧</h1>
	<form action="submitUpdate" method="POST">
		<p class="right">
			<input type="submit" name="deleteflg" value="1">削除
		</p>
		<c:if test="${data.size() > 0}" var="flag">
			<table border="1">
				<thead>
					<tr>
						<td></td>
						<td>宛先</td>
						<td>タイトル</td>
						<td>本文</td>
						<td>受信日時</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="obj" items="${data}" varStatus="status">
				  		<tr>
				  			<td class="naiyo naiyo1"><input type="checkbox" name="maildata" value="${obj.mailid}"></td>
				  			<td class="naiyo naiyo5"><c:out value="${obj.mail_to}"/></td>
							<td class="naiyo naiyo3"><c:out value="${obj.title}"/></td>
							<td class="naiyo naiyo4"><a href="submitPrevew?id=${obj.mailid}">詳細</a>
							<td class="naiyo naiyo2"><c:out value="${obj.recept_date}"/></td></td>
				  		</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</form>
	<c:if test="${!flag}">
		<p class="left">送信メールはありません。</p>
	</c:if>
</div>
<%@ include file="sideber.jsp" %>
</body>
</html>
