<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  import=" com.chinasofti.util.MessageUtil,
	com.chinasofti.vo.kecheng.*,java.util.List,
	com.chinasofti.vo.employee.*,
	com.chinasofti.vo.startclass.*"%>
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
</head>
<body>

	<div class="title">
		<h2>教室管理</h2>
	</div>
	
	<div class="table-box">
		<table>

			<tr>
				<th class="num"></th>
				<th class="name">教室编号</th>
				<th class="process">教室人数</th>
				<th class="process">学习方向</th>
				<th class="name">讲师</th>
				<th class="name">助教</th>
				<th class="name">班主任</th>
				<th class="name">开始时间</th>
				<th class="name">结束时间</th>
				<th class="name">班级性质</th>
				<th class="name">班级状态</th>
				<th class="name">课程表</th>
			</tr>
		    	
		    	<%List<StartClass> sclist=(List)request.getAttribute("sclist"); 
		    	  List<Tech> tlist=(List)request.getAttribute("tlist");
		    	  List<Employee> emlist=(List)request.getAttribute("emlist");
		    	  String tech_name="";
		    	  String Startclass_teacher_name="";
			      String Startclass_teahingassient_name="";
			      String Startclass_classtutor_name="";
		    	  for(StartClass sc:sclist){%>
					   
				<tr>
					<td class="num"><input type="checkbox" name="class_id"
						id="class_id" value="<%=sc.getStartclass_sid() %>" onClick="javascript:chooseOne(this,'class_id');" ></td>
					<td class="name" name="area_name"><%=sc.getClassroom_id()%></td>
					<td class="name" name="class_name"><%=sc.getStartclass_number() %></td>
					<% for(Tech t:tlist){
						   if(t.getTech_id()==sc.getTech_id()){
							   tech_name=t.getTech_tname();
						   }%>
					 <td class="process" name="class_num">
					   
					  <%= tech_name %>
					 <% }%>
					</td>
					
					<% for(Employee em:emlist){
					      if (em.getEmployee_id() ==sc.getStartclass_teacher() ){
					    	   Startclass_teacher_name=em.getEmployee_loginname(); 
					    	  }%>
					       
			            <% if (em.getEmployee_id() ==sc.getStartclass_teahingassient() ){
					    	   Startclass_teahingassient_name=em.getEmployee_loginname();   
					    	  }%>
					    	 
					    <% if (em.getEmployee_id() ==sc.getStartclass_classtutor() ){
					    	   Startclass_classtutor_name=em.getEmployee_loginname(); 
					    	  }%>
                             
                   <%} %>
                   <td class="process" name="status">  
						      <%=Startclass_teacher_name %>
		           </td>
		           <td class="process" name="status">
					           <%=Startclass_teahingassient_name %>
                   </td>
                   <td class="process" name="status">
					           <%=Startclass_classtutor_name %>
                   </td>
                   
                   <td class="name" name="class_name"><fmt:formatDate type="date" value="<%=sc.getStartclass_starttime() %>" /></td>
                   <td class="name" name="class_name"><fmt:formatDate type="date" value="<%=sc.getStartclass_endtime() %>" /></td>
                   <td class="name" name="class_name"><%=sc.getStartclass_snature()%></td>
                   <td class="name" name="class_name">开班</td>
                   <th class="name"><a href="<%=basePath%>startclassControl/kechengbiao?tech_id=<%=sc.getTech_id() %>&startclass_sid=<%=sc.getStartclass_sid() %>">课程表</a></th>
				</tr>
    <%} %>
         <tr>
         <th class="name"> 总页数：${yeshu }</th>
         <th class="name"> 当前页：${currentpage}</th>     
         <th class="name"><a href="<%=basePath%>startclassControl/showclass?page=1">首页</a> </th>  
         <th class="name"><a href="<%=basePath%>startclassControl/showclass?page=${currentpage-1}">上一页</a></th>  
         <th class="name"><a href="<%=basePath%>startclassControl/showclass?page=${currentpage+1}">下一页</a></th>  
         <th class="name"><a href="<%=basePath%>startclassControl/showclass?page=${yeshu }">末页</a></th>  
         </tr>
		</table>
	</div>

</body>

</html>