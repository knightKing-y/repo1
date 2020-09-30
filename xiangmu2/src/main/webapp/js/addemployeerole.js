
function validate(){
	alert("start..");
	var employee_name = $("#employee_name").val();
	if (employee_name == null || employee_name == "") {
		$("#employee_namemsg").html("<font color='red'>用户名不能为空</font>");
		return false;
	} else {
		$("#employee_namemsg").html("");
		return true;
	}
	
	var employee_loginname = $("#employee_loginname").val();
	if (employee_loginname == null || employee_loginname == "") {
		$("#employee_loginnamemsg").html("<font color='red'>用户名不能为空</font>");
		return false;
	} else {
		$("#employee_loginnamemsg").html("");
		return true;
	}
	alert("end..");
	$("#form1").submit();
	
	
	
	
}