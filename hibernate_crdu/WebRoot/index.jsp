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

<title>My JSP 'index.jsp' starting page</title>
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
	<form role="form" action="users_insert" method="post">
		用户名：<input type="text" name="name" /> 密码：<input type="password"
			name="pwd" /> 邮箱：<input type="email" name="email" /> 部门：<select
			name="depart.id"><s:iterator value="departList" var="depart">
				<option value="<s:property value="#depart.id" />"><s:property value="#depart.departName" /></option>
			</s:iterator></select>
		<button class="btn btn-default" type="submit">注册</button>
	</form>
</body>

</html>
