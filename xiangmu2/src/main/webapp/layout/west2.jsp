<%@ page language="java" import="java.util.*,com.chinasofti.vo.xitong.Authority" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title></title>
		<!-- jquery库 -->

<script type="text/javascript"
	src="<%=basePath%>js/jquery-easyui-1.4.5/jquery.min.js" charset="utf-8">
</script>
    
	</head>

	<body onload="addtab('员工角色管理','employeeRoleControl/gotoEmployeeRoleList.action')">
 
		<!--  ==================手风琴菜单（从Accordion（分类）里）strart==========================  
				data-options="fit:true"  加在最外层的div让最外层适合父容器 
			-->
		<div id="aa" class="easyui-accordion" data-options="fit:true"
			style="width: 300px; height: 200px;">
		
	
			<c:forEach items="${applicationScope.oneList}" var="au1">
			
			<div title="${au1.AUTHORITY_NAME}" data-options="iconCls:'icon-reload',selected:true"
				style="padding: 10px;">
				<ul id="tt" class="easyui-tree">
				
					<c:forEach items="${applicationScope.twoList}" var="au2">
					    <li>   <!-- addtab()这个方法在index.jsp中，这个方法如果放在west.jsp中，找不到不好用 -->
						    <span><a onclick="addtab('员工角色管理','employeeRoleControl/gotoEmployeeRoleList.action')">${au2.AUTHORITY_NAME}</a></span>
					    </li>
					</c:forEach>
				</ul>
			</div>
			
			</c:forEach>
			
			
			
			
			<div title="系统管理" data-options="iconCls:'icon-reload',selected:true"
				style="padding: 10px;">
				<ul id="tt" class="easyui-tree">
					<li>   <!-- addtab()这个方法在index.jsp中，这个方法如果放在west.jsp中，找不到不好用 -->
						<span><a onclick="addtab('员工角色管理','employeeRoleControl/gotoEmployeeRoleList.action')">员工角色管理</a></span>
					</li>
					<li>
						<span><a onclick="addtab('角色管理','roleControl/gotoRoleList.action')">角色管理</a></span>
					</li>
					<li>
						<span><a onclick="addtab('统计图','roleControl/gotoTongjitu.action')">统计图</a></span>
					</li>
				</ul>
			</div>

			<div title="用户管理">
				<ul id="tt" class="easyui-tree">

					<li>   
						<span><a onclick="addtab('用户管理','employeeControl/gotoEmployeeList.action')"> 用户管理</a></span>
					</li>
				
				</ul>
			</div>
			
			
			<div title="区域管理">
				<ul id="tt" class="easyui-tree">

					<li>   
						<span><a onclick="addtab('区域管理','quyuControl/gotoQuyuList.action')"> 区域管理</a></span>
					</li>
					<li>
						<span><a onclick="addtab('部门管理','departmentControl/gotoDepartmentList.action')">部门管理</a></span>
					</li>
					<li>
						<span><a onclick="addtab('职称管理','positionControl/gotoPositionList.action')">职称管理</a></span>
					</li>
				</ul>
			</div>

		</div>
		

	

		<!--  ==================手风琴end==========================           -->
	</body>
</html>
