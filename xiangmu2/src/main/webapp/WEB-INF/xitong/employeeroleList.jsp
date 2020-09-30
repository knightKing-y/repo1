<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  import=" com.chinasofti.util.MessageUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=basePath%>css/base.css" />
<link rel="stylesheet" href="<%=basePath%>css/info-mgt.css" />
<link rel="stylesheet" href="<%=basePath%>css/WdatePicker.css" />


<script type="text/javascript"  src="<%=basePath%>js/jquery-easyui-1.4.5/jquery.min.js" charset="utf-8"></script>
<!---------------------------  复选框实现单选js文件  ------------------------------------>
<script type="text/javascript"  src="<%=basePath%>js/form.js" charset="utf-8"></script>
<script type="text/javascript">
    var path ="<%=basePath%>";
    
    
	 //进入修改页面
	function updateEmployeeRole() {
		
      var num = getCheckBoxValue('employee_id');
     
      if(num == null || num == ""){
    	  alert("请选择要修改的员工");
    	  return false;
      }else{
    	  window.location.href = path+ "employeeRoleControl/gotoUpdateEmployeeRole.action?employee_id="+num;
      
      }
    }
	 
	 

	 
	</script>
</head>
<body>

	<div class="title">
		<h2>员工权限管理</h2>
	</div>
	<div class="query">
		<div class="query-conditions ue-clear">
			<!-----------    按钮  start   ---------->
			<div style="position: absolute; right: 0; margin: -45px 30px 0 0">
			  
				  <a href="#" id="update" class="abtn"> 
				     <img  src="<%=basePath%>images/revise_btn.png" border="0" id="Image2"  onclick="updateEmployeeRole()"/>
				  </a>
				
			</div>
			<!------------ 按钮  end ---------->
		</div>
	</div>
	<div   id="aa">
	
		<table border="2" cellpadding="1" >
			<tr>
				<th class="num"></th>
				<th class="name">姓名</th>
				<th class="name">帐户名</th>
				<th class="process">角色名</th>
				<th class="process">角色状态</th>
			</tr>
			<c:forEach items="${requestScope.employeeroleList}" var="employeerole">
				<tr>
					<td class="num"><input type="checkbox" name="employee_id"
						id="employee_id" value="${employeerole.employee_id}" onClick="javascript:chooseOne(this,'employee_id');" ></td>
					<td class="name">${employeerole.employee_name}</td>
					<td class="name">${employeerole.employee_loginname}</td>
					<td class="process">${employeerole.role_name}</td>
					<td class="process">
					<c:if test="${employeerole.role_state == 0}">
					  有效
					</c:if>
					<c:if test="${employeerole.role_state == 1}">
					   无效
					</c:if>
					
					</td>
				</tr>
			</c:forEach>
		</table>
		
	</div>
	

</body>

</html>