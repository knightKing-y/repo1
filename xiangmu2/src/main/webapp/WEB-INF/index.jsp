<%@ page language="java" contentType="text/html; charset=UTF-8"  import="java.util.*,com.chinasofti.vo.xitong.Authority"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>排课系统</title>
<!-- common.jsp引用css和js -->
<%@ include file="/common/common.jsp"%>

<script type="text/javascript">
	function addtab(names,url) {

		if ($("#tt2").tabs('exists', 'names')) { //判断选项卡 是否重复 有则返回false
			alert("不可重复打开选项卡");

		} else {
			// 添加一个未选中状态的选项卡面板----在方法表中的add里有如下写好的方法
			$('#tt2').tabs('add',
							{
								title : names,
								selected : true,//false 没有直接打开  ture是直接打开了
								closable : true, //让标签后面带X号,可以关闭
								//不能用href，因为href只加载body中的内容
								//content:'text.html' 这样写只把text.html这句话加载到页面上了
								//这里用user.html 这里加查询,这里height设置成98%就行，要不出滚动条
								content : "<iframe frameborder='0' width='100%' height='98%' marginheight='3' marginwidth='2' scrolling='auto' src='${pageContext.request.contextPath}/"+url+"'></iframe>"

							});

		}
	}
</script>
  
</head>
<!--手册 Layout（布局）里-->
<body class="easyui-layout" >
  
	<div
		data-options="region:'north',href:'${pageContext.request.contextPath}/layout/north.jsp',title:'欢迎使用教务排课系统',split:true"
		style="height: 100px;"></div>
	
	<div
		data-options="region:'west',href:'${pageContext.request.contextPath}/layout/west.jsp',title:'主菜单',split:true"
		style="width: 200px;"></div>
	<div data-options="region:'center',title:'业务信息'"
		style="padding: 5px; background: #eee;">
		
            <div id="tt2" class="easyui-tabs" data-options="fit:true">
			
	       </div>
	       
	</div>
</body>
</html>