<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  import=" com.chinasofti.util.MessageUtil"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
</script>
<script type="text/javascript">
    function submitFrom1(){
    	var num = getCheckBoxValues('classcourse_id');
    	var a=$("#startclass_sid").val();
    	if(num == null || num == ""){
	    	  return false;
	      }else{

	      window.location.href = path+ "startclassControl/xuanke.action?classcourse_id="+num+"&startclass_sid="+a;
	      }

    }
</script>
</head>
<body>

	<div class="title">
		<h2>业务信息</h2>
	</div>
	
	<div class="query">
		<div class="query-conditions ue-clear">
			<!-----------    按钮  start   ---------->
			<div style="position: absolute; right: 0; margin: -45px 30px 0 0">
				
				<c:if test="${state==0 }">   
				<img
				src="<%=basePath%>images/save_btn.png" width="60" height="20"
				onclick="submitFrom1()" />
				</c:if>
				
	      	</div>
		</div>
	</div>
	<form action="<%=basePath%>startclassControl/xuanke?startclass_sid=${startclass_sid }" id="ccform" method="post">
	<div class="table-box">
		<table>
			<tr>
			    <th class="num"></th>
				<th class="name">课程名称</th>
				<th class="name">周开始时间</th>
				<th class="name">周结束时间</th>
				
			</tr>
				<c:forEach items="${requestScope.list }" var="l">	   
				<tr>
				   <td class="num"><input type="checkbox" name="classcourse_id"
						id="classcourse_id" value="${l.classcourse_id}" onClick="javascript:getCheckBoxValues('classcourse_id');" ></td>
				   <td class="name" name="class_name">${l.classcourse_name }</td>    
                   <td class="name" name="class_name"><fmt:formatDate type="date" value="${l.classcourse_starttime }" /></td>
                   <td class="name" name="class_name"><fmt:formatDate type="date" value="${l.classcourse_endtime }" /></td>
				   <th ><input type="hidden"  name="auid"  id="startclass_sid"  value="${startclass_sid }">  </th>
				   
				</tr>
				</c:forEach>
		</table>
	</div>
   </form>
</body>

</html>