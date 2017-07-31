<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addDepart.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/bootstrap.css" rel="stylesheet">
	<script src="js/jquery-1.11.3.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div class="container">
		<div class="col-xs-6 col-xs-offset-3">
			<form role="form" method="post" action="User_insert">
				<div class="form-group">
					<label>部门名称：</label>
					<s:textfield cssClass="form-control" theme="simple"
						placeholder="部门名称" name="name"></s:textfield>
				</div>
				<div>
					<label>部门定员：</label><br>
					<input type="number" class="form-control" 
						placeholder="部门定员" name="count">
				<br>
				<div class="form-group">
					<div class="col-xs-offset-2 col-xs-3">
						<button type="submit" class="btn btn-info">添加</button>
					</div>
					<div class="col-xs-offset-2 col-xs-3">
						<button type="reset" class="btn btn-danger">重置</button>
					</div>
				</div>
				</form>
			</div>
		</div>
  </body>
</html>
