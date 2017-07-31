<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
  <s:property value="user.depart.id" />
  <s:debug></s:debug>
	<form role="form" action="users_saveOrUpdate" method="post">
		用户名：<input type="text" name="name" value='<s:property value="user.name"/>' readonly="readonly"/>
		密码：<input type="text" name="pwd" value='<s:property value="user.pwd"/>'/>
		邮箱：<input type="email" name="email" value='<s:property value="user.email"/>'/>
		<s:select name="depart.id" list="departList" listKey="id" listValue="departName" value="user.depart.id"></s:select>
		<button class="btn btn-default" type="submit">修改</button>
	</form>

  </body>
  
</html>
