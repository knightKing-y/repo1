<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.chinasofti.util.MessageUtil"%>
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

<link href="<%=basePath%>css/right.css" rel="stylesheet" type="text/css" />
<!-- ------------JQuery  JS----------------- -->
<script type="text/javascript"
	src="<%=basePath%>js/jquery-easyui-1.4.5/jquery.min.js" charset="utf-8"></script>
<!-- ------------表单验证JS----------------- -->
<script type="text/javascript" src="<%=basePath%>js/addrole.js"
	charset="utf-8"></script>
	<!--------------------------- 引入三级联动js文件  ------------------------------------>
	<script type="text/javascript"
	src="<%=basePath%>js/addemployee.js" charset="utf-8"></script>
	<script type="text/javascript">
	var path="<%=basePath%>";
	</script>
</head>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="31" class="right_tittle">您的位置：<a
			href="<%=basePath%>employeeControl/gotoEmployeeList.action">员工管理</a>
			&gt;&gt;修改员工
		</td>
	</tr>
</table>

<form action="<%=basePath%>employeeControl/updateEmployee.action?page=1&employee_id=${e.employee_id}"
	method="post" id="form1">

	<table width="100%" border="0" align="left" cellspacing="0"
		cellpadding="0" bordercolor="red">
		
			<tr>
			<td  width="120"    height="30"   rowspan="8"></td>
			</tr>
	
		<tr>
			<td width="10" height="30" align="left">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:<input type="text"
				id="employee_name" name="employee_name" class="{required:true}"
				maxlength="16" value="${e.employee_name }"onblur="checkemployee_name()"/>	
				<span id="employee_namemsg" style="color: red"></span>
			</td>
			<td width="100" class="inputText">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:
			 <select
				id="employee_sex" name="employee_sex" class="{required:true}"
				style="color: red"  onblur="checkemployee_level()">
			<%  String str7=""; %>
			<%  String str8=""; %>
			<c:if test="${e.employee_sex==0 }">
			<% str7="selected"; %>
					
		    </c:if>
		    <c:if test="${e.employee_sex==1 }">
		    <% str8="selected"; %>
					
		   </c:if>
		   <option value="<%=MessageUtil.EMPLOYEE_SEX_MAN%>" <%=str7%>>男</option>
		   <option value="<%=MessageUtil.EMPLOYEE_SEX_WOMAN%>" <%=str8%>>女</option>
			</select>
			 <span id="employee_sexmsg" style="color: red"></span>
			</td>

		</tr>
		<tr>
			<td width="10" height="30" align="left">用&nbsp;&nbsp;户&nbsp;&nbsp;名:<input type="text"
				id="employee_loginname" name="employee_loginname" class="{required:true}"
				maxlength="16" onblur="checkemployee_loginname()" value="${e.employee_loginname }"/>
				<span id="employee_loginnamemsg" style="color: red"></span>
				</td>
			<td width="100" class="inputText">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="text"
				id="employee_password" name="employee_password" class="{required:true}"
				maxlength="16" onblur="checkemployee_password()" value="${e.employee_password }"/>
				<span id="employee_passwordmsg" style="color: red"></span>
			</td>

		</tr>
		<tr>
			<td width="10" height="30" align="left">所属区域: 
			<select
				id="employee_area" name="employee_area" class="{required:true}"
				style="color: red"  onchange="checkarea_id()">
					<c:forEach items="${requestScope.quyu}" var="q">
					<c:if test="${q.area_id==e.employee_area }">
					   <option value="${q.area_id}" selected>${q.area_name}</option>
					</c:if>
					<c:if test="${q.area_id!=e.employee_area }">
						 <option value="${q.area_id}">${q.area_name}</option>
				   </c:if>
					</c:forEach>
			</select>
			<span id="employee_areamsg" style="color: red"></span>
			</td>
			<td width="100" class="inputText">部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;门:
			<select id="employee_dept"
				name="employee_dept" class="{required:true}" style="color: red"   onblur="checkemployee_dept()">
				    <c:forEach items="${requestScope.department}" var="d">
				    <c:if test="${d.department_id ==e. employee_dept}">
					<option value="${e.employee_dept }" selected>${e.department_name }</option>
					</c:if>
					<c:if test="${d.department_id !=e. employee_dept}">
					<option value="${d.department_id }" >${d.department_name }</option>
					</c:if>
					</c:forEach>
			</select>
				<span id="employee_deptmsg" style="color: red"></span>
			</td>

		</tr>
		<tr>
			<td width="10" height="30" align="left">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称:<select
				id="position_id" name="position_id" class="{required:true}"
				style="color: red"   onblur="checkposition_id()">
				   <c:forEach items="${requestScope.position}" var="p">
				    <c:if test="${p.position_id ==e. position_id}">
					<option value="${e.position_id }" selected>${e.position_name }</option>
					</c:if>
					<c:if test="${p.position_id !=e. position_id}">
					<option value="${p.position_id }">${p.position_name }</option>
					</c:if>
					</c:forEach>
			</select>
			<span id="position_idmsg" style="color: red"></span>
			</td>
			<td width="100" class="inputText">技术方向:<select id="employee_tech"
				name="employee_tech" class="{required:true}" style="color: red"  onblur="checkemployee_tech()">
				   <c:forEach items="${requestScope.tech}" var="t">
				      <c:if test="${t.tech_id ==e.employee_tech }">
				      <option value="${ e.employee_tech}">${e.tech_tname }</option>
				      </c:if>
				      <c:if test="${t.tech_id !=e.employee_tech }">
					  <option value="${t.tech_id}">${t.tech_tname}</option>
					  </c:if>
					</c:forEach>
			</select>
				<span id="employee_techmsg" style="color: red"></span>
			</td>

		</tr>
		<tr>
			<td width="10" height="30" align="left">等&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级: <select
				id="employee_level" name="employee_level" class="{required:true}"
				style="color: red"  onblur="checkemployee_level()">
				<%  String str1=""; %>
				<%  String str2=""; %>
				<%  String str3=""; %>
				<c:if test="${e.employee_level== 0}">
				<% str1="selected"; %>
					
				</c:if>
				<c:if test="${e.employee_level== 1}">
				<% str2="selected"; %>
					
				</c:if>
				<c:if test="${e.employee_level== 2}">
				<% str3="selected"; %>
				</c:if>
				<option value="<%=MessageUtil.EMPLOYEE_LEVEL_CHUJI%>" <%=str1%>>初级</option>
				<option value="<%=MessageUtil.EMPLOYEE_LEVEL_ZHONGJI%>" <%=str2%>>中级</option>
		    	<option value="<%=MessageUtil.EMPLOYEE_LEVEL_GAOJI%>" <%=str3%>>高级</option>
			</select>
			<span id="employee_levelmsg" style="color: red"></span>
			</td>
			<td width="100" class="inputText">出&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;差:<select id="employee_business"
				name="employee_business" class="{required:true}" style="color: red" onblur="checkemployee_business()">
				<%  String str4=""; %>
				<%  String str5=""; %>
				<c:if test="${e.employee_business== 0}">
				    <% str4="selected"; %>
					
				</c:if>
				<c:if test="${e.employee_business== 1}">
				     <% str5="selected"; %>
					
				</c:if>
				<option value="<%=MessageUtil.EMPLOYEE_BUSINESS_BUJIESHOU%>" <%=str4%>>不接受</option>
				<option value="<%=MessageUtil.EMPLOYEE_BUSINESS_JIESHOU%>" <%=str5%>>接受</option>
			</select>
				<span id="employee_businessmsg" style="color: red"></span>
			</td>

		</tr>
	<tr>
			<td width="10" height="50" align="left">手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机:<input type="text"
				id="employee_tel" name="employee_tel" class="{required:true}"
				maxlength="11" onblur="checkemployee_tel()" value="${e.employee_tel }"/>
					<span id="employee_telmsg" style="color: red"></span>
				</td>
			<td width="100" height="50" class="inputText">微&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;信:<input type="text"
				id="employee_wechat" name="employee_wechat" class="{required:true}"
				maxlength="16" onblur="checkemployee_wechat()" value="${e.employee_wechat }"/>
				<span id="employee_wechatmsg" style="color: red"></span>
			</td>

		</tr>


		<tr>
			<td width="10" height="20" align="right"><br /> <br /> <img
				src="<%=basePath%>images/save_btn.png" width="60" height="20"
				onclick="validate()" /></td>
			<td valign="bottom"> <img
				src="<%=basePath%>images/cacel_btn.jpg" width="60" height="20"
				onclick="javascript:history.back()" /></td>

		</tr>
	</table>
	<input type="hidden" name="auid" id="auid">
</form>
</body>
</html>