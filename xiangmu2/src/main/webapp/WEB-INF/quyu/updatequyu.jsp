<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script type="text/javascript"  src="<%=basePath%>js/jquery-easyui-1.4.5/jquery.min.js" charset="utf-8"></script>
<script type="text/javascript">
 var path="<%=basePath%>";
	//区域名称验证
 function checkname(){
	   	var area_name = $("#area_name").val();
	   	if(area_name == null || area_name ==""){
	   		 $("#namemsg").html("<font color='red'>区域名称不能为空</font>");
	   	  return false;
	   	}else{
	   		
	   		$("#namemsg").html("");
	   	  return true;
	   	}
 }
//区域编码验证
 function checkcode(){
	
	   	var area_code = $("#area_code").val();
	   	if(area_code == null || area_code ==""){
	  		  $("#codemsg").html("<font color='red'>区域编码不能为空</font>");
	  		  return false;
	    	}else{
	   		 $("#codemsg").html("");
	   		return true;
		   } 
 }
 
function validate(){
	var b=true;
	if(!checkname()){b= false};
	if(!checkcode()){b= false};
 
	 if(b == true){
		//form表单的id, 提交表单 
		$("#form1").submit();
		//如下写法不要用，这样虽然请求可以提交过去，但数据传不到后台。
		// window.location.href=path+"quyuControl/addQuyu.action";
	 }
}
</script>
</head>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="31" class="right_tittle">您的位置：<a
			href="<%=basePath%>quyuControl/gotoQuyuList.action">区域管理</a>
			&gt;&gt;修改区域
		</td>
	</tr>
</table>

<form action="<%=basePath%>quyuControl/updateQuyu.action"  method="post"  id="form1">

	<table width="100%" border="0" align="left" cellspacing="0"
		cellpadding="0" bordercolor="red">
		
		<tr>
			<td width="10" height="30" align="right">区域名称:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td width="100" class="inputText"><input type="text"
				id="area_name" name="area_name" class="{required:true}"
				maxlength="16"  onblur="checkname()" value="${requestScope.quyu. area_name}"/>
				<div id="namemsg" style="color: red"></div></td>

		</tr>
		<tr>
			<td width="10" height="30" align="right">区域编码:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td width="100" class="inputText"><input type="text"
				id="area_code" name="area_code" class="{required:true}"
				maxlength="16"  onblur="checkcode()"  value="${requestScope.quyu. area_code}"/>
				<div id="codemsg" style="color: red"></div>
		</td>
 	</tr>

		<tr>
			<td width="10" height="20">&nbsp;</td>
			<td valign="bottom">
			<img src="<%=basePath%>images/save_btn.png"
				width="60" height="20" onclick="validate()" /> 
				
			<img
				src="<%=basePath%>images/cacel_btn.jpg" width="60" height="20"
				onclick="javascript:history.back()" /></td>
             
		</tr>
	</table>
	  <input type="hidden"
				id="area_id" name="area_id"  value="${requestScope.quyu. area_id}"/>
</form>
</body>
</html>