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
    
    <title>My JSP 'departManage.jsp' starting page</title>
    
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
       <table class="table table-bordered table-responsive table-striped table-hover">
		<thead>
			<tr class="info">
				<th align="center" valign="middle">部门名称</th>
				<th align="center" valign="middle">部门定员</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="departList" var="depart">
			<tr>
				<td align="center" valign="middle"><s:property value="#depart.name"/></td>
				<td align="center" valign="middle"><s:property value="#depart.count"/></td>
				<td align="center" valign="middle"><div class="btn-group">
					<a href="" class="btn btn-info">修改部门信息</a>
					<a href="" class="btn btn-danger">更改部门人员</a>
					<a href="" class="btn btn-warning">解散部门</a>
				</div></td>
			</tr>
			</s:iterator>
		</tbody>
	</table> <br>
  </body>
</html>
