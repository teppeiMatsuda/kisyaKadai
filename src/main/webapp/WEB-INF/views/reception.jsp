<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>受信メール一覧</title>
	<link href="<c:url value="/resources/css/reception.css" />" rel="stylesheet">
</head>
<body>
<div class="main">
	<h1>受信メール一覧</h1>
	<c:if test="${deleteflg == 1}">
	  	削除します
	</c:if>
	<form action="update" method="POST">
		<p class="right">
			<input type="submit" name="deleteflg" value="1">削除
			<input type="submit" name="midokuflg" value="1">未読にする
		</p>
		<c:if test="${data.size() > 0}" var="flag">
			<table border="1">
				<thead>
					<tr>
						<td></td>
						<td>受信日</td>
						<td>タイトル</td>
						<td>送信者</td>
						<td></td>
						<td></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="obj" items="${data}" varStatus="status">
				  		<tr>
				  			<td class="naiyo naiyo1"><input type="checkbox" name="maildata" value="${obj.mailid}"></td>
							<td class="naiyo naiyo2"><c:out value="${obj.recept_date}"/></td>
							<td class="naiyo naiyo3"><c:out value="${obj.title}"/></td>
							<td class="naiyo naiyo4">高島</td>
							<td class="naiyo naiyo5"><a href="prevew?id=${obj.mailid}">詳細</a></td>
							<td class="naiyo naiyo6">
								<c:choose>
									<c:when test="${obj.read_flg == 1}">既読</c:when>
									<c:otherwise>未読</c:otherwise>
								</c:choose>
							</td>
				  		</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</form>
	<c:if test="${!flag}">
		<p class="left">受信メールはありません。</p>
	</c:if>
</div>
<%@ include file="sideber.jsp" %>
</body>
</html>
