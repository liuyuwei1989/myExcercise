<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册页面</title>
    
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
  	<form action="registerAction">
    	用户名：<input type="text" name="userName"/><br>
    	密码：<input type="text" name="userPwd"/><br>
    	邮箱：<input type="email" name="userEmail" /><br>
    	<input type="checkbox" name="hobby" value="1"/>
    	<input type="checkbox" name="hobby" value="2"/>
    	<input type="checkbox" name="hobby" value="3"/>
    	<input type="submit" /><input type="reset" />
    </form>
  </body>
</html>
