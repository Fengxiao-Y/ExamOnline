<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="../js/jquery-1.11.1.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
 body{
	background-color:skyblue; 

 }
#container{
	position:absolute;
	left:40%;
	top:20%;
	width:300px;
	height:320px;
	border:1px solid gray;

}

h3{
color:red;
}

input{
height:35px;
width:200px;
margin-top:15px;
margin-left:15px;
}

#special{
background-color:green;color:white;
border:none;cursor:pointer;
width:50px;
height:30px;
position:relative;
left:100px;
margin-top:45px;
}


#spe{
width:50px;
height:30px;
background:white;
color:black;
border:none;cursor:pointer;
position:relative;
left:90px;
}


/* #spe{

margin-left:2px;
} */
</style>

</head>
<body>
	<div id="container">
		<form id="studentupdate">
					<h3>密码修改</h3>
					<table>
						
						<tr>
							<td class="img"><img src=""/>&nbsp;</td>
							<td><input type="text" name="unumber" placeholder="请输入旧密码" id="pwd"/></td>
						</tr>
						<tr>
							<td class="img"><img src=""/>&nbsp;</td>
							<td><input type="password" name="passwords1" placeholder="请输入新密码" id="passwords1"/></td>
						</tr>
						<tr>
							<td class="img"><img src=""/>&nbsp;</td>
							<td><input type="password" name="passwords2" placeholder="请输再次确认" id="passwords2"/></td>
						</tr>
						
					</table>
					<input type="button" value="确定" id="special"/>		
					<input type="reset" value="重置" id="spe"/>
				</form>
	</div>
</body>


<script type="text/javascript">

$(function(){
    var b=$("#pwd");
    var c=$("#special");
    
    c.click(function(success){
     var uPattern = /^[0-9]\d{0,8}$/;
     b=b.val();
     if(b==null||b==""){
      alert("原密码不能为空")
     }else{
      var flag=uPattern.test(b);
      if(flag){
       var d=$("#passwords1").val();
       if(d==null||d==""){
        alert("新密码不能为空")
       }else{
        $.ajax({
         type:"post",
         url:"http://localhost:8080/OnlineExam/StudentServlet?method=updatepassword",
         async:true,
         data:$("#studentupdate").serialize(),
         success:function(success){
          if(success=="success"){
           alert("密码修改成功!");
          window.location.href="Studentlogin.jsp";
          }else{
           alert("原密码错误");
           window.location.reload();
          }
         }
        });
       }
      }else{
        alert("密码格式不正确!");
       }
     }   
    });
   });
</script>
      
</html>