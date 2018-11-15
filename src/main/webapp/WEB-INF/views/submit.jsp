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
.center{
	text-align:center;
	margin-left: auto;
	margin-right: auto;
}

-->
</style>
<html>
<head>
	<title>送信メール一覧</title>
</head>
<body>
<h1>
	送信メール一覧
</h1>
	<form action="submitUpdate" method="POST">
		<p class="center">
			<input type="submit" name="deleteflg" value="1">削除
		</p>
		<c:if test="${data.size() > 0}" var="flag">
			<table border="1">
				<tr>
					<td></td>
					<td>送信日</td>
					<td>タイトル</td>
					<td></td>
				</tr>
				<c:forEach var="obj" items="${data}" varStatus="status">
			  		<tr>
			  			<td class="naiyo"><input type="checkbox" name="maildata" value="${obj.mailid}"></td>
						<td class="naiyo"><c:out value="${obj.recept_date}"/></td>
						<td class="naiyo"><c:out value="${obj.title}"/></td>
						<td class="naiyo"><a href="submitPrevew?id=${obj.mailid}">詳細</a></td>
			  		</tr>
				</c:forEach>
			</table>
		</c:if>
	</form>
	<c:if test="${!flag}">
		<p class="center">送信メールはありません。</p>
	</c:if>
</body>
</html>
