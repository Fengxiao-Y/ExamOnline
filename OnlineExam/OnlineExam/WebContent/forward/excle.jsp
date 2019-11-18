<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>考试页面</title>
        <link rel="stylesheet" href="../css/jquery.countdown.css" />
        <!--<script type="text/javascript" src="../js/examjsp.js"></script>-->
        <script type="text/javascript" src="../easyui/jquery.min.js" ></script>
        <script type="text/javascript" src="../easyui/jquery.easyui.min.js" ></script>
        <script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
        <link type="text/css" rel="stylesheet" href="../easyui/themes/icon.css" />
		<link type="text/css" rel="stylesheet" href="../easyui/themes/gray/easyui.css" />
        
        <!-- 隐藏、显示时间按钮 -->
        <script type="text/javascript">
		function hiddenTime(countdown){
			if(countdown.style.display == "none"){
				countdown.style.display="";
				$(".showtime").val("隐藏答案");
			}else{
				countdown.style.display="none";
				$(".showtime").val("显示答案");
			}
		}
	</script>
	<script>
		$(function(){
			var s=0;
			$.ajax({
				type:"get",
				url:"http://localhost:8080/OnlineExam/Getsquad?method=doexcle",
				async:true,
				dataType:"json",
				success:function(data){
					$("#countdown").css("display","none");
					$(".showtime").val("显示答案");
					//课程题目
					$("#countdown").text(data[s].rightsult);
					$("#cname").text(data[s].cname);
					$("#aans").text(data[s].aresult);
					$("#bans").text(data[s].bresult);
					$("#cans").text(data[s].cresult);
					$("#dans").text(data[s].dresult);
					$("#eans").text(data[s].eresult);
					$("#fans").text(data[s].fresult);
					if(data[0].testtype=="多选"){
						$(".abab").attr("type","checkbox");
					}else{
						$(".abab").attr("type","radio");
					}
					$("#testtype").text(data[s].testtype);
					$("#content").text(data[s].content);
					$("#testid").text(data[s].testid);
				
					
					$("#next").click(function(){										
						s+=1;
						//判断是否还有下一题
						if(data[s]==null){
							
						}
						$("#countdown").css("display","none");
						$(".showtime").val("显示答案");
						//课程题目
						$("#countdown").text(data[s].rightsult);
						$("#aans").text(data[s].aresult);
						$("#bans").text(data[s].bresult);
						$("#cans").text(data[s].cresult);
						$("#dans").text(data[s].dresult);
						$("#eans").text(data[s].eresult);
						$("#fans").text(data[s].fresult);
						if(data[s].testtype=="多选"){
							$(".abab").attr("type","checkbox");
						}else{
							$(".abab").attr("type","radio");
						}
						$("#testtype").text(data[s].testtype);
						$("#content").text(data[s].content);
						$("#testid").text(data[s].testid);
						//清空他选择的选项
						$(".abab").removeAttr('checked');
					})
					
					
					
					$("#last").click(function(){	
						
						if(s>0){
							s-=1;
							$("#countdown").css("display","none");
							$(".showtime").val("显示答案");
							//课程题目
							$("#countdown").text(data[s].rightresult);
							$("#aans").text(data[s].aresult);
							$("#bans").text(data[s].bresult);
							$("#cans").text(data[s].cresult);
							$("#dans").text(data[s].dresult);
							$("#eans").text(data[s].eresult);
							$("#fans").text(data[s].fresult);
							if(data[s].testtype=="多选"){
								$(".abab").attr("type","checkbox");
							}else{
								$(".abab").attr("type","radio");
							}
							$("#testtype").text(data[s].testtype);
							$("#content").text(data[s].content);
							$("#testid").text(data[s].testid);
							//清空他选择的选项
							$(".abab").removeAttr('checked');
						}
					})
					
					
				
				}
			});
		});
	
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
    							<td ><input type="button" id="rightsult"  name="selection"/>
    								
    							</td>
    						</tr>
    					</table>
    					
    				</form>
    			</div>
				<div  id="select" name="choose">
					<input type="button" class="last" value="上一题"  id="last">
					<input type="button" class="next" value="下一题"  id="next">
				</div>
				<div id="countdown">
					
				</div>
				<div id="countdown2">
					<input type="button" class="showtime" value="显示答案" onclick="hiddenTime(countdown);" />
					<input type="button" class="take" value="提交试卷"  style="display:none"/>
				</div>
				
			</div>
			
		</div>
 	</body>
 	<script type="text/javascript">
			
		</script>
</html>