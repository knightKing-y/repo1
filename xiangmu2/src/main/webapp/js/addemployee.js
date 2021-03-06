//==========三级联动================================
$(function() {
  
	$("#employee_area").change(function() {
		     //根据区找到部门
		    area_depat();
    	});
	
	$("#employee_dept").change(function() {
		       //根据部门找到职称
			  depat_position();
	   });
  });

function area_depat(){
	
	$.ajax({ 
	    type: "POST", 	
		url: path+"positionControl/selectDepartmentByAreaid.action",
		data: {
			area_id: $('#employee_area').val()
		},
		dataType: "json",
		success: function(data){  
		
			var cs ="<option value=\"\">请选择</option>";
			if (data  !=  null && data !=  "") { 
				
				for ( var i = 0; i < data.length; i++) {
					
					cs += "<option value=" + data[i].department_id+ ">" + data[i].department_name
							+ "</option>";

				}	
				}
			//清空原有内容
			$("#employee_dept").html("");
			//追加新的内容
			$("#employee_dept").append(cs);
		},
		error: function(jqXHR){     
		   alert("发生错误：" + jqXHR.status);  
		}    
	});
}

function depat_position(){

	$.ajax({ 
	    type: "POST", 	
		url: path+"DaoRuControl/selectDepatByposition.action",
		data: {
			department_id: $('#employee_dept').val()
		},
		dataType: "json",
		success: function(data){  
	
			var cs ="<option value=\"\">请选择</option>";
			if (data  !=  null && data !=  "") { 
				
				for ( var i = 0; i < data.length; i++) {
				
					cs += "<option value=" + data[i].position_id+ ">" + data[i].position_name
							+ "</option>";

				}	
				}
			//清空原有内容
			$("#position_id").html("");
			//追加新的内容
			$("#position_id").append(cs);
		},
		error: function(jqXHR){     
		   alert("发生错误：" + jqXHR.status);  
		}    
	});
}



//
//$(function() {
//  
//	$("#employee_area").change(function() {
//		
//	    //	department();这里用$.post()也可以------>这是第二种方式
//		
//	   //$.ajax({ })   ------>    第一种方式
//	
//    		$.ajax({ 
//    		    type: "POST", 	
//    			url: path+"positionControl/selectDepartmentByAreaid.action",
//    			data: {
//    				area_id: $('#employee_area').val()
//    			},
//    			dataType: "json",
//    			success: function(data){  
//    			
//    				var cs ="";
//    				if (data  !=  null && data !=  "") { 
//    					
//    					for ( var i = 0; i < data.length; i++) {
//    						
//    						cs += "<option value=" + data[i].department_id+ ">" + data[i].department_name
//    								+ "</option>";
//
//    					}	
//    					}
//    				//清空原有内容
//					$("#employee_dept").html("");
//					//追加新的内容
//					$("#employee_dept").append(cs);
//    			},
//    			error: function(jqXHR){     
//    			   alert("发生错误：" + jqXHR.status);  
//    			}    
//    		});
//    		
//    	  
//
//	});
//
//});

//========== 表单验证============================================================


//姓名验证
function checkemployee_name() {
	var employee_name = $("#employee_name").val();
	if (employee_name == null || employee_name == "") {
		$("#employee_namemsg").html("<font color='red'>姓名不能为空</font>");
		return false;
	} else {
		$("#employee_namemsg").html("");
         return true
	}
}


//性别验证
function checkemployee_sex() {

	var employee_sex = $("#employee_sex").val();
	if (employee_sex == null || employee_sex == "") {
		$("#employee_sexmsg").html("<font color='red'>性别不能为空</font>");
		return false;
	} else {
		$("#employee_sexmsg").html("");
		return true;
	}
}


	// 用户名验证
	function checkemployee_loginname() {

	var employee_loginname = $("#employee_loginname").val();
	if (employee_loginname == null || employee_loginname == "") {
		$("#employee_loginnamemsg").html("<font color='red'>用户名不能为空</font>");
		return false;
	} else {
		 $.post(path+"userControl/validateUser",{
	        	username:employee_loginname
	        },callbacknamesuccess);
	}
}

	function callbacknamesuccess(html){
		html = eval("("+html+")");
		if (html != null && html != "") {
			if(html.success==1){
				$("#employee_loginnamemsg").html("<font color='green'>"+html.msg+"</font>");
				
			}else{
				$("#employee_loginnamemsg").html("<font color='red'>"+html.msg+"</font>");
				
			}
		}
	}
	
	// 密码验证
	function checkemployee_password() {

	var employee_password = $("#employee_password").val();
	if (employee_password == null || employee_password == "") {
		$("#employee_passwordmsg").html("<font color='red'>密码不能为空</font>");
		return false;
	} else {
		$("#employee_passwordmsg").html("");
		return true;
	}
}
	
	// 所属区域验证
	function checkarea_id() {

	var employee_area = $("#employee_area").val();
	if (employee_area == null || employee_area == "" || employee_area == "0") {
		$("#employee_areamsg").html("<font color='red'>所属区域不能为空</font>");
		return false;
	} else {
		$("#employee_areamsg").html("");
		return true;
	}
}
	
	
	// 部门验证
	function checkemployee_dept() {

	var employee_dept = $("#employee_dept").val();
	
	if (employee_dept == null || employee_dept == "" || employee_dept == "0") {
		$("#employee_deptmsg").html("<font color='red'>部门不能为空</font>");
		return false;
	} else {
		$("#employee_deptmsg").html("");
		return true;
	}
}
	// 职称验证
	function checkposition_id() {

	var position_id = $("#position_id").val();
	if (position_id == null || position_id == ""  || position_id == "0") {
		$("#position_idmsg").html("<font color='red'>职称不能为空</font>");
		return false;
	} else {
		$("#position_idmsg").html("");
		return true;
	}
}
	
	// 技术方向验证
	function checkemployee_tech() {

	var employee_tech = $("#employee_tech").val();
	if (employee_tech == null || employee_tech == "" || employee_tech == "0") {
		$("#employee_techmsg").html("<font color='red'>职称不能为空</font>");
		return false;
	} else {
		$("#employee_techmsg").html("");
		return true;
	}
}
	
	
	// 等级验证
	function checkemployee_level() {

	var employee_level = $("#employee_level").val();
	if (employee_level == null || employee_level == ""  ) {
		$("#employee_levelmsg").html("<font color='red'>等级不能为空</font>");
		return false;
	} else {
		$("#employee_levelmsg").html("");
		return true;
	}
}
	
	// 出差验证
	function checkemployee_business() {

	var employee_business = $("#employee_business").val();
	if (employee_business == null || employee_business == "" ) {
		$("#employee_businessmsg").html("<font color='red'>出差不能为空</font>");
		return false;
	} else {
		$("#employee_businessmsg").html("");
		return true;
	}
}
	
	
	
	// 手机验证
	function checkemployee_tel() {

	var employee_tel = $("#employee_tel").val();
	if (employee_tel == null || employee_tel == "") {
		$("#employee_telmsg").html("<font color='red'>手机不能为空</font>");
		return false;
	}
	else {
		
	    for (var i = 0; i < employee_tel.length; i++) {
		var j = employee_tel.substring(i, i + 1)
		if (isNaN(j) == true) {
			$("#employee_telmsg").html("只能填写数字");
			return false;
		}else{
			
			var j=0;
			for(var i=0;i<employee_tel.length;i++){
				j+=1;
			}
			if (j<10){
				$("#employee_telmsg").html("电话号码短");
				return false;
			}else{
				if(!(/^1(3|4|5|6|7|8|9)\d{9}$/.test(employee_tel))){
					$("#employee_telmsg").html("<font color='red'>手机号格式有误，请重新输入</font>");
					return false;
				} else{
					$("#employee_telmsg").html("");
					return true;
				
				}
			}
			
		}
		
	}
}
}
	
	// 微信验证
	function checkemployee_wechat() {

	var employee_wechat = $("#employee_wechat").val();
	if (employee_wechat == null || employee_wechat == "") {
		$("#employee_wechatmsg").html("<font color='red'>微信不能为空</font>");
		return false;
	}
	else {
		$("#employee_wechatmsg").html("");
		return true;
	}
}
	
	
	

//提交验证
function validate() {

	var b = true;

	if (!checkemployee_sex() ) { //性别验证
		b = false;	
	}
	if (! checkemployee_name() ) {//姓名验证
	
		b = false;	
	}	
	
	
	if (!checkemployee_password() ) { // 密码验证
		b = false;	
	}
	if (!checkemployee_tel() ) { //手机验证
		b = false;
	}
	if (!checkemployee_wechat() ) { //微信验证
		b = false;	
	}
	if (!checkarea_id() ) { //所属区域验证
		b = false;	
	}
	if (!checkemployee_dept() ) { //部门验证
		b = false;	
	}
	if (!checkposition_id() ) { //职称验证
		b = false;	
	}
	if (!checkemployee_tech() ) { //技术方向验证
		b = false;	
	}
	if (!checkemployee_level() ) { //等级验证
		b = false;	
	}
	if (!checkemployee_business() ) { //出差验证
		b = false;	
	}
	

	if (b == true) {
    alert("提交");
		//form表单的id, 提交表单 
		$("#form1").submit();
		//如下写法不要用，这样虽然请求可以提交过去，但数据传不到后台。
		// window.location.href=path+"quyuControl/addQuyu.action";
	}
}
