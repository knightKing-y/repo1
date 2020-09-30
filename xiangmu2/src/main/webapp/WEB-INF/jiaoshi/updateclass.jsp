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
	   	var area_name = $("#class_name").val();
	   	if(area_name == null || area_name ==""){
	   		 $("#namemsg").html("<font color='red'>教室名称不能为空</font>");
	   	     return false;
	   	}else{
	   		
	   		$("#namemsg").html("");
	   	    return true;
	   	}
 }
//区域编码验证
 function checkcode(){
	
	   	var area_code = $("#class_num").val();
	   	if(area_code == null || area_code ==""){
	  		  $("#codemsg").html("<font color='red'>教室容纳人数不能为空</font>");
	  		  return false;
	       }else{
	   		isnan();
	   		 return true;
		   } 
 }
 
     //验证数字
     function isnan(){
    	var area_code = $("#class_num").val();
	    for (var i = 0; i < area_code.length; i++) {
		var j = area_code.substring(i, i + 1)
		if (isNaN(j) == true) {
			$("#codemsg").html("只能填写数字");
			return false;
		}else{
			return true;
		}
	}
    }

   //验证重名
 	//    var bool=false;
 	//     if(classroom_name !=""){
 	//	         $.ajax({
 	//			  type : "POST",
 	//			  url : path+"classroomControl/selectRoomByname.action",
 	//			  data: {
 	//				  classroom_name: $('#classroom_name').val()
 	//				},
 	//			  dataType : "json",
 	//			  success : function(data) { 
 	//		    $("#namemsg").html(data.msg);
 	//	          if(data.bool=="1"){
 	//	             bool=true;          
 	//	          }
 	//	          },
 	//			  error : function(jqXHR) {
 	//				//alert("发生错误：" + jqXHR.status);
 				//  }
 			//      });
 		//	      return bool; 
 	//	        }
 	
    function validate(){
	var b=true;
	if(!checkname()){b= false};
	if(!checkcode()){b= false};
    if(!isnan()){b= false};
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
			href="<%=basePath%>jiaoshicontrol/showclass.action">区域管理</a>
			&gt;&gt;修改教室
		</td>
	</tr>
</table>

<form action="<%=basePath%>jiaoshicontrol/updateclass.action?class_id=${js.class_id}"  method="post"  id="form1">

	<table width="100%" border="0" align="left" cellspacing="0"
		cellpadding="0" bordercolor="red">
		<tr>
		  <td width="10" height="30" align="right">所在区域&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		  <td width="100" class="inputText">
		  <select
				id="area_name" name="area_id" class="{required:true}"
				style="color: red" >
				<c:forEach items="${requestScope.quyulist}" var="qu">
				    <c:if test="${qu.area_id ==js.area_id }">
				<option value="${js.area_id }">${js.area_name }</option>
				    </c:if>
				<option value="${qu.area_id }">${qu.area_name }</option>
				</c:forEach>
		  </select>
		  </td>
		</tr>
		<tr>
			<td width="10" height="30" align="right">教室名称:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td width="100" class="inputText"><input type="text"
				id="class_name" name="class_name" class="{required:true}"
				maxlength="16"  onblur="checkname()" value="${js.class_name }"/>
				<div id="namemsg" style="color: red"></div></td>

		</tr>
		<tr>
			<td width="10" height="30" align="right">教室可容纳人数:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td width="100" class="inputText"><input type="text"
				id="class_num" name="class_num" class="{required:true}"
				maxlength="16"  onblur="checkcode()" value="${js.class_num }"/>
				<div id="codemsg" style="color: red"></div></td>

		</tr>
        <tr>
            <% String str1="" ;%>
            <% String str2="" ;%>
            <c:if test="${js.status==0 }">
            <% str1="selected"; %>
            </c:if>
            <c:if test="${js.status==1 }">
            <% str2="selected"; %>
            </c:if>
            <td width="10" height="30" align="right">状态：
            <td width="100" class="inputText">
            <select
				id="area_name" name="status" class="{required:true}"
				style="color: red" >
		    <option value="0" <%=str1%>>有效</option>
			<option value="1" <%=str2%>>无效</option>
			</select>
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
</form>
</body>
</html>