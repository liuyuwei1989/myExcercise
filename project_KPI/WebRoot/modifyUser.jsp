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
<title>My JSP 'addUser.jsp' starting page</title>
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
<s:debug></s:debug>
	<div class="container">
		<div class="col-xs-6 col-xs-offset-3">
			<form role="form" method="post" action="User_update" method="post" enctype="multipart/form-data">
				<input type="hidden" name="user.id" value='<s:property value="userOld.id"/>' />
				<div class="form-group">
					<label>员工姓名：</label>
					<input class="form-control" name="user.name" value="<s:property value="userOld.name"/>">
				</div>
				<div>
					<label>员工性别：</label><br>
					<s:radio list="{'男','女'}" name="user.sex" theme="simple" value="userOld.sex"></s:radio>
				</div>
				<div class="form-group">
					<label>出生日期：</label> <input type="text" class="form-control"
						name="user.birth" onClick="WdatePicker()" value='<s:date name="userOld.birth" format="yyyy-MM-dd"/>'>
				</div>
				<div class="form-group">
					<label>邮箱:</label> <input type="email" class="form-control"
						name="user.email" value="<s:property value="userOld.email"/>" />
				</div>
				<div class="form-group">
					<label>上传头像</label>
					<s:file name="image"></s:file>
				</div>
				<div class="form-group">
					<label>所属部门：</label>
					<s:select name="departId" list="departList" listKey="id"
						listValue="name" cssClass="form-control" value="userOld.depart.id"></s:select>
				</div>
				<div class="form-group">
					<div class="col-xs-offset-2 col-xs-3">
						<button type="submit" class="btn btn-info">更改</button>
					</div>
					<div class="col-xs-offset-2 col-xs-3">
						<button type="reset" class="btn btn-danger">重置</button>
					</div>
				</div>
				</form>
			</div>
		</div>
		<SCRIPT language=JavaScript src="My97DatePicker/WdatePicker.js"></SCRIPT>
</body>
</html>
