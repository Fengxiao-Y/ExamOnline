
 			$(function () {
	    		$('.easyui-tree').tree({
	        		onSelect: function (node) {
		            if (node.state == "closed")
		                $(this).tree('expand', node.target);
		            else
		                $(this).tree('collapse', node.target);
	       			 }
	   			 });
			});
			
			$(function(){
				$("#layout").layout();
			});
 			
			$(function(){
 				$("#nav").tree({
 				url:'http://localhost:8080/OnlineExam/Popedomservlet?method=treejson',
 				method:'get',
 				onLoadSuccess:function(){
 					$(".tree-icon,.tree-file").removeClass("tree-icon tree-file");
					$(".tree-icon,.tree-folder").removeClass("tree-icon tree-folder tree-folder-open tree-folder-closed");
 				},
 				onClick:function(node){
 					if(node.text=="查看学生信息"){
   						addTab(node.text,"http://localhost:8080/OnlineExam/back/student.html","icon-add");
   					}else if(node.text=="查看教师信息"){
   						addTab(node.text,"http://localhost:8080/OnlineExam/back/Teacher.html","");
   					}else if(node.text=="查看学生成绩"){
   						addTab(node.text,"http://localhost:8080/OnlineExam/back/StugradeCrud.html","");
   					}else if(node.text=="课程管理"){
   						addTab(node.text,"http://localhost:8080/OnlineExam/back/Course.html","")
   					}else if(node.text=="班级管理"){
   						addTab(node.text,"http://localhost:8080/OnlineExam/back/Squad.html","")
   					}else if(node.text=="试卷管理"){
   						addTab(node.text,"http://localhost:8080/OnlineExam/back/TestPaperCrud.html","")
   					}else if(node.text=="题目管理"){
   						addTab(node.text,"http://localhost:8080/OnlineExam/back/Topicbank.html","")
   					}else if(node.text=="发布考试"){
   						addTab(node.text,"http://localhost:8080/OnlineExam/back/ExamCrud.html","")
   					}else if(node.text=="发布通知"){
   						addTab(node.text,"http://localhost:8080/OnlineExam/back/Announce.html","")
   					}else if(node.text=="查看用户"){
   						addTab(node.text,"http://localhost:8080/OnlineExam/back/UsersCrud.html","")
   					}else if(node.text=="添加权限"){
   						$("#deleteadd").tree({
		 				url:'../data/tree.json',
		 				method:'get',
		 				checkbox:true,
		 				onLoadSuccess:function(){
	 					$(".tree-icon,.tree-file").removeClass("tree-icon tree-file");
						$(".tree-icon,.tree-folder").removeClass("tree-icon tree-folder tree-folder-open tree-folder-closed");
						
	 					}
		 				});
		 				//打开添加框
   						$("#indexdialog").dialog("open");
   						
   						var chioce=$("#chioce").val();
   						
   						$("#aaa").click(function(){
   							var arrstr="";
   							var arr=getTreeSelected();
   							
   							
   							for(var i=0;i<arr.length;i++){
   								
   								arrstr=arrstr+arr[i].id+",";
   							}
   							arrstr=arrstr.substring(0,arrstr.length-1);
   							
   							$.ajax({
   								type:"post",
   								url:"http://localhost:8080/OnlineExam/PdmmgServlet?method=add&chioce="+chioce,
   								async:true,
   								data:{"arr":arrstr},
   								dataType:"text",
   								success:function(success){
   									if(success=="success"){
   										$.messager.show({
   											title:"提示",
   											msg:"添加成功"
   										});
   									}else {
   										$.messager.show({
   											title:"提示",
   											msg:"添加失败"
   										});
   									}
   								}
   							});
   							
   							
   						});
   					}
   					else if(node.text=="删除权限"){
   						$("#deleteadd").tree({
   			 				url:'../data/tree.json',
   			 				method:'get',
   			 				checkbox:true,
   			 				onLoadSuccess:function(){
   		 					$(".tree-icon,.tree-file").removeClass("tree-icon tree-file");
   							$(".tree-icon,.tree-folder").removeClass("tree-icon tree-folder tree-folder-open tree-folder-closed");
   							
   		 					},
   		 					cascadeCheck:false,
   		 				onCheck : function(node, checked) {
   		 				  //判断是否为父节点
   		 				  if (node.id == null || node.id == '') {
   		 				   //获取子节点
   		 				   var children = $("#deleteadd").tree("getChildren",node.target);
   		 				   //全选 
   		 				   if (checked) {
   		 				    for (i in children) {
   		 				     $("#deleteadd").tree("check",children[i].target);
   		 				    }
   		 				   } else {
   		 				    //count为计数器
   		 				    var count = -1;
   		 				    for (i in children) {
   		 				     if (children[i].checked == true) {
   		 				      count = count + 1;
   		 				     }
   		 				    }
   		 				    //只有子节点全部为选中状态时，才会执行取消全选
   		 				    if (count + 1 == children.length) {
   		 				     for (i in children) {
   		 				      $("#deleteadd").tree("uncheck",children[i].target);
   		 				     }
   		 				    }
   		 				   }
   		 				  } else {
   		 				   //获取父节点
   		 				   var parentNode = $("#deleteadd").tree("getParent",
   		 				     node.target);
   		 				   //获取子节点
   		 				   var children = $("#deleteadd").tree("getChildren",parentNode.target);
   		 				   if (checked) {
   		 				    //count为计数器
   		 				    var count = -1;
   		 				    for (i in children) {
   		 				     if (children[i].checked == true) {
   		 				      count = count + 1;
   		 				     }
   		 				    }
   		 				    //当子节点全部为选中状态时，勾选父节点
   		 				    if (count + 1 == children.length) {
   		 				     $("#deleteadd").tree("check",parentNode.target);
   		 				    }
   		 				   } else {
   		 				    //取消勾选父节点 
   		 				    $("#deleteadd").tree("uncheck", parentNode.target);

   		 				   }
   		 				  }
   		 				 }
   			 				});
   			 				//打开添加框
   	   						$("#indexdialog").dialog("open");
   	   						
   	   						var chioce=$("#chioce").val();
   	   						
   	   						$("#aaa").click(function(){
   	   							var arrstr="";
	   	   						var nodes = $('#deleteadd').tree('getChecked');
					            var arr = new Array();
					            for (var i = 0; i < nodes.length;i++) {
					                arr.push(nodes[i]);
					            }
   	   							
   	   							for(var i=0;i<arr.length;i++){
   	   								
   	   								arrstr=arrstr+arr[i].id+",";
   	   							}
   	   							arrstr=arrstr.substring(0,arrstr.length-1);
   	   							
   	   							$.ajax({
   	   								type:"post",
   	   								url:"http://localhost:8080/OnlineExam/PdmmgServlet?method=delete&chioce="+chioce,
   	   								async:true,
   	   								data:{"arr":arrstr},
   	   								dataType:"text",
   	   								success:function(success){
   	   									if(success=="success"){
   	   										$.messager.show({
   	   											title:"提示",
   	   											msg:"删除成功"
   	   										});
   	   									}else {
   	   										$.messager.show({
   	   											title:"提示",
   	   											msg:"添加失败"
   	   										});
   	   									}
   	   								}
   	   							});
   	   							
   	   							
   	   						});
   					}
 					
 				}
 				
 			})
 				
 			});
 			
 			
 			
 			//修改密码
 			$("#uppassword").click(function(){
 				$("#username").attr("readonly","readonly");
 				$("#psddialog").dialog("open");
 			})
 			$("#ok").click(function(){
 				var first=$("#firstpsd").val();
 				var second=$("#secondpsd").val();
 				if((first!=null || first!="" ) &&(second!=null || second!="")){
 					if(first==second){
 						$.ajax({
 							type:"post",
 							url:"http://localhost:8080/OnlineExam/UserServlet?method=update",
 							async:false,
 							data:$("#psdform").serialize(),
 							dataType:"text",
 							//cache:false,
 							/*beforSend:function(xmlHttp){
 								xmlHttp.setRequestHeader("If-Modified-Since","0");
 								xmlHttp.setRequestHeader("Cache-Control","no-cache");
 							},*/
 							success:function(message){
						//判断服务器端返回的字符串内容:修改成功success,修改失败failure
						if(message.trim()=="success"){
							//右下角显示一个信息提示
							$.messager.show({
								title:"提示",
								msg:"密码修改成功!"
							});
							
							//添加成功后，把修改界面数据清空
							$("#psdform").form("reset");
							//把对话框关闭
							$("#psddialog").dialog("close");
							//退出用户登录 回到登录页面
							
						
							$(location).attr("href","http://localhost:8080/OnlineExam/back/login.html");
						}else{
							//右下角显示一个信息提示
							$.messager.show({
								title:"提示",
								msg:"密码修改失败!"
							});
						}
					}
 						});
 					}else{
 						$.messager.show({
 						title:"提示",
 						msg:"两次密码输入有误"
 					})
 					}
 				}else{
 					$.messager.show({
 						title:"提示",
 						msg:"请输入密码"
 					})
 				}
 			})
 			$("#cancel").click(function(){
		    //点击取消后,只需要把对话框关闭
		   $("#psddialog").dialog("close");    
		   });
 			//点击退出按钮 退出到登录页面
 			$("#exict").click(function(){
					$(location).attr("href","http://localhost:8080/OnlineExam/back/login.html");
			});
 			
 			
 			
function addTab(title, href,icon){
 var tt = $('#tabs');
 if (tt.tabs('exists', title)){//如果tab已经存在,则选中并刷新该tab     
        tt.tabs('select', title);
        refreshTab({tabTitle:title,url:href});
 } else {
     if (href){
      var content = '<iframe scrolling="no" frameborder="0"  src="'+href+'" style="width:100%;height:100%;"></iframe>';
     } else {
      var content = '未实现';
     }
     tt.tabs('add',{
      title:title,
      closable:true,
      content:content,
      iconCls:icon||'icon-default'
     });
 }
}
/**    
 * 刷新tab
 * @cfg 
 *example: {tabTitle:'tabTitle',url:'refreshUrl'}
 *如果tabTitle为空，则默认刷新当前选中的tab
 *如果url为空，则默认以原来的url进行reload
 */
function refreshTab(cfg){
 var refresh_tab = cfg.tabTitle?$('#tabs').tabs('getTab',cfg.tabTitle):$('#tabs').tabs('getSelected');
 if(refresh_tab && refresh_tab.find('iframe').length > 0){
 var _refresh_ifram = refresh_tab.find('iframe')[0];
 var refresh_url = cfg.url?cfg.url:_refresh_ifram.src;
 //_refresh_ifram.src = refresh_url;
 _refresh_ifram.contentWindow.location.href=refresh_url;
 }
}





function getTreeSelected()
{
    
    var nodes = $('#deleteadd').tree('getChecked');
    var arr = new Array();
    for (var i = 0; i < nodes.length;i++) {
        arr.push(nodes[i]);
        myFuc(nodes[i]);
    }
    return arr;

    //内部递归函数
    function myFuc(n) {
        var parent = $('#deleteadd').tree('getParent', n.target);
        if (parent == null) return;
        if (isExistItem(parent)) return;
        arr.push(parent);
        myFuc(parent);
    }
    //验证节点是否已存在数组中
    function isExistItem(item)
    {
        var flag = false;
        for (var i = 0; i < arr.length;i++)
        {
            if (arr[i] == item) {
                flag = true; break;
            }
        }
        return flag;
    }
}