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
	function updateRole() {
		
      var num = getCheckBoxValue('class_id');
      if(num == null || num == ""){
    	  alert("请选择要修改的角色");
    	  return false;
      }else{
      window.location.href = path+ "jiaoshicontrol/updateclassjsp.action?class_id="+num;
      }
    }
	
	
	//模糊查询
	function mh(){
		var a= $("#area_id").val();
		window.location.href = path+ "jiaoshicontrol/mhselectclass.action?area_id="+a;
	}
	
	//删除
	function deleteclass(){
		var a = $("#class_id").val();
		if(a == null || a == ""){
	    	  alert("请选择要删除的角色");
	    	  return false;
	      }else{
	      window.location.href = path+ "jiaoshicontrol/deleteclass.action?class_id="+a;
	      }
	}
	
	//按条件查询
	function  submitPostion() {
		
		var role_id = $("#class_id").val();
		//var department_id = $("#area_name").val();
	    
		//如果页面上area_id和department_id是“”时，就提交不到后台的方法报400错
		//表单的action提交
		$("#form1").submit();
	}
	
    


</script>
</head>
<body>

	<div class="title">
		<h2>教室管理</h2>
	</div>
	<div class="query">
		<div class="query-conditions ue-clear">
			<!-----------    按钮  start   ---------->
			<div style="position: absolute; right: 0; margin: -45px 30px 0 0">

				<a href="<%=basePath%>jiaoshicontrol/gotoaddclassjsp" id="add"
					class="abtn"> <img src="<%=basePath%>images/add_btn.png"
					name="Image1" border="0" id="Image1" />
				</a> 
				<a href="#" id="update" class="abtn"> <img
					src="<%=basePath%>images/revise_btn.png" border="0" id="Image2"  onclick="updateRole()"/>
				</a>
			    <a href="#" id="delete" class="abtn"> <img
					src="<%=basePath%>images/close1.png" border="0" id="Image2"  onclick="deleteclass()"/>
				</a>
			</div>
			<!------------ 按钮  end ---------->
		</div>
	</div>
	<div class="table-box">
		<table>
		   <tr>
		       <td width="10" height="30" align="right">所在区域&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		       <td width="100" class="inputText">
		       <select
				id="area_id" name="area_id" class="{required:true}"
				style="color: red" >
				<c:forEach items="${requestScope.quyulist}" var="qu">
				    <c:if test="${qu.area_id }==${a }">
				<option value="${qu.area_id }">${qu.area_name }</option>
				    </c:if>
		          <option value="${qu.area_id }">${qu.area_name }</option>
		        </c:forEach>
		       </select>
		      </td>
		      <td>
		        <input type="button" value="查询" onClick="mh()">
		     </td>
		    </tr>
		    
			<tr>
				<th class="num"></th>
				<th class="name">所属区域</th>
				<th class="process">教室名称</th>
				<th class="process">教室可容纳人数</th>
				<th class="name">教室状态</th>
			</tr>
		    	<c:forEach items="${requestScope.list}" var="l">
				<tr>
					<td class="num"><input type="checkbox" name="class_id"
						id="class_id" value="${l.class_id}" onClick="javascript:chooseOne(this,'class_id');" ></td>
					<td class="name" name="area_name">${l.area_name}</td>
					<td class="name" name="class_name">${l.class_name}</td>
					<td class="process" name="class_num">${l.class_num}</td>
					<td class="process" name="status">
					<c:if test="${l.status == 0}"  >
					 有效
					</c:if>
					<c:if test="${l.status == 1}">
					 无效
					</c:if>
                   </td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>

</html>