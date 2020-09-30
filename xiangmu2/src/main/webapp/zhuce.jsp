<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>排课系统</title>
<!-- common.jsp引用css和js -->
<%@ include file="/common/common.jsp"%>

<script type="text/javascript">
   var prjContextPath='<%=request.getContextPath()%>';
   var b=false;
  function  validateForm(){
	
		//用户名验证
	   	var username = $("#username").val();
	   	if(username == null || username ==""){
	   		 $("#usernamemsg").html("<font color='red'>用户名不能为空</font>");
	   		 return false;
	   	}else{
	   		//去掉，因为一直想保留ajax验证用户名是否重复的提示信息
	   		//$("#usernamemsg").html("");
	   	}
	   	
	   	//密码验证
	   	var pwd = $("#pwd").val();
	   	if(pwd == null || pwd ==""){
	  		  $("#pwdmsg").html("<font color='red'>密码不能为空</font>");
	  		  return false;
	    	}else{
	   		 $("#pwdmsg").html("");
		   } 
	   	
	 
		 if(b == true){
			//form表单的id, 提交表单 
			 $("#form1").submit();
			 
		 }
  }   
  
   
  //用户名重复验证 
 function valiUsername(){
	  //把之前的提示信息清除掉
	 $("#usernamemsg").html("");
	var username = $("#username").val();
	

	 if (username != "") {	
		$.ajax({ 
		    type: "POST", 	
			url: prjContextPath + "/userControl/validateUser.action",
			data: {
				username: $("#username").val()
			},
			dataType: "json",
			success: function(data){
			
				if (data.success == 1) { //用户名不存在
					 b = true;
				
					 $("#usernamemsg").html("<font color='green'>" + data.msg + "</font>");
					
				} else {//data.success =0 用户名存在
					
					 b = false;
					 $("#usernamemsg").html("<font color='red'>" + data.msg + "</font>");
				    
				} 
			},
			error: function(jqXHR){     
			   alert("发生错误：" + jqXHR.status);  
			}    
		});
		
	  }

 }
 
 

 
  

</script>

 
</head>
<body>
	注册：<br/><br/>
	
	<form action="<%=basePath%>userControl/zhuce.action"  id="form1" method="post">
	                  用户名：<input type="text" name="username"  id="username" onblur="valiUsername()">
	                  <span id="usernamemsg"></span><span id="msg"></span><br/>
	                  密码：<input type="password" name="pwd" id="pwd"> <span id="pwdmsg"></span><br/>
	                
           <input type="button"  value="提交" onclick="validateForm()">
	</form>
	
</body>
</html>