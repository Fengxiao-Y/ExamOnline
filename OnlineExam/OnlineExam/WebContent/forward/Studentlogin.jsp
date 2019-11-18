<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<link rel="stylesheet" href="../css/backlogin.css" />
<script src="../js/jquery-1.11.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生考试系统登录</title>
</head>
<body>
		
			<div id="myform">
				<form id="studentlogin">
					<h1>学生考试系统登录</h1>
					<table>
						
						<tr>
							<td class="img"><img src=""/>&nbsp;</td>
							<td><input type="text" name="unumber" placeholder="请输入用户名" id="unumber"/></td>
						</tr>
						<tr>
							<td class="img"><img src=""/>&nbsp;</td>
							<td><input type="password" name="passwords" placeholder="请输入密码" id="passwords"/></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><input type="button" value="登录" id="special"/></td>
						</tr>
						<tr>
							<td></td>
							<td><a href="#" style="color:black">忘记密码？</a></td>
						</tr>
					</table>
				</form>
			</div>
		
		<p>Copyright&copy;&nbsp;yiduexam.com&nbsp;All Rrights reserved 长沙一度教育 版权所有 湘ICP备152268798号</p>
		<script type="text/javascript">
		$(function(){
		    var b=$("#unumber");
		    var c=$("#special");
		    
		    c.click(function(success){
		     var uPattern = /^[0-9]\d{0,8}$/;
		     b=b.val();
		     if(b==null||b==""){
		      alert("用户名不能为空")
		     }else{
		      var flag=uPattern.test(b);
		      if(flag){
		       var d=$("#passwords").val();
		       if(d==null||d==""){
		        alert("密码不能为空")
		       }else{
		        $.ajax({
		         type:"post",
		         url:"http://localhost:8080/OnlineExam/StudentServlet?method=login",
		         async:true,
		         data:$("#studentlogin").serialize(),
		         success:function(success){
		          if(success=="error"){
		           alert("密码错误");
		           
		           
		           window.location.reload();
		          }else if(success=="notfund"){
		           alert("用户未找到");
		           window.location.reload();
		          }else{
		           $(location).attr("href","Student.jsp ");
		          }
		         }
		        });
		       }
		      }else{
		        alert("用户名格式不正确!");
		       }
		     }   
		    });
		   });
		</script>
	</body>
</html>