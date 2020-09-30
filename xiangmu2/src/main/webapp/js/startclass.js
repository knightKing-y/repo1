function checktech_id(){
	var a=$('#tech_id').val();
	
	if(a == null || a== ''){
		$('#tech_msg').html("<font color='red'>请选择技术方向</font>");
		return false;
	}else{
		$('#tech_msg').html("");
		return true;
	}
}
//姓名验证
function checkstartclass_region() {
	var b=$('#startclass_region').val();
	if (b == null || b == "") {
		$("#region_msg").html("<font color='red'>请选择区域</font>");
		return false;
	} else {
		$("#region_msg").html("");
		return true;
	}
}
//性别验证
function checkstartclass_snature() {

	var c = $("#startclass_snature").val();
	if (c == null || c == "") {
		$("#snature_msg").html("<font color='red'>请选择班级性质</font>");
		return false;
	} else {
		$("#snature_msg").html("");
		return true;
	}
}


	// 用户名验证
	function checkclassroom_id() {

	var d = $("#classroom_id").val();
	if (d == null || d == "") {
		$("#class_msg").html("<font color='red'>请选择教室</font>");
		return false;
	} else {
		$("#class_msg").html("");
		return true;
	}
}

	
	
	// 密码验证
	function checkstartclass_teacher() {

	var employee_password = $("#startclass_teacher").val();
	if (employee_password == null || employee_password == "") {
		$("#teacher_msg").html("<font color='red'>请选择讲师</font>");
		return false;
	} else {
		$("#teacher_msg").html("");
		return true;
	}
}
	
	// 所属区域验证
	function checkstartclass_teahingassient() {

	var employee_area = $("#startclass_teahingassient").val();
	if (employee_area == null || employee_area == "" || employee_area == "0") {
		$("#teahingassient_msg").html("<font color='red'>请选择助教</font>");
		return false;
	} else {
		$("#teahingassient_msg").html("");
		return true;
	}
}
	
	
	// 部门验证
	function checkstartclass_classtutor() {

	var employee_dept = $("#startclass_classtutor").val();
	
	if (employee_dept == null || employee_dept == "" || employee_dept == "0") {
		$("#classtutor_msg").html("<font color='red'>请选择班主任</font>");
		return false;
	} else {
		$("#classtutor_msg").html("");
		return true;
	}
}
	
	// 手机验证
	function checkemployee_tel() {

	var employee_tel = $("#number").val();
	if (employee_tel == null || employee_tel == "") {
		$("#number_msg").html("<font color='red'>人数不能为空</font>");
		return false;
	}
	else {
	    for (var i = 0; i < employee_tel.length; i++) {
		var j = employee_tel.substring(i, i + 1)
		if (isNaN(j) == true) {
			$("#number_msg").html("只能填写数字");
			$("#number").val("");
			return false;
		}}
			var d = $("#classroom_id").val();
			if(d==null || d == ""){
				$("#number_msg").html("<font color='red'>请选择教室</font>");
				$("#number").val("");
				return false;
			}else{
				$("#number_msg").html("");
				$.post(path+"startclassControl/selectnum",{
					classroom_id:d,
					employee_num:employee_tel
				},callBacknumSuccess);
			}
        }
    }
	function callBacknumSuccess(json){
		json = eval("("+json+")");
		if(json!=null&&json!=""){
			if(json.state==1){
				$("#class_msg").html("<font color='green'>"+json.msg+"</font>");
				return true;
			}else{
				$("#class_msg").html("<font color='red'>"+json.msg+"</font>");
				return false;
			}
		}
	}
	
	function checkStartTime(){

		var startTime=$("#startclass_starttime").val();
		var start=new Date(startTime.replace("-", "/").replace("-", "/"));
		var today = new Date();
	    var timeStr = "-";
		var year = today.getFullYear();
	    var month = today.getMonth() + 1;
	    var day = today.getDate();
		var now = year + timeStr + month + timeStr + day;
		var end=new Date(now.replace("-", "/").replace("-", "/"));
		var time1 = new Date(start).getTime();
		var time2 = new Date(end).getTime();
		if(time1<time2){
			$('#starttime_msg').html("开始时间小于当前时间");
		    return false;
		}else{
			$('#starttime_msg').html("");
		    return true; 
		}
	
		
	}
	function checkEndTime(){
		var startTime=$("#startclass_starttime").val();
		var start=new Date(startTime.replace("-", "/").replace("-", "/"));
		var endTime=$("#startclass_endtime").val();
		var end=new Date(endTime.replace("-", "/").replace("-", "/"));
		if(end<start){
			$('#endtime_msg').html("结束时间小于开始时间");
		    return false;
		}else{
			$('#endtime_msg').html("");
		    return true; 
		}
	}

	$(function() {
		  
		$("#startclass_region").change(function() {
			
			
		    //	department();这里用$.post()也可以------>这是第二种方式
			
		   //$.ajax({ })   ------>    第一种方式
			var a=$('#tech_id').val();

	    		$.ajax({ 
	    		    type: "POST", 	
	    			url: path+"startclassControl/selectBYAREAID.action",
	    			data: {
	    				tech_id: $('#tech_id').val(),
	    				startclass_region: $('#startclass_region').val()
	    			},
	    			dataType: "json",
	    			success: function(data){  
	    			
	    				var cs2="";
	    				var cs3="";
	    				var cs5="";
	    				var cs6="";
	    				if (data  !=  null && data !=  "") { 
	    					
	    				for ( var i = 0; i < data.length; i++) {
	    					if(data[i].role_id==1){
	    						
	    					      cs2 += "<option value=" + data[i].employee_id+ ">" + data[i].employee_name+"("+data[i].employee_num+")"
    						      + "</option>";
	    					
	    					}
	    					
	    					
	    					if(data[i].role_id==2){
	    						
	    					    	 cs3 += "<option value=" + data[i].employee_id+ ">" + data[i].employee_name+"("+data[i].employee_num+")"
	 	    						+ "</option>";
	    					     
	    				     }
	    					if(data[i].role_id==3){
	    							cs5 += "<option value=" + data[i].employee_id+ ">" + data[i].employee_name+"("+data[i].employee_num+")"
	    							+ "</option>";
	    						cs6 += "<option value=" + data[i].classroom_id+ ">" + data[i].classroom_name+"("+data[i].startclass_number+")"
    							+ "</option>";
	    					}
    						}
	    				}
	    						
	    			    	
	    				//清空原有内容
						$("#classroom_id").html("");
						$("#startclass_classtutor").html("");
						$("#startclass_teahingassient").html("");
						$("#startclass_teacher").html("");
						//追加新的内容
						$("#classroom_id").append(cs6);
						$("#startclass_classtutor").append(cs3);
						$("#startclass_teahingassient").append(cs5);
						$("#startclass_teacher").append(cs2);
	    			},
	    			error: function(jqXHR){  
	    			   $("#region_msg").html("请重新选择区域");
	    			   alert("请选择技术方向");  
	    			   
	    			}    
	    		});
	    		
			

		});

	});
			
			