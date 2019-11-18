<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <META HTTP-EQUIV="pragma" CONTENT="no-cache">
		<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache,must-revalidate">
		<META HTTP-EQUIV="expires" CONTENT="0">
        <title>后台管理系统</title>
        <script type="text/javascript" src="../easyui/jquery.min.js" ></script>
        <script type="text/javascript" src="../easyui/jquery.easyui.min.js" ></script>
        <script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
        <link type="text/css" rel="stylesheet" href="../easyui/themes/icon.css" />
		<link type="text/css" rel="stylesheet" href="../easyui/themes/gray/easyui.css" />
		
		
		
    </head>
    
    <style>
    	.wu-sidebar { width:160px;}
		.wu-side-tree .tree-node { padding:15px 0px; }
		.wu-side-tree a { display:block;}
		.wu-side-tree .tree-node-selected { padding:15px 0; border:1px #fade23 solid;}
		#denglu{
    		position: absolute;
    		top:20%;
    		right: 5%;
    		width:25%;
    		height: 60%;
    		
    		
    	}
    </style>
    <body style="width: 100%;height: 100%;padding: auto;margin: auto;" >
    	
	    		
	    	
    	<div id="layout" class="easyui-layout" style="width:100%;height:100% ;">
    		<div id="logo" data-options="region:'north',title:'',split:false"  style="width: 100%;height: 15%;background-image: url(../img/pkm.jpg);" >
    				<div><img src="../img/cap.png" width="5%"><p style="display: inline;"><span style="font: 32px '隶书','';">一度教育在线考试系统后台</span></p></div>
    				<div id="denglu" style="text-align: right;">
    				<p style="font: 32px '隶书';display: inline;">欢迎</p><a href="" id="mb" class="easyui-menubutton"     
        data-options="menu:'#mm',iconCls:'icon-man'" style="width: 120px;height: 60px;">${sessionScope.user.unumber }</a>
    			</div>
    				
    		</div>
	    	<div id="left"  data-options="region:'west',title:'菜单栏',split:false"style="width: 15%;height: 80%; background-color: #CACACA;">
	    		<ul id="nav" class="easyui-tree wu-side-tree">
	    		</ul>
	    	</div>

	    
	    	<div id="rigth"  data-options="region:'center',title:'数据栏',split:false"style="width: 85%;height: 80%; background-image: url(../img/body.png);">
	    		<div id="tabs" class="easyui-tabs" style="width:100%;height:99%;">
	    			
	    		</div>
	    		
	    	</div>
	    	<div id="buttm"  data-options="region:'south',title:'',split:false"style="width: 85%;height: 10%; background-color:#CACACA;text-align:center">
	    		<p  class="footertitle" style="color:grey">COPYRIGHT 2007-2019 YIDUEDUCATION ALL RIGHTS RESERVERD</p>
				<p><a>加入平台 </a>一度教育 <a>湘ICP备12003739号</a> 系统版本3.0.0.233</p>
	    	</div>
 		</div>
 		
 		
 		<div id="indexdialog" class="easyui-dialog" title="权限" style="width:50%;height:80%;"
			 data-options="iconCls:'icon-add',resizable:false,modal:true" closed="true">
				
				<select id="chioce" name="pdmid">
					<option value="10">班主任</option>
					<option value="20">专业老师</option>
				</select>
				<ul id="deleteadd" class="easyui-tree ">
					
				</ul>
				<button id="aaa">提交</button>
			
		</div>
 		<div id="mm" style="width:150px;">   
	    <div data-options="iconCls:'icon-undo'" id="exict">退出</div>   
	    <div data-options="iconCls:'icon-edit'" id="uppassword">修改密码</div>  
       
	</div>  
	
	
	<div id="psddialog" class="easyui-dialog" title="修改密码" style="width: 300px;height: 500px;"
			data-options="iconCls:'icon-add',resizable:false,modal:true" closed="true">
		<form id="psdform">
			<input type="hidden" value="001" name="${sessionScope.user.uid }" />
			<table>
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="unumber" id="username" class="easyui-validatebox" value="${sessionScope.user.unumber }"></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="text" name="passwords" id="firstpsd" class="easyui-passwordbox" data-options="required:true,missingMessage:'请输入密码'"></td>
				</tr>
				<tr>
					<td>确定密码：</td>
					<td><input type="text" name="topasswords" id="secondpsd" class="easyui-passwordbox" data-options="required:true,missingMessage:'请确定密码'"></td>
				</tr>
				<tr>
					<td colspan="2">
					<a id="ok" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确定</a>
					<a id="cancel" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
 		<script type="text/javascript" src="../js/nav.js"></script>
    </body>
</html>