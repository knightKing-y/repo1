<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.chinasofti.util.MessageUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- ------------引入easyUI   css和js  包括easyui文件,JQ文件----------------- -->
<%@ include file="/common/common.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="<%=basePath%>css/right.css" rel="stylesheet" type="text/css" />

	<!--------- 引入三级联动及表单验证   js文件  -------------- -->
	<script type="text/javascript">
	function submitFrom(){
		
		$.ajax({ 
			url: path + "startclassControl/daoru.action",
		    type: "POST", 	
			cache:false,
			data:new FormData($('#form1')[0]),
			processData:false,
			contentType:false,
			dataType: "json",
			success: function(data){
				alert(data.msg);
			},
			error: function(jqXHR){     
			   alert("发生错误：" + jqXHR.status);  
			}    
		});
	 }  
	
	</script>
	
	<script type="text/javascript">
	    var path="<%=basePath%>";
	</script>
	
</head>


<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr  >
		<td height="31" class="right_tittle">您的位置：<a
			href="<%=basePath%>startclassControl/calsssys">课程体系管理</a>
			&gt;&gt;添加课程体系
		</td>
	</tr>
</table>

<form id="form1" action="<%=basePath%>startclassControl/daoru.action"  method="post" enctype="multipart/form-data">

	<table width="100%" border="0" align="left" cellspacing="0"
		cellpadding="0" bordercolor="red">
		
		
			<tr align="center">
			<td width="100" class="inputText">技术方向:<select id="employee_tech"
				name="tech_id" class="{required:true}" style="color: red"  >
				<option value="0">请选择</option>
					<c:forEach items="${requestScope.tech}" var="t">
						<option value="${t.tech_id}">${t.tech_tname}</option>
					</c:forEach>
			</select>
				<span id="employee_techmsg" style="color: red"></span>
			</td>

		</tr>
		<tr align="center">
		     <td width="100" class="inputText">课程体系名字:
		     <input type="text" name="coursesys_csname">
		     </td>
		</tr>
	
        <tr align="center">
			<td width="100" class="inputText"><br/>文件导入:
					<input type="file"
				id="upload" name="upload" class="{required:true}"
				maxlength="16"  />	
				<span id="exalmsg" style="color: red"></span>
				
			</td>

		</tr>
		<tr align="center">
			<td width="100" class="inputText"><br/><br/>
			(<a href="<%=basePath%>file/question.xls">模板下载</a>,请上传.xls文件)
				</td>
     </tr>
		<tr align="center">
			<td width="10" height="20" align="center"><br /> <br /> <img
				src="<%=basePath%>images/save_btn.png" width="60" height="20"
				onclick="submitFrom()" />
				 <img
				src="<%=basePath%>images/cacel_btn.jpg" width="60" height="20"
				onclick="javascript:history.back()" /></td>	</tr>
			<tr>
			<td valign="bottom"  align="center"></td>

		</tr>
	</table>
	<input type="hidden" name="auid" id="auid">
</form>
</body>
</html>