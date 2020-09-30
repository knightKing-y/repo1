<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>My JSP 'quanxian.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- common.jsp引用css和js -->
	<%@ include file="/common/common.jsp" %> 
	<script type="text/javascript">
			$(function() {
				$('#dg').datagrid({
					url: 'dbbb.json',
					columns: [
						[ {
							field: 'ck',
							checkbox:true,
							width: 200,
                            align: 'center'
						},{
							field: 'num',
							title: '名称',
							width: 200,
							align: 'center'
						}, {
							field: 'name',
							title: '帐号',
							width: 200,
                            align: 'center'
						}, {
							field: 'sex',
							title: '角色',
							width: 200,
                            align: 'center'
						}, {
							field: 'age',
							title: '状态',
							width: 200,
							align: 'center'
						}]
					],
					toolbar: [{
						text: '添加',
						iconCls: 'icon-add',
						handler: function() {
							add();
						}
					}, '-', { //'-'相当于页面竖线分隔小图标
						text: '修改',
						iconCls: 'icon-edit',
						handler: function() {
							alert('修改')
						}
					}, '-', {
						text: '删除',
						iconCls: 'icon-no',
						handler: function() {
							alert('删除')
						}
					}]
				});

			});

			function add() {
				parent.$('<div/>').dialog({
					title: '添加用户',
					width: 450,
					height: 200,
					closed: false, //是否能弹出  为true不能弹出
					cache: false,
					href: 'useradd.html',
					modal: true,
					
					buttons: [{
						text: '保存',
						handler: function() {

						}
					}, {
						text: '关闭',
						handler: function() {

						}
					}]
				});
			};
		</script>
  </head>
  
  <body class="easyui-layout">
		<div data-options="region:'north',border:false,title:'过滤条件'" style="height:70px;">
			<form id="queryForm">
				<table class="tableForm datagrid-toolbar" style="width: 100%; height: 100%;">
					<tr>
						<td>用户帐号：
						<input id="cid" name="cid" class="easyui-textbox" style="width: 155px;" />
						<a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="query();">查询</a>
							<a class="easyui-linkbutton" onclick="queryClear();">清空</a>
						</td>
					</tr>
					
				</table>
			</form>
		</div>
		<div data-options="region:'center',border:false" style="overflow: hidden;">
			<table id="dg"></table>
		</div>
	</body>
</html>
