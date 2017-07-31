<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'showAll.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>

<body>
<s:debug></s:debug>
	<table class="table table-striped control-label table-condensed">
		<tr>
			<th>用户名</th>
			<th>密码</th>
			<th>邮箱</th>
			<th>部门</th>
			<th>删除</th>
			<th>修改</th>
		</tr>
		<s:iterator value="list" var="listMember">
			<tr>
				<td><s:property value="#listMember.name" /></td>
				<td><s:property value="#listMember.pwd" /></td>
				<td><s:property value="#listMember.email" /></td>
				<td><s:property value="#listMember.depart.departName" /></td>
				<td><a class="btn btn-warning" href="users_delete?name=<s:property value="#listMember.name"/>">删除</a></td>
				<td><form action="users_selectByUser" method="post"><input value="<s:property value="#listMember.name"/>" name="name" type="hidden" />
				<button class="btn btn-danger">修改</button>
				</form></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>
