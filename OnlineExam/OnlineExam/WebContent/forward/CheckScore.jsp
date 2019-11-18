<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../resources/layui/css/layui.css" />
<script type="text/javascript" src="../resources/layui/layui.js"></script>
<script src="../js/jquery-1.11.1.min.js"></script>
<title>学生个人信息展示页面</title>
<script type="text/javascript">
	$(function(){
		$.ajax({
			type:"post",
			url:"http://localhost:8080/OnlineExam/Getsquad?method=checkscore",
			async:true
		});
	});
</script>
</head>
<style type="text/css">
	
	
	
	th{
		text-align:center;
		color:black;
	} 
</style>
<body>
	<table class="layui-table">
  
  <thead>
  <caption><h3>学生个人成绩表</h3></caption>
    <tr>
      <th>学号</th>
      <th>姓名</th>
      <th>成绩</th>
      <th>考试</th>
    </tr> 
  </thead>
  <tbody>
    <tr>
      	<td>${sessionScope.checkscore.sid}</td>
      	<td>${sessionScope.checkscore.sname}</td>
      	<td>${sessionScope.checkscore.grade}</td>
      	<td>${sessionScope.checkscore.cid.headline}</td>
     </tr>
		
  </tbody>

</table>
</body>
</html>