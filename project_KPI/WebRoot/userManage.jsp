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
    
    <title>My JSP 'userManage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/bootstrap.css">
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
				<th align="center" valign="middle">员工姓名</th>
				<th align="center" valign="middle">所属部门</th>
				<th align="center" valign="middle">员工照片</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="userList" var="user">
			<tr>
				<td align="center" valign="middle"><s:property value="#user.name"/></td>
				<td align="center" valign="middle"><s:property value="#user.depart.name"/></td>
				<td align="center" valign="middle"><img src='images/<s:property value="#user.photo"/>' width="70px" height="100px"/></td>
				<td align="center" valign="middle"><div class="btn-group">
					<a href="User_findUser?id=<s:property value="#user.id"/>" class="btn btn-info">修改</a>
					<a href="User_deleteUser?userId=<s:property value="#user.id"/>" class="btn btn-warning">删除</a>
				</div></td>
			</tr>
			</s:iterator>
		</tbody>
		</table> <br>
		<nav aria-label="Page navigation">
	<ul class="pagination">
	<%-- 根据目前所处的页面，选择页面显示的不同效果 --%>
		<s:if test="pagingUtils.page==1">
			<li class="disabled">
		</s:if>
		<s:else>
			<li>
		</s:else>
			<a href="User_userManage?pagingUtils.page=<s:property value="pagingUtils.prePage"/>" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
		</a></li>
		<s:iterator value="pagingUtils.pageList" var="pageNo">
			<s:if test="pagingUtils.page==#pageNo">
				<li class="active">
			</s:if>
			<s:else>
				<li>
			</s:else>
		<a href="User_userManage?pagingUtils.page=<s:property value="#pageNo"/>"><s:property value="#pageNo"/></a></li>
		</s:iterator>
		
		<s:if test="pagingUtils.page==pagingUtils.totalPage">
			<li class="disabled">
		</s:if>
		<s:else>
			<li>
		</s:else>
		<a href="User_userManage?pagingUtils.page=<s:property value="pagingUtils.nextPage"/>" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
		</a></li>
	</ul>
	</nav>
  </body>
</html>
