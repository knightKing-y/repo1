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


 <!-- -------------------------------------生成统计图 -------------------->
 <script type="text/javascript"
	src="<%=basePath%>js/charts/fusioncharts.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="<%=basePath%>js/charts/fusioncharts.charts.js"
	charset="utf-8"></script>
	
	
	<!---------------------------  html打印js文件  ------------------------------------>
<script type="text/javascript"  src="<%=basePath%>js/browser.js" charset="utf-8"></script>
<script type="text/javascript"  src="<%=basePath%>js/jquery.jqprint-0.3.js" charset="utf-8"></script>
	
	
	

<script type="text/javascript">
    
  //================统计图===========================
	  $(function(){
			 
		  show();
		  
	  });
	  function show(){
		 
		 $.ajax({
				url : "<%=basePath%>/roleControl/getdata.action",
				
				success : function(data) {
					
					//$.messager.progress('close');
					FusionCharts.ready(function() {
						var revenueChart = new FusionCharts({
							"type" : "bar3d",
							"renderAt" : "bb",//id的值
							"width" : "80%",
							"height" : "400",
							"dataFormat" : "json",
							"dataSource": {
						        "chart": {
						            "caption": "xxxx年国足",
						            "subCaption": "平均进球数",
						            "xAxisName": "月份",
						            "yAxisName": "数量",
						            "theme": "fint"
						         },
						        "data": data
						      }
						});
						revenueChart.render();
					})
				}
			});
	 }
   
	//================html打印===========================
		function   print(){
			
			$("#bb").jqprint();
			
		}
		
</script>
</head>
<body>

	<div class="title">
		<h2>统计图</h2>
	</div>
	
	<div class="query">
		<div class="query-conditions ue-clear">
			<!-----------    按钮  start   ---------->
			<div style="position: absolute; right: 0; margin: -45px 30px 0 0">

			   	<a href="#" class="abtn"> <img
					src="<%=basePath%>images/dayin.bmp" border="0" id="Image2" width="30" height="20" onclick="print()"/>
				</a>
			</div>
			<!------------ 按钮  end ---------->
		</div>
	</div>
	
	<div id="bb"></div>

</body>

</html>