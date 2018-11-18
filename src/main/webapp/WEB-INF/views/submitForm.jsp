<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="sideber.jsp" %>
<html xmlns:th="http://www.thymeleaf.org">


<html>
<head>
<title>メール作成</title>
</head>
<body>
	<h1>メール作成</h1>
	<form:form modelAttribute="submitMailBean">
		<table>
			<tr>
				<td>To:</td>
				<td><form:input path="address" size="40" /></td>
			</tr>
			<tr>
				<td>Subject</td>
				<td><form:input path="subject" size="40" /></td>
			</tr>
			<tr>
				<td>Mail Body</td>
				<td><form:textarea path="mailBody" cols="30" row="20" /></td>
			</tr>
		</table>
		<input type = "submit">
	</form:form>
</body>