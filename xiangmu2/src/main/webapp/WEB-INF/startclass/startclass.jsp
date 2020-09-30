<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.chinasofti.util.MessageUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5 Transitional//EN" "http://www.w3.org/TR/html5/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="<%=basePath%>css/right.css" rel="stylesheet" type="text/css" />
<script    type="text/javascript"    src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
<!-- ------------JQuery  JS----------------- -->
<script type="text/javascript"
	src="<%=basePath%>js/jquery-easyui-1.4.5/jquery.min.js" charset="utf-8"></script>
<!-- ------------表单验证JS----------------- -->

	<!--------------------------- 引入三级联动js文件  ------------------------------------>
	<script type="text/javascript"
	src="<%=basePath%>js/startclass.js" charset="utf-8"></script>
	<script type="text/javascript">
	var path="<%=basePath%>";
	</script>
	<script type="text/javascript">
	function validatesc() { 
		   var a=true;
		   if(!checktech_id()){
			   a=false;
		   };
		   if(!checkstartclass_region()){
			   a=false;
		   };
		   if(!checkstartclass_snature()){
			   a=false;
		   };
		   if(!checkclassroom_id()){
			   a=false;
		   };
		   if(!checkstartclass_teacher()){
			   a=false;
		   };
		   if(!checkstartclass_teahingassient()){
			   a=false;
		   };
		   if(!checkstartclass_classtutor()){
			   a=false;
		   };
		  
		   if(a==true){
           alert("提交");
			//form表单的id, 提交表单 
			$("#scform").submit();
	       // window.location.href=path+"quyuControl/addQuyu.action";
		   }
}
	
	</script>
</head>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="31" class="right_tittle">您的位置：<a
			href="<%=basePath%>startclassControl/startclass.action">开班管理</a>
			&gt;&gt;
		</td>
	</tr>
</table>

<form action="<%=basePath%>startclassControl/addclassroom?page=1"
	method="post" id="scform">

	<table width="100%" border="0" align="left" cellspacing="0"
		cellpadding="0" bordercolor="red">
		
			<tr>
			<td  width="120"    height="30"   rowspan="8"></td>
			</tr>
		<tr>
			<td width="10" height="30" align="left">技术方向: 
			<select
				id="tech_id" name="tech_id" class="{required:true}"
				style="color: red"  onchange="checktech_id()">
				<option value="">请选择</option>
					<c:forEach items="${requestScope.tech}" var="t">
						<option value="${t.tech_id}">${t.tech_tname}</option>
					</c:forEach>
			</select>
			<span id="tech_msg" style="color: red"></span>
			</td>
			<td width="100" class="inputText">选择区域:
			<select id="startclass_region"
				name="startclass_region" class="{required:true}" style="color: red"   onblur="checkstartclass_region()">
					<option value="">请选择</option>
				    <c:forEach items="${requestScope.quyuList}" var="qu">
					<option value="${qu.area_id}">${qu.area_name}</option>
					</c:forEach>
			</select>
				<span id="region_msg" style="color: red"></span>
			</td>

		</tr>
		<tr>
			<td width="10" height="30" align="left">班级性质:<select
				id="startclass_snature" name="startclass_snature" class="{required:true}"
				style="color: red"   onblur="checkstartclass_snature()">
					<option value="">请选择</option>
					<option value="就业">就业</option>
					<option value="实训">实训</option>
					<option value="校内实施">校内实施</option>
			</select>
			<span id="snature_msg" style="color: red"></span>
			</td>
			<td width="100" class="inputText">教&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;室:<select id="classroom_id"
				name="classroom_id" class="{required:true}" style="color: red"  onblur="checkclassroom_id()">
						<option value="">请选择</option>
			</select>
				<span id="class_msg" style="color: red"></span>
			</td>

		</tr>
	 
		<tr>
			<td width="10" height="30" align="left">开班日期:
			<input type="text" name="startclass_starttime" id="startclass_starttime" 
			onClick="WdatePicker({dateFmt:'yyyy-MM-dd '})" onblur="checkStartTime()"/>		
			    <span id="starttime_msg" style="color: red"></span>
			</td>
			
			<td width="100" class="inputText">结束日期:
		    <input type="text" name="startclass_endtime" id="startclass_endtime" 
		    onClick="WdatePicker({dateFmt:'yyyy-MM-dd '})" onblur="checkEndTime()"/>
				<span id="endtime_msg" style="color: red"></span>
			</td>

		</tr> 
		<tr>
			<td width="10" height="30" align="left">讲&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;师: 
			<select
				id="startclass_teacher" name="startclass_teacher" class="{required:true}"
				style="color: red"  onblur="checkstartclass_teacher()">
				<option value="">请选择</option>
			</select>
			<span id="teacher_msg" style="color: red"></span>
			</td>
			<td width="100" class="inputText">助&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;教:
			<select id="startclass_teahingassient"
				name="startclass_teahingassient" class="{required:true}" style="color: red"   onblur="checkstartclass_teahingassient()">
					<option value="">请选择</option>
			</select>
				<span id="teahingassient_msg" style="color: red"></span>
			</td>

		</tr>
	     <tr>
	        <td width="100" class="inputText">班主任:
			<select id="startclass_classtutor"
				name="startclass_classtutor" class="{required:true}" style="color: red"   onblur="checkstartclass_classtutor()">
					<option value="">请选择</option>
			</select>
				<span id="classtutor_msg" style="color: red"></span>
			</td>
			<td width="10" height="50" align="left">人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数:<input type="text"
				id="number" name="startclass_number" class="{required:true}"
				maxlength="16" onblur="checkemployee_tel()" />
					<span id="number_msg" style="color: red"></span>
				</td>
		</tr>
        <tr>
             <td width="100" height="50" class="inputText">学校信息:<textarea 
				id="school" name="startclass_school" class="{required:true}"
			    onblur="checkemployee_wechat()" rows="6"></textarea>
				<span id="school_msg" style="color: red"></span>
			</td>
        </tr>
		<tr>
			<td width="10" height="20" align="right"><br /> <br /> <img
				src="<%=basePath%>images/save_btn.png" width="60" height="20"
				onclick="validatesc()" /></td>
			<td valign="bottom"> <img
				src="<%=basePath%>images/cacel_btn.jpg" width="60" height="20"
				onclick="javascript:history.back()" /></td>

		</tr>
	</table>
	<input type="hidden" name="auid" id="auid">
</form>
</body>
</html>