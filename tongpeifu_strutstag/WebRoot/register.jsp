<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'register.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<s:form action="RegisterAction_doRegiser">
		<table>
			<tr>
				<td>name:</td>
				<td><s:textfield name="userName"></s:textfield></td>
			</tr>
			<tr>
				<td>password:</td>
				<td><s:password name="userPwd"></s:password></td>
			</tr>
			<tr>
				<td>age</td>
				<td><s:textfield name="userAge"></s:textfield></td>
				
			</tr>
			<tr>
				<td>sex</td>
				<td><s:textfield name="userSex"></s:textfield></td>
			</tr>
			<tr>
				<td><s:submit name="注册"></s:submit></td>
				<td><s:reset name="重置"></s:reset></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
