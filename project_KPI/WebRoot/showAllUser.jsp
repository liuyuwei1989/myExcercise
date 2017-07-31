<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'showAllUser.jsp' starting page</title>

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
	<table
		class="table table-bordered table-responsive table-striped table-hover">
		<thead>
			<tr class="info">
				<th align="center" valign="middle">员工姓名</th>
				<th align="center" valign="middle">员工性别</th>
				<th align="center" valign="middle">员工生日</th>
				<th align="center" valign="middle">员工邮箱</th>
				<th align="center" valign="middle">入职时间</th>
				<th align="center" valign="middle">所属部门</th>
				<th align="center" valign="middle">员工照片</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="userList" var="user">
				<tr>
					<td align="center" valign="middle"><s:property
							value="#user.name" /></td>
					<td align="center" valign="middle"><s:property
							value="#user.sex" /></td>
					<td align="center" valign="middle"><s:date name="#user.birth"
							format="yyyy-MM-dd" /></td>
					<td align="center" valign="middle"><s:property
							value="#user.email" /></td>
					<td align="center" valign="middle"><s:date
							name="#user.addTime" format="yyyy-MM-dd hh:mm" timezone="UTC+8" /></td>
					<td align="center" valign="middle"><s:property
							value="#user.depart.name" /></td>
					<td align="center" valign="middle"><img
						src='images/<s:property value="#user.photo"/>' width="70px"
						height="100px" /></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<nav aria-label="Page navigation">
	<ul class="pagination">
	<%-- 根据目前所处的页面，选择页面显示的不同效果 --%>
		<s:if test="pagingUtils.page==1">
			<li class="disabled">
		</s:if>
		<s:else>
			<li>
		</s:else>
			<a href="User_queryByPage?pagingUtils.page=<s:property value="pagingUtils.prePage"/>" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
		</a></li>
		<s:iterator value="pagingUtils.pageList" var="pageNo">
			<s:if test="pagingUtils.page==#pageNo">
				<li class="active">
			</s:if>
			<s:else>
				<li>
			</s:else>
		<a href="User_queryByPage?pagingUtils.page=<s:property value="#pageNo"/>"><s:property value="#pageNo"/></a></li>
		</s:iterator>
		
		<s:if test="pagingUtils.page==pagingUtils.totalPage">
			<li class="disabled">
		</s:if>
		<s:else>
			<li>
		</s:else>
		<a href="User_queryByPage?pagingUtils.page=<s:property value="pagingUtils.nextPage"/>" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
		</a></li>
	</ul>
	</nav>
</body>
	
</html>
