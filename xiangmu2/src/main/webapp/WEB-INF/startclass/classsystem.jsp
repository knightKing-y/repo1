<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import=" com.chinasofti.util.MessageUtil"%>
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
<script type="text/javascript"
	src="<%=basePath%>js/jquery-easyui-1.4.5/jquery.min.js" charset="utf-8"></script>
<!---------------------------  复选框实现单选js文件  ------------------------------------>
<script type="text/javascript" src="<%=basePath%>js/form.js"
	charset="utf-8"></script>

<script type="text/javascript">
    var path ="<%=basePath%>";

	//进入修改页面
	function updatecoursesys() {

		var num = getCheckBoxValue('coursesys_csid');
		if (num == null || num == "") {
			alert("请选择要修改的课程体系");
			return false;
		} else {
			window.location.href = path
					+ "startclassControl/selectCoursesysByid.action?coursesys_csid="
					+ num;
		}
	}
	//进入批量导入页面
	function deletecoursesys() {
		var num = getCheckBoxValue('coursesys_csid');
		if (num == null || num == "") {
			alert("请选择要删除的课程体系");
			return false;
		}else {
		alert("你觉得你能杀死我");
		window.location.href = path
				+ "startclassControl/deleteCoursesysByid.action?coursesys_csid="
		        + num;
		}
	}
</script>
</head>
<body>

	<div class="title">
		<h2>课程体系管理</h2>
	</div>
	<div class="query">
		<div class="query-conditions ue-clear">
			<!-----------    按钮  start   ---------->
			<div style="position: absolute; right: 0; margin: -45px 30px 0 0">
				<a href="<%=basePath%>startclassControl/gotoAddCoursesys.action"
					id="add" class="abtn"> <img
					src="<%=basePath%>images/add_btn.png" name="Image1" border="0"
					id="Image1" />
				</a> <a href="#" id="update" class="abtn"> <img
					src="<%=basePath%>images/revise_btn.png" border="0" id="Image2"
					onclick="updatecoursesys()" />
				</a> <a href="#" id="update" class="abtn"> <img
					src="<%=basePath%>images/delico.png" border="0" id="Image2"
					onclick="deletecoursesys()" />
				</a>

			</div>



		</div>
		<!------------ 按钮  end ---------->
	</div>
	<div class="table-box">
		<table>
			<tr>
				<th class="num"></th>
				<th class="name">课程体系名称</th>
			</tr>
			<c:forEach items="${requestScope.list}" var="coursesys">
				<tr>
					<td class="num"><input type="checkbox" name="coursesys_csid"
						id="coursesys_csid" value="${coursesys.coursesys_csid}"
						onClick="javascript:chooseOne(this,'coursesys_csid');"></td>
					<td class="name"><a href="<%=basePath%>startclassControl/daochu?id=${coursesys.coursesys_csid}">${coursesys.coursesys_csname}</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>

</html>
