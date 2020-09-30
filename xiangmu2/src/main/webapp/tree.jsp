<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- common.jsp引用css和js -->
<%@ include file="/common/common.jsp"%>

<script type="text/javascript">
var prjContextPath='<%=request.getContextPath()%>';
$(function(){
	$('#cc').combotree({    
	    url: '<%=basePath%>/treeControl/getTreeData.action',    
	    required: true,
	    multiple: true
	});  
	
});
	function getValue() {
		var value = $('#cc').combotree('getValues');
		alert(value);
	}
</script>
</head>
<body>

<%--
[{"id":"01","text":"一班","children":[{"id":"001","text":"张一","children":null},{"id":"002","text":"张二","children":null}]},{"id":"02","text":"二班","children":[{"id":"003","text":"张三","children":null}]},{"id":"03","text":"三班","children":null}]

--%>
	
	<select id="cc"  style="width:200px;" ></select>  
<a href="#" id="btn" class="easyui-linkbutton" onclick="getValue()">getValue</a>  
	

</body>
</html>