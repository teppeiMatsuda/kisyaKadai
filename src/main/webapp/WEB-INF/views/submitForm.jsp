<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<title>メール作成</title>
	<link href="<c:url value="/resources/css/sideber.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/submitForm.css" />" rel="stylesheet">
</head>
<body>
<div class="main">
	<h1>メール作成</h1>
	<div class="right">
		複数宛先指定はカンマ区切りで入力して下さい。
		<br/>
		（例：aaa@xxx, bbb@yyy, ccc@zzz）
	</div>
	<div class="submitForm">
		<form:form modelAttribute="submitMailBean">
			<table>
				<tr>
					<td>To</td>
					<td class="text"><form:input path="address"/></td>
				</tr>
				<tr>
					<td>Subject</td>
					<td class="text"><form:input path="subject"/></td>
				</tr>
				<tr>
					<td>Mail Body</td>
					<td class="text"><form:textarea path="mailBody" row="40" /></td>
				</tr>
			</table>
			<input type="submit" value="送信">
		</form:form>
	</div>
</div>
<%@ include file="sideber.jsp" %>
</body>
</html>