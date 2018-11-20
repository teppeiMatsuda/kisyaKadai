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
	<title>受信メール一覧</title>
</head>
<body>
<h1>
	受信メール一覧
</h1>
	<c:if test="${deleteflg == 1}">
	  	削除します
	</c:if>
	<form action="update" method="POST">
		<p class="center">
			<input type="submit" name="deleteflg" value="1">削除
			<input type="submit" name="midokuflg" value="1">未読にする
		</p>
		<c:if test="${data.size() > 0}" var="flag">
			<table border="1">
				<tr>
					<td></td>
					<td>受信日</td>
					<td>タイトル</td>
					<td>送信者</td>
					<td></td>
					<td></td>
				</tr>
				<c:forEach var="obj" items="${data}" varStatus="status">
			  		<tr>
			  			<td class="naiyo"><input type="checkbox" name="maildata" value="${obj.mailid}"></td>
						<td class="naiyo"><c:out value="${obj.recept_date}"/></td>
						<td class="naiyo"><c:out value="${obj.title}"/></td>
						<td class="naiyo">${obj.mail_from}</td>
						<td class="naiyo"><a href="prevew?id=${obj.mailid}">詳細</a></td>
						<td class="naiyo">
							<c:choose>
								<c:when test="${obj.read_flg == 1}">既読</c:when>
								<c:otherwise>未読</c:otherwise>
							</c:choose>
						</td>
			  		</tr>
				</c:forEach>
			</table>
		</c:if>
	</form>
	<c:if test="${!flag}">
		<p class="center">受信メールはありません。</p>
	</c:if>
</body>
</html>
