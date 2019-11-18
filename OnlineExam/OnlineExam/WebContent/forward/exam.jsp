<%@page import="java.util.List"%>
<%@page import="com.yidu.victory.excle.domain.Topicbank"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>考试页面</title>
        <link rel="stylesheet" href="../css/jquery.countdown.css" />
        <script type="text/javascript" src="../js/examjsp.js"></script>
        
        <script type="text/javascript" src="../easyui/jquery.min.js" ></script>
        <script type="text/javascript" src="../easyui/jquery.easyui.min.js" ></script>
        <script type="text/javascript" src="../js/jquery.json.min.js" ></script>
        <script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
        <link type="text/css" rel="stylesheet" href="../easyui/themes/icon.css" />
		<link type="text/css" rel="stylesheet" href="../easyui/themes/gray/easyui.css" />
        
        <!-- 隐藏、显示时间按钮 -->
        <script type="text/javascript">
		function hiddenTime(countdown){
			if(countdown.style.display == "none"){
				countdown.style.display="";
				$(".showtime").val("隐藏时间");
			}else{
				countdown.style.display="none";
				$(".showtime").val("显示时间");
			}
		}
	</script>

	
	<script type="text/javascript">
			var nowindex=0;
			var answer=new Map();
			var leftSeconds;
			$(function(){
				$.ajax({
					type:"get",
					url:"http://localhost:8080/OnlineExam/Getsquad?method=gettime",
					async:true,
					dataType:"text",
					success:function(time){
						leftSeconds=time;
						var intervalId=0;
							
						intervalId=setInterval("CountDown("+leftSeconds+")",1000);
					}
				});
				
				//循环添加标签
				for(var i=0;i<50;i++){
					var x=i+1;					
					$("#select").append("<input type='button' class='page' id='tihao"+i+"' value='"+x+"' >");

					
				}
							
				$.ajax({
					type:"post",
					url:"http://localhost:8080/OnlineExam/Gettop",
					async:true,
					dataType:"json",
					success:function(data){
						//课程题目
						$("#cname").text(data[0].cname);
						$("#aans").text(data[0].aresult);
						$("#bans").text(data[0].bresult);
						$("#cans").text(data[0].cresult);
						$("#dans").text(data[0].dresult);
						$("#eans").text(data[0].eresult);
						$("#fans").text(data[0].fresult);
						if(data[0].testtype=="多选"){
							$("#E").css("display","");
							$("#F").css("display","");
							$(".abab").attr("type","checkbox");
							
						}else{
							$("#E").css("display","none");
							$("#F").css("display","none");
							$(".abab").attr("type","radio");
							
						}
						$("#testtype").text(data[0].testtype);
						$("#content").text(data[0].content);
						$("#testid").text(data[0].testid);
						
						$("#select").on("click",".page",function(){
							
							
							var oldindex=nowindex;
							var testid=$("#testid").text();
							
						
							
							 if($("#testtype").text()=="单选"){  
									var chioce=null;
									chioce=$("input[name=selection]:checked").val();
									$("#E").css("display","none");
									$("#F").css("display","none");
									if(chioce!=null){
										//选了选项  B颜色
										$("#tihao"+nowindex+"").css("background-color","green");
											answer.set(testid,chioce);

									}else{
										//没选  A颜色
										$("#tihao"+nowindex+"").css("background-color"," ");
									}
								} else if($("#testtype").text()=="多选"){
									var chekch=[];
									$("#E").css("display","");
									$("#F").css("display","");
								 $("input[name='selection']:checked").each(function(i){
									 chekch.push($(this).val());
									 
								 })
									if(chekch!=null&&chekch.length>0){
										
										//选了选项  B颜色
										$("#tihao"+nowindex+"").css("background-color","green");
											answer.set(testid,chekch);
										
										
									}else{
										//没选  A颜色
										$("#tihao"+nowindex+"").css("background-color"," ");
									}
							 }
							 
							
							
							var s=parseInt(window.event.srcElement.value-1);
							
							$("#aans").text(data[s].aresult);
							$("#bans").text(data[s].bresult);
							$("#cans").text(data[s].cresult);
							$("#dans").text(data[s].dresult);
							$("#eans").text(data[s].eresult);
							$("#fans").text(data[s].fresult);
							if(data[s].testtype=="多选"){
								$("#E").css("display","");
								$("#F").css("display","");
								$(".abab").attr("type","checkbox");
							}else{
								$("#E").css("display","none");
								$("#F").css("display","none");
								$(".abab").attr("type","radio");
							}
							$("#testtype").text(data[s].testtype);
							$("#content").text(data[s].content);
							$("#testid").text(data[s].testid);
							//清空他选择的选项
							$(".abab").removeAttr('checked');
							nowindex=s;
						})
						
						
					}
				});
				
				$("#submit").click(function(){
					console.log(answer);
					var str=JSON.stringify([...answer]);
					
					$.ajax({
						type:"post",
						url:"http://localhost:8080/OnlineExam/Getsquad?method=score",
						async:true,
						data:{"str":str},
						success:function(){
							window.open("","_self").close();
						}
					});
					
				});	
				
				
				
				
				
				
			});
			
			function CountDown(){	
				if($("#countdown")){
					if(leftSeconds<=0){
						//结束考试提交试卷 把answer提交到后台去就可以了
						var str=JSON.stringify([...answer]);
						$.ajax({
							type:"post",
							url:"http://localhost:8080/OnlineExam/Getsquad?method=score",
							async:true,
							data:{"str":str}					
						});
						clearInterval(0);
					}else{
						leftSeconds--;
						$("#countdown").text(parseInt(leftSeconds/60)+"分"+leftSeconds%60+"秒");
					}
				}
						}
			
			
			//当关闭窗口时提示是否提交考试
			window.onunload= function()  {
				var str=JSON.stringify([...answer]);
				$.ajax({
					type:"post",
					url:"http://localhost:8080/OnlineExam/Getsquad?method=score",
					async:true,
					data:{"str":str}				
				});
			}
			
			//关闭后提交数据
			window.onbeforeunload = function(){
				  
				  return "当前数据还没有保存，关闭、刷新或切换窗口会自动完成考试，是否继续?";	
				}
			
			
			
			
			
			
			
		</script>
	
	
	
    </head>
    <body>
    	<div id="first_one">
    		
    		<div class="second_one">
    			
    			<div>
    				<form  id="" >
    					<table>
    						<tr id="third_one">
    							<td class="p_aa" id="cname"></td>
    						</tr>
    						<tr class="third_two">
    							<td id="testid" style="display:none"></td>
    							<td id="testtype"></td>
    							<td id="content"></td>
    						</tr>	
    						<tr class="takebuttonA">
    							<td ><input type="radio" class="abab" id="A" name="selection" value="A"/>    								
    							</td>
    							<td id="aans"></td>
    						</tr>
    						<tr class="takebuttonB">
    							<td ><input type="radio" class="abab" id="B" name="selection" value="B"/>	
    							</td>
    							<td id="bans"></td>
    						</tr>
    						<tr class="takebuttonC">
    							<td><input type="radio" class="abab" id="C" name="selection" value="C"/>			
    							</td>
    							<td id="cans"></td>
    						</tr>
    						<tr class="takebuttonD">
    							<td><input type="radio" class="abab" id="D" name="selection" value="D"/>	
    							</td>
    							<td id="dans"></td>
    						</tr>
    						<tr class="takebuttonE">
    							<td><input type="radio" class="abab" id="E" name="selection" value="E"/>	
    							</td>	
    							<td id="eans"></td>
    						</tr>
    						<tr class="takebuttonF">
    							<td><input type="radio" class="abab" id="F" name="selection" value="F"/>	
    							</td>
    							<td id="fans"></td>
    						</tr>
    						
    						
    						
    						<tr><!-- 正确答案，练习时可以看到的  -->
    							<td ><input type="button" id="rightsult"  name=""/>
    								
    							</td>
    						</tr>
    					</table>
    					
    				</form>
    			</div>
				<div  id="select" >
					
				</div>
				<div id="countdown">
					
				</div>
				<div id="countdown2">
					<input type="button" class="showtime" value="隐藏时间" onclick="hiddenTime(countdown);" />
					<input type="button" id="submit" class="take" value="提交试卷"   />
				</div>
				
			</div>
			
		</div>
 	</body>
 	
</html>