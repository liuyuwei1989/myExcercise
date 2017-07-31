<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'nav.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/bootstrap-treeview.min.css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div>
    	<div id="treeview" class="col-xs-2"></div>
    	<div class="col-xs-10">
    		<iframe src="main.jsp" id="mainframe" name='main' frameborder="0" width="100%" height="800px"></iframe>
    	</div>
    </div>
  </body>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
<script src="js/jquery-1.11.3.min.js"></script> 
<!-- Include all compiled plugins (below), or include individual files as needed --> 
<script src="js/bootstrap-treeview.min.js"></script>
  <script>
	$(function(){
		var defautlData =[
			{
				text:'员工管理系统',
				selectable:false,
				nodes:[
					{
						text:'员工查看',
						href:'User_queryByPage'
					},
					{
						text:'增加员工',
						href:'User_addUser'
					},
					{
						text:'员工管理',
						href:'User_userManage'
					}
				]
			},
			{
				text:'部门管理系统',
				selectable:false,
				nodes:[
					{
						text:'部门查看',
						href:'Depart_showAll'
					},{
						text:'增加部门',
						href:'addDepart.jsp'
					},{
						text:'部门管理',
						href:'Depart_departManage'
					}
				]
			}
		]
		$('#treeview').treeview({
			data:defautlData,
			onNodeSelected:function(event,data){
				document.getElementById("mainframe").src=data.href;
			}
		})
		
	})
	
	
  </script>
</html>
