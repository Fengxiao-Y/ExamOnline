<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../easyui/jquery.min.js" ></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js" ></script>
<script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
<link type="text/css" rel="stylesheet" href="../easyui/themes/icon.css" />
<link type="text/css" rel="stylesheet" href="../easyui/themes/gray/easyui.css" />
		
		
<link rel="stylesheet" type="text/css" href="../resources/layui/css/layui.css" /> 
<link rel="stylesheet" type="text/css" href="../css/studenthomepage.css" /> 
<script type="text/javascript" src="../resources/layui/layui.js"></script>

</head>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header" style="color:#7bc9ed">
    <div class="layui-logo" style="color:red"><h3><a href="#" style="color:orange;">一度教育在线考试系统</a></h3></div>
   <script type="text/javascript">
   //如果用户点击此超链接，就重新刷新页面，回到首页
   	$(function(){
		$("#refresh").click(function(){
   			window.location.reload();
   		});
   	});
   		
   </script>
  <!-- 头部区域（可配合layui已有的水平导航） -->
  <ul class="layui-nav layui-layout-left">
    <li class="layui-nav-item"><a href="" id="refresh">首页</a></li>
    <li class="layui-nav-item"><a href="">管理</a></li>
    <li class="layui-nav-item"><a href="">用户</a></li>
    <li class="layui-nav-item">
      <a href="javascript:;">其它系统</a>
      <dl class="layui-nav-child">
        <dd><a href="">邮件管理</a></dd>
        <dd><a href="">消息管理</a></dd>
        <dd><a href="">授权管理</a></dd>
      </dl>
    </li>
  </ul>
  <ul class="layui-nav layui-layout-right">
    <li class="layui-nav-item">
      <a href="#">
        <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
        		 <font style='color:red;font-size:12px'>你好,</font> 
        		<font id="studentname" style="color:red;font-size:12px">${sessionScope.stu.sname }</font>
      </a>
    		
      <dl class="layui-nav-child">
        <dd><a href="" id="updatepwd">修改个人密码</a></dd>
        
      </dl>
    </li>
    <li class="layui-nav-item"><a href="http://localhost:8080/OnlineExam/forward/Studentlogin.jsp" id="exit">退出</a></li>
  </ul>
   <script type="text/javascript">
    	$(function(){
    		$("#exit").click(function(){
    			var str=window.confirm("确定退出吗?");
    		})
    	});
    	 	
    </script>
    
</div>

<div class="layui-side layui-bg-black">
  <div class="layui-side-scroll">
    <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
    <ul class="layui-nav layui-nav-tree"  lay-filter="test">
      <li class="layui-nav-item layui-nav-itemed">
        <a class="" href="javascript:;" >查看信息</a>
        <dl class="layui-nav-child">
          <dd><a href="javascript:;" id="search" >查看个人信息</a></dd>
   		<script>
   			$("#search").click(function(){
   				$(".layui-body").html("<iframe src='showselfumessage.jsp'"+"style='width: 100%;height: 100%;'"+"></iframe>")
   			}); 
   		</script>
          <dd><a href="javascript:;" id="checkscore">查看成绩</a></dd>
          <script>
          $("#checkscore").click(function(){
 				$(".layui-body").html("<iframe src='CheckScore.jsp'"+"style='width: 100%;height: 100%;'"+"></iframe>")
 			}); 
          </script>
           </dl>
      </li>
      <li class="layui-nav-item">
        <a href="javascript:;">在线考试</a>
        <dl class="layui-nav-child">
          <dd><a href="#" id="startexam">开始考试</a></dd>
        </dl>
      </li>
  
      <li class="layui-nav-item">
     <a href="javascript:;">在线练习</a>
        <dl class="layui-nav-child">
          <dd><a href="#" id="startexcle">开始练习</a></dd>
        </dl>
        </li>
      <li class="layui-nav-item">
      </li>
    </ul>
  </div>
</div>
 <!-- 内容主体区域 -->
<div class="layui-body" id="main">
 <!--
 	设置主题区域的内边距
 -->

      <div style="padding: 10px;">
  
    	<div class="layui-carousel" id="test1">
    
  <div carousel-item>
  	<div><img src="../img/摄图网_500557450.jpg"/></div>
  	<div><img src="../img/摄图网_500493656.jpg"/></div>
  	  <div><img src="../img/bigdata.jpg"/></div>
    <div><img src="../img/摄图网_501303754.jpg"/></div>
    <div><img src="../img/摄图网_500525873.jpg"/></div>
    
	
  </div>
  	
</div>
  	<div id="ss" style="width:29%;height:280px;;margin-left:10px;float:left;">
		<div class="aboutexam"><span class="schoolnotice">校园公告</span><a class="more" href="#">更多></a></div>
		<div class="ullist">
				<p></p></br>
				<p><a class="news" href="affairs.html">一度教育考试相关规定《考生必读》</a></p></br>
				<p><a class="news" href="#">湖南省长沙市一度教育2019年考试公告</a></p></br>
				<p><a class="news" href="#">【2019年湖南省自学考试】报考通知</a></p></br>
				<p><a class="news" href="#">19年长沙教师考试，报名即将开始</a></p></br>
				<p><a class="news" href="#">长沙中级职称，湖南省职称评审中心</a></p></br>
				<p><a class="news" href="#">顶级大佬马云来我校参观</a></p></br>
				<p><a class="news" href="#">一度教育校学习标兵</a></p></br>
		
		</div>
</div> 
<div id="ss" style="width:100%;height:320px;
	margin-top:10px;float:left;">
	<ul class="ul">
		<li class="cel"><a href="#" style="color:white;">最美教师</a></li>
		<li class="cell"><a href="#" style="color:white;">教研资讯</a></li>
		
	</ul>
	<a href="#" id="shefujun">更多></a>
	<hr/>
	<div class="small"><a href="xueshubu.html"><img src="../img/psb (1).jpg" title="学术部"/></a></div>
	<div class="smallimg"><a href="shelaoshi.html"><img src="../img/psb (4).jpg" title="佘老师"/></a></div>
	<div class="smallimg"><a href="teachingdept.html"><img src="../img/psb.jpg"  title="教学部门"/></a></div>
	<div class="smallimg"><a href="yiduedu.html"><img src="../img/yidu.jpg" title="一度教育"/></a></div>
	<div class="smallimg"><a href="zhanglaoshi.html"><img src="../img/zhanglaoshi.jpg" title="张老师"/></a></div>
	
		
	</div>
	
<!-- 条目中可以是任意内容，如：<img src=""> -->


<script>
layui.use('carousel', function(){
  var carousel = layui.carousel;
  //建造实例
  carousel.render({
    elem: '#test1'
    ,width: '70%' //设置容器宽度
    ,arrow: 'always' //始终显示箭头
    //,anim: 'updown' //切换动画方式
  });
});
</script>
    </div>
  </div>
  
  <div class="layui-footer" style="background-color:black;color:white;">
  <!-- 底部固定区域 -->
   	<font>长沙市一度教育软件学院 </font>
   	
   	<span class="last"><p>湘ICP备081524785-1号 联系电话:0731-85318888<p/>
   		  <p id="email">邮箱:support@yiduedu.com<p/>
   	</span>
   		
 	 
  </div>
</div>

<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
</script>

<div id="excdialog" class="easyui-dialog" title="测试内容" style="width: 300px;height: 500px;"
			data-options="iconCls:'icon-add',resizable:false,modal:true" closed="true">
			<form id="exclform">
				<select id="classname" name="classname">
				</select>
				<a id="choice" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确定</a>
			</form>
</div>



</body>
<script type="text/javascript">
        	$(function(){
        		$("#updatepwd").click(function(){
        			open("updatepassword.jsp",true);
        		});
        	});
        			
        			
        </script>
        
        <script type="text/javascript">
        	$("#startexcle").click(function(){
        		
        		
        		$.ajax({
        			type:"post",
        			url:"http://localhost:8080/OnlineExam/Getcourse",
        			async:true,
        			dataType:"json",
        			success:function(data){
        				
        				console.log(data);
        				console.log(data.length);
        				var htm="";
        				$("#classname").html("");
        				for(var i=0;i<data.length;i++){
        					htm+="<option value='"+data[i].cname+"'>"+data[i].cname+"</option>"
        				}
        				
        				$("#classname").append(htm);
        				
        			}
        		});
			        $("#excdialog").dialog("open");
        	});
        	
        	
        	$("#startexam").click(function(){
        		$.ajax({
        			type:"post",
        			url:"http://localhost:8080/OnlineExam/Getsquad?method=getexam",
        			async:true,
        			dataType:"text",
        			success:function(data){
        				if(data=="nice"){
        					$(location).attr("href","http://localhost:8080/OnlineExam/forward/exam.jsp")
        				}else if(data=="notexam"){
        					$.messager.show({
        						title:"提示",
        						msg:"当前没有考试"
        					});
        				}else if(data=="toafter"){
        					$.messager.show({
        						title:"提示",
        						msg:"考试已经结束"
        					});
        				}else if(data=="noangain"){
        					$.messager.show({
        						title:"提示",
        						msg:"考试完成无法重复考试"
        					});
        				}else if(data=="tobefore"){
        					$.messager.show({
        						title:"提示",
        						msg:"考试还没开始请耐心等待"
        					});
        				}
        			}
        		});
        	});
        	
        	
        	
        	
        	
        	
$("#choice").click(function(){
        		
        		$.ajax({
        			type:"post",
        			url:"http://localhost:8080/OnlineExam/Getsquad?method=getexcle",
        			async:true,
        			data:$("#exclform").serialize(),
        			dataType:"text",
        			success:function(data){
        				if(data=="success"){
        					$(location).attr("href","http://localhost:8080/OnlineExam/forward/excle.jsp")
        				}else{
        					$.messager.show({
        						title:"提示",
        						msg:"题库中没有这门课程的试题"
        					});
        				}
        			}
        		});
        	});
        	
        	
        </script>
        
</html>