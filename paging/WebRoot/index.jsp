<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
<div class="container">
  <form role="form" action="selectByCondition">
    <div class="input-group">
      <label >关键字：</label>
      <input type="text" name="pageResult.key_word" value='<s:property value="pageResult.key_word"/>' width="30px">
      <label >年龄段:</label>
      <input type="number" name="pageResult.age_min" value='<s:property value="pageResult.age_min"/>' width="30px">
      <label>~</label>
      <input type="number" name="pageResult.age_max" value='<s:property value="pageResult.age_max"/>' width="30px">
      <button class="btn btn-sm btn-success" type="submit">查询</button>
    </div>
  </form>
  <s:debug></s:debug>
  <table class="table table-striped table-hover table-bordered">
    <thead>
      <tr class="tab-pane info">
        <th>用户名</th>
        <th>密码</th>
        <th>邮箱</th>
        <th>年龄</th>
        <th>性别</th>
        <th>部门</th>
        <th>修改</th>
        <th>删除</th>
      </tr>
    </thead>
    <tbody>
      <s:iterator value="pageResult.userList" var="user">
        <tr class="tab-content">
          <td><s:property value="#user.name"/></td>
          <td><s:property value="#user.pwd"/></td>
          <td><s:property value="#user.email"/></td>
          <td><s:property value="#user.age"/></td>
          <td><s:property value="#user.sex"/></td>
          <td><s:property value="#user.depart.departName"/></td>
          <td>修改</td>
          <td>删除</td>
        </tr>
      </s:iterator>
    </tbody>
  </table>
  <div class="btn-group col-lg-12 center-block"> 
    <a href="selectByCondition?pageResult.page=<s:property value="pageResult.prePage"/>&pageResult.key_word=<s:property value="pageResult.key_word"/>&pageResult.age_min=<s:property value="pageResult.age_min"/>&pageResult.age_max=<s:property value="pageResult.age_max"/>" class="btn btn-success">上一页</a>
    <div class="btn btn-info">
      <s:property value="pageResult.page"/>
    </div>
    <a href="selectByCondition?pageResult.page=<s:property value="pageResult.nextPage"/>&pageResult.key_word=<s:property value="pageResult.key_word"/>&pageResult.age_min=<s:property value="pageResult.age_min"/>&pageResult.age_max=<s:property value="pageResult.age_max"/>" class="btn btn-success">下一页</a></div>
</div>
<script type="text/javascript">
	var t1 = $("input[name='pageResult.age_min']").val();
	var t2 = $("input[name='pageResult.age_max']").val();
	if(t1==0){
		$("input[name='pageResult.age_min']").val(null);
	}
	if(t2==0){
		$("input[name='pageResult.age_max']").val(null);
	}
	$(function(){
		
	})
</script>
</body>
</html>
