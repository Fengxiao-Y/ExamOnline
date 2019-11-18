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
</head>
<style type="text/css">
	
	/* table{
		text-align:center;
	
	} */
	
	th{
		color:black;
		text-align:center;
	} 
</style>
<body>
	<table class="layui-table">
  
  <thead>
  <caption><h3>学生个人信息表</h3></caption>
    <tr>
      <th>编号</th>
      <th>姓名</th>
      <th>性别</th>
      <th>年龄</th>
      <th>班级</th>
      <th>密码</th>
      <th>入学日期</th>
      <th>身份证</th>
      <th>电话</th>
      <th>监护人</th>
      <th>与监护人关系</th>
      <th>监护人电话</th>
      <th>地址</th>
      <th>目前状态</th>
    </tr> 
  </thead>
  <tbody>
    <tr>
      	<td>${sessionScope.stu.sid}</td>
      	<td>${sessionScope.stu.sname}</td>
      	<td>${sessionScope.stu.sex}</td>
      	<td>${sessionScope.stu.age}</td>
      	<td>${sessionScope.stu.sqid.snumber}</td>
      	<td>${sessionScope.stu.passwords}</td>
      	<td>${sessionScope.stu.register}</td>
      	<td>${sessionScope.stu.identitycard}</td>
      	<td>${sessionScope.stu.phone}</td>
      	<td>${sessionScope.stu.guardian}</td>
      	<td>${sessionScope.stu.guardianwith}</td>
      	<td>${sessionScope.stu.guardianphone}</td>
      	<td>${sessionScope.stu.address}</td>
      	<td>${sessionScope.stu.situation}</td>
      	
    </tr>
		
      
  </tbody>
</table>
</body>
</html>